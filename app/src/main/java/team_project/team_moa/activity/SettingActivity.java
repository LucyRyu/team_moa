package team_project.team_moa.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import team_project.team_moa.R;

/**
 * Created by JY on 2016-05-09.
 */
public class SettingActivity extends Activity implements AdapterView.OnItemClickListener {

        public String menuArray[] ={
                "공지사항","건의사항","FAQ","회원탈퇴"
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.setting);

                ArrayAdapter<String> Adapter;
                Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuArray);

                ListView list = (ListView)findViewById(R.id.SettingList);
                list.setAdapter(Adapter);

                list.setOnItemClickListener(this);
        }


        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

                if (i == 0) {
                        Intent intent = new Intent(SettingActivity.this, Setting_notice.class);
                        startActivity(intent);
                }

                else if (i == 1) {
                        Intent intent = new Intent(SettingActivity.this, Setting_recommend.class);
                        startActivity(intent);
                }

                else if (i == 2) {
                        Intent intent = new Intent(SettingActivity.this, Setting_question.class);
                        startActivity(intent);
                }

                else if (i == 3) {
                        Intent intent = new Intent(SettingActivity.this, Setting_leave.class);
                        startActivity(intent);
                }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                        return true;
                }

                return super.onOptionsItemSelected(item);
        }

}