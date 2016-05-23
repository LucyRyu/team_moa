package team_project.team_moa.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import team_project.team_moa.R;

/**
 * Created by JY on 2016-05-18.
 */
public class Setting_suggest extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_suggest);
    }

    public void onButtonSave(View view){
        finish();
    }

}
