package team_project.team_moa.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

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
 * Created by LUCY on 2016-06-07.
 */
public class SingleItemView extends Activity {
    // Declare Variables
    TextView txtname;
    String name;
    Button button;
    ToggleButton button_star;


    ListView listView1;
    ListView listView2;
    ArrayList<HashMap<String, String>> arrList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.member_info);
        button_star = (ToggleButton) findViewById(R.id.star);

        button = (Button) findViewById(R.id.bt_send_message);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleItemView.this, Chatting.class);
                startActivity(intent);
            }
        });

        listView1 = (ListView) findViewById(R.id.member_list_info1);
        listView2 = (ListView) findViewById(R.id.member_list_info2);
        arrList = new ArrayList<HashMap<String, String>>();

        String json_str = getJsonData();

        try{
            JSONArray jArray = new JSONArray(json_str);

            for (int j = 0; j < jArray.length(); j++) {
                JSONObject json = null;
                json = jArray.getJSONObject(j);

                HashMap<String, String> map1 = new HashMap<String, String>();

                // adding each child node to HashMap key => value
                map1.put("id", json.getString("name"));
                map1.put("name", json.getString("devel"));
                map1.put("address", json.getString("PM"));
                map1.put("School", json.getString("School"));
                map1.put("Major", json.getString("Major"));
                map1.put("account_Skill1", json.getString("account_Skill1"));
                map1.put("account_Skill2", json.getString("account_Skill2"));
                map1.put("account_Skill3", json.getString("account_Skill3"));

                // adding HashList to ArrayList
                arrList.add(map1);
            }

        } catch ( JSONException e) {
            e.printStackTrace();
        }

        if(!arrList.isEmpty()){
            ListAdapter adapter1 = new SimpleAdapter( this, arrList,
                    R.layout.member_info_1, new String[] { "id", "name", "address" },
                    new int[] { R.id.member_name, R.id.member_devel, R.id.member_PM });

            listView1.setAdapter(adapter1);

            ListAdapter adapter2 = new SimpleAdapter( this, arrList,
                    R.layout.member_info_2, new String[] { "School", "Major", "account_Skill1","account_Skill2","account_Skill3" },
                    new int[] { R.id.member_School, R.id.member_Major, R.id.member_Skill1, R.id.member_Skill2, R.id.member_Skill3 });

            listView2.setAdapter(adapter2);
        }


        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();


    }


        public void toggle(View v){
            if(button_star.isChecked())
                Toast.makeText(SingleItemView.this, "즐겨찾기 ON", Toast.LENGTH_SHORT).show();

            else
                Toast.makeText(SingleItemView.this, "즐겨찾기 OFF", Toast.LENGTH_SHORT).show();
        }


        // Locate the TextView in singleitemview.xml
        //txtname = (TextView) findViewById(R.id.name);

        // Load the text into the TextView
        //txtname.setText(name);





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
        HttpPost myConnection = new HttpPost("http://220.149.11.229/member_info.php");

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
