package team_project.team_moa.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import team_project.team_moa.R;

/**
 * Created by LUCY on 2016-05-10.
 */
public class MemberActivity extends Activity {


    /*
        SQLiteDatabase db;
        MySQLiteOpenHelper helper;
        // 전역변수로 사용할 것들을 미리 빼두었다.
    */


    /*
    ListView list;
    MemberList_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;

    final static String dbName = "account.db";
    final static int dbVersion = 2;
*/

    ListView listView;

    ArrayList<HashMap<String, String>> arrList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_list_first);

        /*
        list = (ListView)findViewById(R.id.memberlist);
        dbHelper = new MemberList_DBHelper(this, dbName, null, dbVersion);

        selectDB();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                cursor.moveToPosition(position);
                String str = cursor.getString(cursor.getColumnIndex("name"));
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
        */

        listView = (ListView) findViewById(R.id.memberlist);
        arrList = new ArrayList<HashMap<String, String>>();

        String json_str = getJsonData();

        try{
            JSONArray jArray = new JSONArray(json_str);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = null;
                json = jArray.getJSONObject(i);

                HashMap<String, String> map1 = new HashMap<String, String>();

                // adding each child node to HashMap key => value
                map1.put("id", json.getString("name"));
                map1.put("name", json.getString("devel"));
                map1.put("address", json.getString("PM"));

                // adding HashList to ArrayList
                arrList.add(map1);
            }

        } catch ( JSONException e) {
            e.printStackTrace();
        }

        if(!arrList.isEmpty()){
            ListAdapter adapter = new SimpleAdapter( this, arrList,
                    R.layout.member_list_item, new String[] { "id", "name", "address" },
                    new int[] { R.id.wid, R.id.name, R.id.url });

            listView.setAdapter(adapter);
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // Send single item click data to SingleItemView Class
                Intent i = new Intent(MemberActivity.this,
                        SingleItemView.class);
                // Pass data "name" followed by the position

                // Open SingleItemView.java Activity
                startActivity(i);
            }
        });


    }

    /*
    private void selectDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM account;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            startManagingCursor(cursor);
            Memberlist_DBAdapter dbAdapter = new Memberlist_DBAdapter(this, cursor);
            list.setAdapter(dbAdapter);
        }
    }
    */

    private String getJsonData(){
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());

        String str = "";
        HttpResponse response;
        HttpClient myClient = new DefaultHttpClient();
        HttpPost myConnection = new HttpPost("http://220.149.11.229/list.php");

        try {
            response = myClient.execute(myConnection);
            str = EntityUtils.toString(response.getEntity(), "UTF-8");

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }



}





        /*
        //2
        memberlist = (ListView)findViewById(R.id.memberlist);
        dbHelper = new MemberList_DBHelper(this, dbName, null, dbVersion);

        selectDB();

        memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                cursor.moveToPosition(position);
                String str = cursor.getString(cursor.getColumnIndex("name"));
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
*/


        /*
        helper = new MySQLiteOpenHelper(this, // 현재 화면의 context
                "account.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        // 1. 데이터 저장
        insert("1111", "1111", "이름1", "학교", "전공", "기술1", "기술2", "기술3", "활동", 1, 0, 0, 1, 0, "메일", "폰", 1);
        insert("1111", "1111", "이름3", "학교", "전공", "기술1", "기술2", "기술3", "활동", 1, 0, 0, 1, 0, "메일", "폰", 1);

        // 3. 삭제하기

        delete("이름1");
        delete("이름3");

        // 4. 조회하기
        select();
        */




    /*
    // insert
    public void insert(String account_id, String pwd, String name, String school, String major, String account_skill1, String account_skill2, String account_skill3,
                       String activity, int devel, int PM, int desi, int team, int crew,  String e_mail, String phone, int account_Div) {
        db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능

        ContentValues values = new ContentValues();
        // db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤
        // 데이터의 삽입은 put을 이용한다.
        values.put("account_id", account_id);
        values.put("pwd", pwd);
        values.put("name", name);
        values.put("school", school);
        values.put("major", major);
        values.put("account_skill1", account_skill1);
        values.put("account_skill2", account_skill2);
        values.put("account_skill3", account_skill3);
        values.put("activity", activity);
        values.put("devel", devel);
        values.put("PM", PM);
        values.put("desi", desi);
        values.put("team", team);
        values.put("crew", crew);
        values.put("e_mail", e_mail);
        values.put("phone", phone);
        values.put("account_Div", account_Div);

        db.insert("account", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)
        // tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.
    }


    // delete
    public void delete (String name) {
        db = helper.getWritableDatabase();
        db.delete("account", "name=?", new String[]{name});
        Log.i("db", name + " 정상적으로 삭제 되었습니다.");
    }

    // select
    public void select() {

        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용

        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
        Cursor c = db.query("account", null, null, null, null, null, null);


        while (c.moveToNext()) {
            // c의 int가져와라 ( c의 컬럼 중 id) 인 것의 형태이다.
            int account_idx = c.getInt(c.getColumnIndex("account_idx"));
            String account_id = c.getString(c.getColumnIndex("account_id"));
            String pwd = c.getString(c.getColumnIndex("pwd"));
            String name = c.getString(c.getColumnIndex("name"));
            String school = c.getString(c.getColumnIndex("school"));
            String major = c.getString(c.getColumnIndex("major"));
            String account_skill1 = c.getString(c.getColumnIndex("account_skill1"));
            String account_skill2 = c.getString(c.getColumnIndex("account_skill2"));
            String account_skill3 = c.getString(c.getColumnIndex("account_skill3"));
            String activity = c.getString(c.getColumnIndex("activity"));
            int devel = c.getInt(c.getColumnIndex("devel"));
            int PM = c.getInt(c.getColumnIndex("PM"));
            int desi = c.getInt(c.getColumnIndex("desi"));
            int team = c.getInt(c.getColumnIndex("team"));
            int crew = c.getInt(c.getColumnIndex("crew"));
            String e_mail = c.getString(c.getColumnIndex("e_mail"));
            String phone = c.getString(c.getColumnIndex("phone"));
            int account_Div = c.getInt(c.getColumnIndex("account_Div"));

            Log.i("db", ": " + account_idx + ", account_id : " + account_id + ", pwd : " + pwd
                    + ", name : " + name + ", school : " + school + ", major : " + major + ", account_skill1 : " + account_skill1 + ", account_skill2 : " + account_skill2 + ", account_skill3 : " + account_skill3
                    + ", activity : " + activity + ", devel : " + devel + ", PM : " + PM + ", desi : " + desi + ", team : " + team + ", crew : " + crew
                    + ", e_mail : " + e_mail + ", phone : " + phone + ", account_Div : " + account_Div);


        }
    }
    */


    /*
    2
     private void selectDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM account;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0) {
            startManagingCursor(cursor);
            Memberlist_DBAdapter dbAdapter = new Memberlist_DBAdapter(this, cursor);
            memberlist.setAdapter(dbAdapter);
        }
    }
    */



