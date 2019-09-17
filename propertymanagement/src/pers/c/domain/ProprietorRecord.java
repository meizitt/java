package pers.c.domain;

import java.util.Date;

public class ProprietorRecord extends Record{
    private String p_name;
    public  ProprietorRecord(){}

    public ProprietorRecord(String r_id, String p_id, Date r_time, double r_money, String r_remark, String p_name) {
        super(r_id, p_id, r_time, r_money, r_remark);
        this.p_name = p_name;
    }
    public ProprietorRecord(Record record,String p_name){
        super(record.getR_id(),record.getP_id(),record.getR_time(),record.getR_money(),
                record.getR_remark());
        this.p_name=p_name;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    @Override
    public String toString() {
        return "ProprietorRecord{" +
                "p_name='" + p_name + '\'' +
                "} " + super.toString();
    }
}
