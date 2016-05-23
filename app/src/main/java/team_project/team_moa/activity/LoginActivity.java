package team_project.team_moa.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
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

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    public static String server_Ip = "http://220.149.12.226:8080";
    public static int account_Idx;
    boolean isLogout = false;

    SharedPreferences setting;
    SharedPreferences.Editor editor;

    ScrollView scrollView;

    private final static String TAG = "LoginActivity";
    // implements LoaderCallbacks<Cursor>
    private Button button;
    private TextView register;
    private EditText et_Id, et_Pwd;
    private Button fbbutton;
    private CheckBox cb_auto;

    String getJson;

    boolean sw = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //     FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

        setting = getSharedPreferences("setting", 0);
        editor= setting.edit();

        Intent i = getIntent();
        isLogout = i.getBooleanExtra("logout", false);

        //editor.putBoolean("auto_Check", false);

        if(isLogout){
            editor.clear();
            editor.commit();
        }

        if(setting.getBoolean("auto_Check", false)){
            account_Idx = setting.getInt("aIdx", -1);
            if(account_Idx != -1){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }

        scrollView = (ScrollView)findViewById(R.id.login);
        scrollView.setVerticalScrollBarEnabled(false);

        et_Id = (EditText) findViewById(R.id.et_Login_Id);
        et_Pwd = (EditText) findViewById(R.id.et_Login_Password);
        button = (Button) findViewById(R.id.button);
        register = (TextView) findViewById(R.id.register);
        register.setPaintFlags(register.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        cb_auto = (CheckBox) findViewById(R.id.auto_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check()){
                    new LoginTask().execute();
                    while (!sw) {
                        try {
                            Log.i("wait", "wait");
                            Thread.sleep(100); // 1초 = 1000밀리초
                        } catch (InterruptedException ignore) {
                        }
                    }
                    sw = false;
                    LoginGet(getJson);
                }

/*
                //밑으로는 임시
                account_Idx = 41;

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                //여기까지 임시*/
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean check(){
        if (et_Id.getText().toString().equals("")) {
            et_Id.requestFocus();
            Toast.makeText(getApplicationContext(), "아이디를 입력해주세요", Toast.LENGTH_LONG).show();
            return false;
        }
        if (et_Pwd.getText().toString().equals("")) {
            et_Pwd.requestFocus();
            Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private class LoginTask extends AsyncTask<String, Void, String> {  //아이디 중복검사 태스크
        CustomProgressDialog progressDlg = new CustomProgressDialog(LoginActivity.this);
        protected void onPreExecute() {

            progressDlg.getWindow().setBackgroundDrawable(
                    new ColorDrawable(
                            android.graphics.Color.TRANSPARENT));
            progressDlg.show();

            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... strs) {
            getJson = LoginSend();
            sw = true;
            return getJson;  //JSP로 파라미터 보내고 JSON 받는 메서드
        }

        @Override
        protected void onPostExecute(String result) {  // doInBackground() 메서드의 리턴값이 여기의 파라미터로 반환된다
            progressDlg.dismiss(); // 없애기
            super.onPostExecute(result);

        }

    }

    private String LoginSend() {
        Log.i("순서", "send");
        String str = "";
        try {

            HttpClient client = new DefaultHttpClient();
            String postURL = server_Ip + "/TeamMoa/Login.jsp";  //연결할 JSP의 URL주소

            HttpPost post = new HttpPost(postURL);
            List params = new ArrayList();

            //params.add(new BasicNameValuePair("식별값", 전송할 데이터));
            params.add(new BasicNameValuePair("id", et_Id.getText().toString()));  //JSP로 전송할 파라미터 추가
            params.add(new BasicNameValuePair("pwd", et_Pwd.getText().toString()));

            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
            post.setEntity(ent);
            HttpResponse responsePOST = client.execute(post);
            HttpEntity resEntity = responsePOST.getEntity();

            if (resEntity != null) {
                str = EntityUtils.toString(resEntity);
            }
            Log.i("str값", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public void LoginGet(String Json) {  //Json 파싱
        Log.i("순서", "get");


        try {
            JSONArray ja = new JSONArray(Json);  //JSONArray 값 받음
            JSONObject order = ja.getJSONObject(0);
            if (order.getInt("LoginCheck") == 1) {
                account_Idx = Integer.parseInt(order.getString("AccountIdx"));
                //Toast.makeText(getApplicationContext(), et_Id.getText().toString(), Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), et_Pwd.getText().toString(), Toast.LENGTH_LONG).show();

                if(cb_auto.isChecked()){
                    editor.putInt("aIdx", account_Idx);
                    editor.putBoolean("auto_Check", true);
                    editor.commit();
                }

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            } else if (order.getInt("LoginCheck") == 0) {
                Toast.makeText(getApplicationContext(), "비밀번호가 틀렸습니다.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "존재하지 않는 아이디입니다.", Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}