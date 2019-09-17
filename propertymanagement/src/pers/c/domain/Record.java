package pers.c.domain;

import java.util.Date;

public class Record {
    private String r_id;
    private String p_id;
    private Date r_time;
    private double r_money;
    private String r_remark;

    public Record() {
    }

    public Record(String r_id, String p_id, Date r_time, double r_money, String r_remark) {
        this.r_id = r_id;
        this.p_id = p_id;
        this.r_time = r_time;
        this.r_money = r_money;
        this.r_remark = r_remark;
    }

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public Date getR_time() {
        return r_time;
    }

    public void setR_time(Date r_time) {
        this.r_time = r_time;
    }

    public double getR_money() {
        return r_money;
    }

    public void setR_money(double r_money) {
        this.r_money = r_money;
    }

    public String getR_remark() {
        return r_remark;
    }

    public void setR_remark(String r_remark) {
        this.r_remark = r_remark;
    }

    @Override
    public String toString() {
        return "Record{" +
                "r_id='" + r_id + '\'' +
                ", p_id='" + p_id + '\'' +
                ", r_time=" + r_time +
                ", r_money=" + r_money +
                ", r_remark='" + r_remark + '\'' +
                '}';
    }
}
