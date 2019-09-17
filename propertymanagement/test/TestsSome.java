import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import org.omg.CORBA.portable.ValueOutputStream;
import pers.c.domain.Admin;
import pers.c.domain.Proprietor;
import pers.c.domain.ProprietorRecord;
import pers.c.domain.Record;
import pers.c.utils.DataSourceUtils;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TestsSome {
    @Test
    public void testC3p0() {
        String admin_account = "admin";
        String admin_pwd = "123";
        String sql = "select * from admin where admin_account=? and admin_pwd=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        Admin admin = null;
        try {
            admin = runner.query(sql, new BeanHandler<Admin>(Admin.class), admin_account, admin_pwd);
            System.out.println(admin != null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUuid() {

        System.out.println(UUID.randomUUID().toString().substring(0,4));
    }

    @Test
    public void testFindAllP() {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from pinfo";
        try {
            List<Proprietor> proprietors = runner.query(sql, new BeanListHandler<Proprietor>(Proprietor.class));
            for (Proprietor proprietor : proprietors) {
                System.out.println(proprietor.toString());
                System.out.println("家啊大家");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDouble() {
        Double b = 2.1;
        System.out.println(b.getClass());
        double a = 3.8;
        System.out.println(a);
    }

    @Test
    public void testDate() {
        Date now = new Date();
        java.sql.Date now_c = new java.sql.Date(now.getTime());
        System.out.println(now_c + "   " + now.toString());
    }
    @Test
    public void testList(){
        List<Proprietor> proprietors=new ArrayList<>();
        Proprietor proprietor=new Proprietor("fa","adsf",
                "hd","ar","wef","af","af");
        for (int i = 0; i < 3; i++) {
            proprietors.add(proprietor);
        }
        for(Proprietor proprietor1:proprietors){
            System.out.println(proprietor1.toString());
        }
    }
    @Test
    public void testChangeDate(){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date r_time = null;
        try {
            r_time = format.parse("2019-1-1");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date time = new java.sql.Date(r_time.getTime());
        System.out.println(time);
    }
    @Test
    public void testGetListLen(){
        List strList = new ArrayList();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        System.out.println(strList);
        System.out.println(strList.size());

    }
}
