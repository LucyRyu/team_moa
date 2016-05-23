package team_project.team_moa.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import team_project.team_moa.R;

/**
 * Created by JY on 2016-05-18.
 */
public class Setting_recommend extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_recommend);
        // 화면 전환 - 인텐트 날리기 (startActivity)
        //     1. 다음 넘어갈 화면을 준비한다 (layout xml, java)
        //    2. AndroidManifest.xml 에 Activity 를 등록한다
        //    3. Intent 객체를 만들어서 startActivity 한다
    }

    public void onButtonClicked(View view) {
        Intent intent = new Intent(this, Setting_suggest.class);
        startActivity(intent); // 다음 화면으로 넘어간다
    }
}
