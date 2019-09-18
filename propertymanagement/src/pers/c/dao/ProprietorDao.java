package pers.c.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pers.c.domain.Proprietor;
import pers.c.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class ProprietorDao {
    public Proprietor findProprietorById(String p_id) throws SQLException {
        String sql = "select * from pinfo where p_id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        Proprietor proprietor = runner.query(sql, new BeanHandler<Proprietor>(Proprietor.class), p_id);
        return proprietor;
    }

    public void addProprietor(Proprietor proprietor) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into pinfo values(?,?,?,?,?,?,?)";
        runner.update(sql, proprietor.getP_id(), proprietor.getP_name(),
                proprietor.getP_pwd(), proprietor.getP_sex(), proprietor.getP_addres(),
                proprietor.getP_phonenumber(), proprietor.getP_check_in_time());
    }

    public List<Proprietor> findAllProprietor() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from pinfo";
        List<Proprietor> proprietors = runner.query(sql, new BeanListHandler<Proprietor>(Proprietor.class));
        return proprietors;
    }

    public void delProprietorById(String p_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from pinfo where p_id=?";
        int update = runner.update(sql, p_id);
        System.out.println("del p " + update);

    }

    public void updatePropritedInfo(Proprietor proprietor) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update pinfo set p_name=?,p_pwd=?,p_sex=?,p_addres=?,p_phonenumber=?," +
                "p_check_in_time=? where p_id=?";
        runner.update(sql, proprietor.getP_name(), proprietor.getP_pwd(), proprietor.getP_sex(), proprietor.getP_addres(),
                proprietor.getP_phonenumber(), proprietor.getP_check_in_time(), proprietor.getP_id());
    }

    public Proprietor findProprietor(String p_name, String p_pwd) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from pinfo where p_name=? and p_pwd=?";
        Proprietor proprietor=runner.query(sql,new BeanHandler<Proprietor>(Proprietor.class),p_name,p_pwd);
        return proprietor;

    }

    public Proprietor findProprietorByName(String p_name) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from pinfo where p_name=?";
        return runner.query(sql,new BeanHandler<Proprietor>(Proprietor.class),p_name);
    }
}
