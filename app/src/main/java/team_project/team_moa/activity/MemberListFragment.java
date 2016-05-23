package team_project.team_moa.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import team_project.team_moa.R;

/**
 * Created by LUCY on 2016-05-09.
 */
public class MemberListFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    public MemberListFragment() {
        // Required empty public constructor
    }

    CheckBox cb_planner,cb_developer,cb_designer,cb_android,cb_ios,cb_team,cb_member,cb_c,cb_java,cb_uiux;
    TextView tv;

    Button bt;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_memberlist, container, false);

        cb_planner = (CheckBox) rootView.findViewById(R.id.CB_planner);
        cb_developer = (CheckBox) rootView.findViewById(R.id.CB_developer);
        cb_designer = (CheckBox) rootView.findViewById(R.id.CB_designer);
        cb_android = (CheckBox) rootView.findViewById(R.id.CB_Android);
        cb_ios = (CheckBox) rootView.findViewById(R.id.CB_IOS);
        cb_team = (CheckBox) rootView.findViewById(R.id.CB_team);
        cb_member = (CheckBox) rootView.findViewById(R.id.CB_member);
        cb_c = (CheckBox) rootView.findViewById(R.id.CB_c);
        cb_java = (CheckBox) rootView.findViewById(R.id.CB_java);
        cb_uiux = (CheckBox) rootView.findViewById(R.id.CB_uiux);

        tv = (TextView) rootView.findViewById(R.id.result_CB);

        cb_planner.setOnCheckedChangeListener(this);
        cb_developer.setOnCheckedChangeListener(this);
        cb_designer.setOnCheckedChangeListener(this);
        cb_android.setOnCheckedChangeListener(this);
        cb_ios.setOnCheckedChangeListener(this);
        cb_team.setOnCheckedChangeListener(this);
        cb_member.setOnCheckedChangeListener(this);
        cb_c.setOnCheckedChangeListener(this);
        cb_java.setOnCheckedChangeListener(this);
        cb_uiux.setOnCheckedChangeListener(this);


        return rootView;
    }


    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String str = " ";

        if(cb_planner.isChecked()) {
            str += cb_planner.getText().toString();
        }

        if(cb_developer.isChecked()) {
            str += cb_developer.getText().toString();
        }

        if(cb_designer.isChecked()) {
            str += cb_designer.getText().toString();
        }

        if(cb_android.isChecked()) {
            str += cb_android.getText().toString();
        }

        if(cb_ios.isChecked()) {
            str += cb_ios.getText().toString();
        }

        if(cb_team.isChecked()) {
            str += cb_team.getText().toString();
        }

        if(cb_member.isChecked()) {
            str += cb_member.getText().toString();
        }

        if(cb_c.isChecked()) {
            str += cb_c.getText().toString();
        }

        if(cb_java.isChecked()) {
            str += cb_java.getText().toString();
        }

        if(cb_uiux.isChecked()) {
            str += cb_uiux.getText().toString();
        }

        tv.setText(str);

    }





}

