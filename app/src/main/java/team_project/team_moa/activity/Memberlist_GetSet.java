package team_project.team_moa.activity;

/**
 * Created by LUCY on 2016-06-05.
 */
public class Memberlist_GetSet{
    int account_idx;
    String account_id;
    String pwd;
    String name;
    String school;
    String Major;
    String account_skill1;
    String account_skill2;
    String account_skill3;
    String activity;
    int devel;
    int PM;
    int desi;
    int team;
    int crew;
    String e_mail;
    String phone;
    int account_Div;

    public Memberlist_GetSet(int account_idx, String account_id,
            String pwd, String name, String school, String Major,
            String account_skill1, String account_skill2, String account_skill3,
            String activity, int devel, int PM, int desi, int team, int crew,
            String e_mail, String phone, int account_Div) {
        this.account_idx = account_idx;
        this.account_id = account_id;
        this.pwd = pwd;
        this.name = name;
        this.school = school;
        this.Major = Major;
        this.account_skill1 = account_skill1;
        this.account_skill2 = account_skill2;
        this.account_skill3 = account_skill3;
        this.activity = activity;
        this.devel = devel;
        this.PM = PM;
        this.desi = desi;
        this.team = team;
        this.crew = crew;
        this.e_mail = e_mail;
        this.phone = phone;
        this.account_Div = account_Div;
    }

    public int getAccount_idx() {
        return account_idx;
    }

    public void setAccount_idx(int account_idx) {
        this.account_idx = account_idx;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getAccount_skill1() {
        return account_skill1;
    }

    public void setAccount_skill1(String account_skill1) {
        this.account_skill1 = account_skill1;
    }

    public String getAccount_skill2() {
        return account_skill2;
    }

    public void setAccount_skill2(String account_skill2) {
        this.account_skill2 = account_skill2;
    }

    public String getAccount_skill3() {
        return account_skill3;
    }

    public void setAccount_skill3(String account_skill3) {
        this.account_skill3 = account_skill3;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getDevel() {
        return devel;
    }

    public void setDevel(int devel) {
        this.devel = devel;
    }

    public int getPM() {
        return PM;
    }

    public void setPM(int PM) {
        this.PM = PM;
    }

    public int getDesi() {
        return desi;
    }

    public void setDesi(int desi) {
        this.desi = desi;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAccount_Div() {
        return account_Div;
    }

    public void setAccount_Div(int account_Div) {
        this.account_Div = account_Div;
    }
}
