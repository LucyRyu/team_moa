package team_project.team_moa.activity;

/**
 * Created by LUCY on 2016-06-04.
 * memberlist를 호출하기 위해서 내부DB를 이용하기위해서 생성
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/*
* sql을 사용하기 위한 제반 클래스
* SQLiteOpenHelper는 사용에 도움을 주는 클래스이다.
*/

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(Context context, String name,
                              CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        // SQLiteOpenHelper 가 최초 실행 되었을 때
        String sql = "create table account (" +
                "account_idx integer primary key autoincrement, " +
                "account_id text, " +
                "pwd text, " +
                "name text, " +
                "school text, " +
                "major text, " +
                "account_skill1 text," +
                "account_skill2 text," +
                "account_skill3 text," +
                "activity text, " +
                "devel integer, " +
                "PM integer, " +
                "desi integer, " +
                "team integer, " +
                "crew integer, " +
                "e_mail text, " +
                "phone text, " +
                "account_Div integer);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // db = 적용할 db, old/new 구 버전/신버전
        // TODO Auto-generated method stub
        /*
         * db 버전이 업그레이드 되었을 때 실행되는 메소드
         * 이 부분은 사용에 조심해야 하는 일이 많이 있다. 버전이 1인 사용자가 2로 바뀌면
         * 한번의 수정만 하면 되지만 버전이 3으로 되면 1인 사용자가 2, 3을 거쳐야 하고
         * 2인 사용자는 3 까지만 거치면 된다. 이렇게 증가할 수록 수정할 일이 많아지므로
         * 적절히 사용해야 하며 가능하면 최초 설계 시에 완벽을 기하는 것이 가장 좋을 것이다.
         * 테스트에서는 기존의 데이터를 모두 지우고 다시 만드는 형태로 하겠다.
         */

        String sql = "drop table if exists account";
        db.execSQL(sql);

        onCreate(db); // 테이블을 지웠으므로 다시 테이블을 만들어주는 과정
    }
}