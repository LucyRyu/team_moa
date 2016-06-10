package team_project.team_moa.activity;

import android.provider.BaseColumns;

/**
 * Created by LUCY on 2016-05-10.
 */
public class MemberData {

    public static final class CreateDB implements BaseColumns {
        public static final String account_Id = "account_Id";
        public static final String pwd = "pwd";
        public static final String NAME = "name";
        public static final String School = "School";
        public static final String Major = "Major";
        public static final String account_Skill1 = "account_Skill1";
        public static final String account_Skill2 = "account_Skill2";
        public static final String account_Skill3 = "account_Skill3";
        public static final String Activity = "Activity";
        public static final String devel = "devel";
        public static final String PM = "PM";
        public static final String desi = "desi";
        public static final String team = "team";
        public static final String crew = "crew";
        public static final String e_mail = "e_mail";
        public static final String phone = "phone";
        public static final String account_Div = "account_Div";
        public static final String _TABLENAME = "account";
        public static final String _CREATE =
                "create table " + _TABLENAME + "("
                        + _ID + " integer primary key autoincrement, "
                        + account_Id + " text not null , "
                        + pwd + " text not null , "
                        + NAME + " text not null , "
                        + School + " text not null , "
                        + Major + " text not null , "
                        + account_Skill1 + " text not null , "
                        + account_Skill2 + " text not null , "
                        + account_Skill3 + " text not null , "
                        + devel + " text not null , "
                        + PM + " text not null , "
                        + desi + " text not null , "
                        + team + " text not null , "
                        + crew + " text not null , "
                        + e_mail + " text not null , "
                        + phone + " text not null , "
                        + account_Div + " text not null );";
    }


}
