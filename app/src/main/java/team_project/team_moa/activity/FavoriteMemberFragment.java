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
 * Created by LUCY on 2016-05-09.
 */
public class FavoriteMemberFragment extends Activity {


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
        setContentView(R.layout.favorite_list_first);

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
                Intent i = new Intent(FavoriteMemberFragment.this,
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
        HttpPost myConnection = new HttpPost("http://220.149.11.229/favorite_list.php");

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
