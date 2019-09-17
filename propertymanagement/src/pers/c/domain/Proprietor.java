package pers.c.domain;

public class Proprietor {
    private String p_id;
    private String p_name;
    private String p_pwd;
    private String p_sex;
    private String p_addres;
    private String p_phonenumber;
    private String p_check_in_time;

    public Proprietor(){}

    public Proprietor(String p_id, String p_name, String p_pwd, String p_sex, String p_addres, String p_phonenumber, String p_check_in_time) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_pwd = p_pwd;
        this.p_sex = p_sex;
        this.p_addres = p_addres;
        this.p_phonenumber = p_phonenumber;
        this.p_check_in_time = p_check_in_time;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_pwd() {
        return p_pwd;
    }

    public void setP_pwd(String p_pwd) {
        this.p_pwd = p_pwd;
    }

    public String getP_sex() {
        return p_sex;
    }

    public void setP_sex(String p_sex) {
        this.p_sex = p_sex;
    }

    public String getP_addres() {
        return p_addres;
    }

    public void setP_addres(String p_addres) {
        this.p_addres = p_addres;
    }

    public String getP_phonenumber() {
        return p_phonenumber;
    }

    public void setP_phonenumber(String p_phonenumber) {
        this.p_phonenumber = p_phonenumber;
    }

    public String getP_check_in_time() {
        return p_check_in_time;
    }

    public void setP_check_in_time(String p_check_in_time) {
        this.p_check_in_time = p_check_in_time;
    }

    @Override
    public String toString() {
        return "Proprietor{" +
                "p_id='" + p_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_pwd='" + p_pwd + '\'' +
                ", p_sex='" + p_sex + '\'' +
                ", p_addres='" + p_addres + '\'' +
                ", p_phonenumber='" + p_phonenumber + '\'' +
                ", p_check_in_time='" + p_check_in_time + '\'' +
                '}';
    }
}
