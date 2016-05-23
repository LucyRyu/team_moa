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
 * Created by JY on 2016-05-18.
 */
public class Setting_question extends ActionBarActivity {
    ListView listView1;
    Setting_ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_question);

        // 리스트뷰 객체 참조
        listView1 = (ListView) findViewById(R.id.listView1);

        // 어댑터 객체 생성
        adapter = new Setting_ListAdapter(this);

        // 아이템 데이터 만들기
        Resources res = getResources();
        adapter.addItem(new Setting_Item(res.getDrawable(R.drawable.faq), "참가멤버와 팀을 어떻게 구성하나요", "상호간 메세지 등을 주고 받아 위치확인 후 구성하시면 됩니다.", "160520"));
        adapter.addItem(new Setting_Item(res.getDrawable(R.drawable.faq), "특정멤버만 어떻게 보나요", "참가멤버 중 관심있는 멤버를 따로 보실 수 있습니다.", "160520"));
        adapter.addItem(new Setting_Item(res.getDrawable(R.drawable.faq), "마이페이지는 어떤 서비스인가요", "자신을 나타내고 프로젝트를 기록하실 수 있습니다.", "160520"));

        // 리스트뷰에 어댑터 설정
        listView1.setAdapter(adapter);

        // 새로 정의한 리스너로 객체를 만들어 설정
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Setting_Item curItem = (Setting_Item) adapter.getItem(position);
                String[] curData = curItem.getData();

                Toast.makeText(getApplicationContext(), "내용 : " + curData[1], Toast.LENGTH_LONG).show();

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