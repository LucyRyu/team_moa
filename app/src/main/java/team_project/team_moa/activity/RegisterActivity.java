package team_project.team_moa.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import team_project.team_moa.R;

import static team_project.team_moa.R.*;

/**
 * Created by user on 2015-11-04.
 */
public class RegisterActivity extends AppCompatActivity {

    EditText et_id, et_pwd, et_name, et_school, et_email, et_major;
    EditText et_Skill1, et_Skill2, et_Skill3;
    EditText et_Activity;
    //EditText et_devel, et_PM, et_desi, et_team, et_crew;



    Button bt_sign;
    ScrollView scrollView;
    Boolean confirmFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_register);
        et_id =(EditText) findViewById(id.reg_id);
        et_pwd = (EditText) findViewById(id.reg_pwd);
        et_name = (EditText) findViewById(id.reg_name);
        et_school = (EditText) findViewById(id.reg_school); //수정
        et_major = (EditText) findViewById(id.reg_major);
        et_Skill1 = (EditText) findViewById(id.reg_Skill1);
        et_Skill2 = (EditText)findViewById(id.reg_Skill2);
        et_Skill3 = (EditText)findViewById(id.reg_Skill3);
        et_Activity = (EditText)findViewById(id.reg_Activity);
        et_email = (EditText)findViewById(id.reg_email);







        bt_sign = (Button) findViewById(id.sign_in);
        scrollView = (ScrollView) findViewById(id.register);

        scrollView.setVerticalScrollBarEnabled(false);

        bt_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check() == true){
                    new ConfirmTask().execute();

                }
                //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //startActivity(intent);
            }
        });









    }

    public boolean check(){
        if (et_id.getText().toString().equals("")) {
            et_id.requestFocus();
            Toast.makeText(getApplicationContext(), "아이디을 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_pwd.getText().toString().equals("")) {
            et_pwd.requestFocus();
            Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
     /*  if (et_name.getText().toString().equals("")) {
            et_name.requestFocus();
            Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_school.getText().toString().equals("")) {
            et_school.requestFocus();
            Toast.makeText(getApplicationContext(), "학교를 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_email.getText().toString().equals("")) {
            et_email.requestFocus();
            Toast.makeText(getApplicationContext(), "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_major.getText().toString().equals("")) {
            et_major.requestFocus();
            Toast.makeText(getApplicationContext(), "전공을 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }



    //여기부터 서버와 연동

    private class ConfirmTask extends AsyncTask<String, Void, String> {  //아이디 중복검사 태스크
        @Override
        protected String doInBackground(String... strs) {

            return ConfirmSend();  //JSP로 파라미터 보내고 JSON 받는 메서드
        }
        @Override
        protected void onPostExecute(String result) {  // doInBackground() 메서드의 리턴값이 여기의 파라미터로 반환된다
            Log.v("result값", result);
            ConfirmGet(result);  //JSP로부터 받은 JSON을 해석하고 해석한 값을 사용하는 메서드
            if(confirmFlag == true){  //아이디 중복여부. ConfirmGet(result)메서드를 통해 받은 값
                new RegisterTask().execute();  //중복되지 않으므로 회원가입 태스크 실행
                Toast.makeText(getApplicationContext(), "가입완료", Toast.LENGTH_SHORT).show();
                finish();  //액티비티 종료
            } else{
                et_id.requestFocus();  //ID입력창에 포커스를 줌
                Toast.makeText(getApplicationContext(), "이미 존재하는 아이디 입니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String ConfirmSend(){
        String str = "";
        try{

            HttpClient client = new DefaultHttpClient();
            String postURL = LoginActivity.server_Ip + "/TeamMoa/confirm.jsp";  //연결할 JSP의 URL주소

            HttpPost post = new HttpPost(postURL);
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            //params.add(new BasicNameValuePair("식별값", 전송할 데이터));
            params.add(new BasicNameValuePair("id", et_id.getText().toString()));  //JSP로 전송할 파라미터 추가

            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
            post.setEntity(ent);
            HttpResponse responsePOST = client.execute(post);
            HttpEntity resEntity = responsePOST.getEntity();

            if (resEntity != null) {
                str = EntityUtils.toString(resEntity);
            }
            Log.i("str값", str);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }

    public void ConfirmGet(String Json){  //Json 파싱

        try {
            JSONArray ja = new JSONArray(Json);  //JSONArray 값 받음
            for(int i = 0; i<ja.length(); i++){  //JSONArray 값을 한줄씩 검사
                JSONObject order = ja.getJSONObject(i);
                //order.getString("식별값")

                if(order.getString("flag").equals("1")){  //order.getString("falg") 값이 "1"일때
                    confirmFlag = false;  //아이디 중복
                } else if(order.getString("flag").equals("0")){
                    confirmFlag = true;  //아이디 중복아님
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private class RegisterTask extends AsyncTask<String, Void, String> {  //회원가입 태스크
        @Override
        protected String doInBackground(String... strs) {

            return RegisterSend();  //회원정보 전송
        }

        //JSON 받을 필요 없음

    }




    public String RegisterSend(){
        String str = "";
        try{

            HttpClient client = new DefaultHttpClient();
            String postURL = LoginActivity.server_Ip + "/TeamMoa/register.jsp";

            HttpPost post = new HttpPost(postURL);
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("id", et_id.getText().toString()));  //회원가입에 필요한 파라미터 전송
            params.add(new BasicNameValuePair("pwd", et_pwd.getText().toString()));
            params.add(new BasicNameValuePair("name", et_name.getText().toString()));
            params.add(new BasicNameValuePair("school", et_school.getText().toString()));
            params.add(new BasicNameValuePair("major", et_major.getText().toString()));
            params.add(new BasicNameValuePair("account_Skill1", et_Skill1.getText().toString()));
            params.add(new BasicNameValuePair("account_Skill2", et_Skill2.getText().toString()));
            params.add(new BasicNameValuePair("account_Skill3", et_Skill3.getText().toString()));
            params.add(new BasicNameValuePair("Activity", et_Activity.getText().toString() ));
            params.add(new BasicNameValuePair("Email", et_email.getText().toString()));
          //  params.add(new BasicNameValuePair("devel",et_devel.getText().toString()));
          //  params.add(new BasicNameValuePair("PM", et_PM.getText().toString()));


            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
            post.setEntity(ent);
            HttpResponse responsePOST = client.execute(post);
            HttpEntity resEntity = responsePOST.getEntity();

            if (resEntity != null) {
                str = EntityUtils.toString(resEntity);
            }
            Log.i("str값", str);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }
}