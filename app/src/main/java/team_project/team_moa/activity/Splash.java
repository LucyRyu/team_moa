package team_project.team_moa.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import team_project.team_moa.R;

public class Splash extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO 자동 생성된 메소드 스텁
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Handler hdl = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                // TODO 자동 생성된 메소드 스텁
                finish(); // activity 종료
            }

        };
        hdl.sendEmptyMessageDelayed(0, 3000); // 3초후 메시지 보내지
    }

}