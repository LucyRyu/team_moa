package team_project.team_moa.activity;

import android.provider.BaseColumns;

/**
 * Created by user on 2016-05-31.
 */
public class DataBases {
    public static final class CreateDB implements BaseColumns{
        public static final String NAME="name";
        public static final String CONTACT="contact";
        public static final String _TABLENAME="recommend";
        public static final String _CREATE=
    "create table "+_TABLENAME+"("
            +_ID+" integer primary key autoincrement, "
            +NAME+" text not null , "
            +CONTACT+" text not null);";
    }
}
