package team_project.team_moa.activity;



import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import team_project.team_moa.R;

public class MypageMenu extends Activity
{
    private ListView                m_ListView;
    private ArrayAdapter<String>    m_Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        /////////////////////////////////////////////////////////

        // 아이템 터치 이벤트
        OnItemClickListener onClickListItem = new OnItemClickListener()
        {

            @Override

            //public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // 이벤트 발생 시 해당 아이템 위치의 텍스트를 출력
                //Toast.makeText(getApplicationContext(), m_Adapter.getItem(arg2), Toast.LENGTH_SHORT).show();
                switch(position)
                {
                    case 0:
                        startActivity(new Intent(MypageMenu.this, MypageCondition.class));
                        break;
                    case 1:
                        startActivity(new Intent(MypageMenu.this, MypageFragment.class));
                        break;
                    case 2:
                        startActivity(new Intent(MypageMenu.this, MypageInfo.class));
                        break;
                    case 3:
                        startActivity(new Intent(MypageMenu.this, MypageJoin.class));
                        break;
                }
            }
        };

        // Android에서 제공하는 string 문자열 하나를 출력 가능한 layout으로 어댑터 생성
        m_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        m_ListView = (ListView) findViewById(R.id.listView); // Xml에서 추가한 ListView 연결
        m_ListView.setAdapter(m_Adapter); // ListView에 어댑터 연결
        m_ListView.setOnItemClickListener(onClickListItem); // ListView 아이템 터치 시 이벤트 추가


        m_Adapter.add("내 정보 변경"); // A
        m_Adapter.add("참가 내역"); // B
        m_Adapter.add("메뉴 선택"); // C
        m_Adapter.add("매칭 완료"); // D

    }

}
