package team_project.team_moa.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LUCY on 2016-06-05.
 */
public class MemberList_DBHelper extends SQLiteOpenHelper{

    String sql;

    public MemberList_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        sql = "CREATE TABLE account ( account_Idx INTEGER PRIMARY KEY AUTOINCREMENT," + "account_id TEXT," + "pwd TEXT," + "name TEXT," +
                "School TEXT," + "Major TEXT," + "account_Skill1 TEXT," + "account_SKill2 TEXT," + "account_Skill3 TEXT," + "activity TEXT," +
                "devel INTEGER," + "PM INTEGER," + "desi INTEGER," + "team INTEGER," + "crew INTEGER," + "e_mail TEXT," + "phone TEXT," + "account_Div INTEGER);";
        db.execSQL(sql);

        db.execSQL("INSERT INTO account VALUES ('1111', '1111', '이름3', '학교', '전공', '기술1', '기술2', '기술3', '활동', '1', '0', '0', '1', '0', '메일', '폰', '1');");
        db.execSQL("INSERT INTO account VALUES ('1111', '1111', '이름1', '학교', '전공', '기술1', '기술2', '기술3', '활동', '1', '0', '0', '1', '0', '메일', '폰', '1');");
        db.execSQL("INSERT INTO account VALUES ('1111', '1111', '이름2', '학교', '전공', '기술1', '기술2', '기술3', '활동', '1', '0', '0', '1', '0', '메일', '폰', '1');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
