package team_project.team_moa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import team_project.team_moa.R;

/**
 * Created by LUCY on 2016-05-09.
 */
public class MemberListFragment extends Fragment implements CompoundButton.OnCheckedChangeListener{
    public MemberListFragment() {
        // Required empty public constructor
    }

    CheckBox cb_planner,cb_developer,cb_designer,cb_android,cb_ios,cb_team,cb_member,cb_c,cb_java,cb_uiux;
    TextView tv;

    Button bt;
    ListView memberList;

    /*
    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    // 전역변수로 사용할 것들을 미리 빼두었다.
    */

    /*
    2
    ListView memberList;
    MemberList_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;

    final static String dbName = "account.db";
    final static int dbVersion = 1;
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_memberlist, container, false);

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






        /*
        helper = new MySQLiteOpenHelper(rootView.getContext(), // 현재 화면의 context
                "account.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        // 1. 데이터 저장
        insert("1111", "1111", "이름1", "학교", "전공", "기술1", "기술2", "기술3", "활동", 1, 0, 0, 1, 0, "메일", "폰", 1);
        insert("1111", "1111", "이름3", "학교", "전공", "기술1", "기술2", "기술3", "활동", 1, 0, 0, 1, 0, "메일", "폰", 1);

        // 3. 삭제하기

        delete("이름1");
        delete("이름3");

        // 4. 조회하기
        select();
        */


        /*
        2
        memberList = (ListView)rootView.findViewById(R.id.memberList);
        dbHelper = new MemberList_DBHelper(rootView.getContext(),dbName,null,dbVersion);

        selectDB();

        memberList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                String str = cursor.getString(cursor.getColumnIndex("name"));

            }
        });
        */




        return rootView;
    }



    /*
    2

    private void selectDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM account;";

        cursor = db.rawQuery(sql,null);
        if(cursor.getCount()>0){
            getActivity().startManagingCursor(cursor);
            Memberlist_DBAdapter dbAdapter = new Memberlist_DBAdapter(getActivity().getApplicationContext(), cursor);
            memberList.setAdapter(dbAdapter);
        }

    }
    */




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


    /*
    // insert
    public void insert(String account_id, String pwd, String name, String school, String major, String account_skill1, String account_skill2, String account_skill3,
                       String activity, int devel, int PM, int desi, int team, int crew,  String e_mail, String phone, int account_Div) {
        db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능

        ContentValues values = new ContentValues();
        // db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤
        // 데이터의 삽입은 put을 이용한다.
        values.put("account_id", account_id);
        values.put("pwd", pwd);
        values.put("name", name);
        values.put("school", school);
        values.put("major", major);
        values.put("account_skill1", account_skill1);
        values.put("account_skill2", account_skill2);
        values.put("account_skill3", account_skill3);
        values.put("activity", activity);
        values.put("devel", devel);
        values.put("PM", PM);
        values.put("desi", desi);
        values.put("team", team);
        values.put("crew", crew);
        values.put("e_mail", e_mail);
        values.put("phone", phone);
        values.put("account_Div", account_Div);

        db.insert("account", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)
        // tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.
    }


    // delete
    public void delete (String name) {
        db = helper.getWritableDatabase();
        db.delete("account", "name=?", new String[]{name});
        Log.i("db", name + " 정상적으로 삭제 되었습니다.");
    }

    // select
    public void select() {

        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용

        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
        Cursor c = db.query("account", null, null, null, null, null, null);

        /*
         * 위 결과는 select * from student 가 된다. Cursor는 DB결과를 저장한다. public Cursor
         * query (String table, String[] columns, String selection, String[]
         * selectionArgs, String groupBy, String having, String orderBy)
         */


    /*
        while (c.moveToNext()) {
            // c의 int가져와라 ( c의 컬럼 중 id) 인 것의 형태이다.
            int account_idx = c.getInt(c.getColumnIndex("account_idx"));
            String account_id = c.getString(c.getColumnIndex("account_id"));
            String pwd = c.getString(c.getColumnIndex("pwd"));
            String name = c.getString(c.getColumnIndex("name"));
            String school = c.getString(c.getColumnIndex("school"));
            String major = c.getString(c.getColumnIndex("major"));
            String account_skill1 = c.getString(c.getColumnIndex("account_skill1"));
            String account_skill2 = c.getString(c.getColumnIndex("account_skill2"));
            String account_skill3 = c.getString(c.getColumnIndex("account_skill3"));
            String activity = c.getString(c.getColumnIndex("activity"));
            int devel = c.getInt(c.getColumnIndex("devel"));
            int PM = c.getInt(c.getColumnIndex("PM"));
            int desi = c.getInt(c.getColumnIndex("desi"));
            int team = c.getInt(c.getColumnIndex("team"));
            int crew = c.getInt(c.getColumnIndex("crew"));
            String e_mail = c.getString(c.getColumnIndex("e_mail"));
            String phone = c.getString(c.getColumnIndex("phone"));
            int account_Div = c.getInt(c.getColumnIndex("account_Div"));

            Log.i("db", ": " + account_idx + ", account_id : " + account_id + ", pwd : " + pwd
                    + ", name : " + name + ", school : " + school + ", major : " + major + ", account_skill1 : " + account_skill1 + ", account_skill2 : " + account_skill2 + ", account_skill3 : " + account_skill3
                    + ", activity : " + activity + ", devel : " + devel + ", PM : " + PM + ", desi : " + desi + ", team : " + team + ", crew : " + crew
                    + ", e_mail : " + e_mail + ", phone : " + phone + ", account_Div : " + account_Div);


        }
    }

    */

    public void onStart(){
        super.onStart();
        bt = (Button) getActivity().findViewById(R.id.cb_select);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getContext(), MemberActivity.class);
                startActivity(myIntent);
            }
        });
    }



}

