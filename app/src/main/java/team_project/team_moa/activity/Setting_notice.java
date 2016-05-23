package team_project.team_moa.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import team_project.team_moa.R;

/**
 * Created by JY on 2016-05-19.
 */
public class Setting_notice extends ActionBarActivity {
    ListView listView1;
    Setting_ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_notice);

        // 리스트뷰 객체 참조
        listView1 = (ListView) findViewById(R.id.listView1);

        // 어댑터 객체 생성
        adapter = new Setting_ListAdapter(this);

        // 아이템 데이터 만들기
        Resources res = getResources();
        adapter.addItem(new Setting_Item(res.getDrawable(R.drawable.notice), "v1.0.0업데이트", "2016.05.16 1차 업데이트", "관리자"));
        adapter.addItem(new Setting_Item(res.getDrawable(R.drawable.notice), "v1.0.1업데이트", "2016.05.18 2차 업데이트", "관리자"));
        adapter.addItem(new Setting_Item(res.getDrawable(R.drawable.notice), "2016년 해커톤 개최", "2016.00.00일 해커톤이 시행됩니다.", "관리자"));
        adapter.addItem(new Setting_Item(res.getDrawable(R.drawable.notice), "v1.0.2업데이트 예정", "2016.05.24 3차 업데이트 예정입니다.", "관리자"));

        // 리스트뷰에 어댑터 설정
        listView1.setAdapter(adapter);

        // 새로 정의한 리스너로 객체를 만들어 설정
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Setting_Item curItem = (Setting_Item) adapter.getItem(position);
                String[] curData = curItem.getData();

                Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_LONG).show();

            }

        });

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