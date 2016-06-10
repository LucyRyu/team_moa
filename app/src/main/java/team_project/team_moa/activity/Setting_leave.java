package team_project.team_moa.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import team_project.team_moa.R;

/**
 * Created by JY on 2016-05-10.
 */

public class Setting_leave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_leave);
    }

    public void onButton1Clicked(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("안내");
        builder.setMessage("탈퇴하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setNegativeButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "예 버튼이 눌러졌습니다.", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Setting_leave.this,
                        LoginActivity.class);
                // Pass data "name" followed by the position
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                // Open SingleItemView.java Activity
                startActivity(i);
                finish();
            }
        });
        builder.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "아니오 버튼이 눌러졌습니다.", Toast.LENGTH_LONG).show();

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}

