package pers.c.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pers.c.domain.Record;
import pers.c.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class RecordDao {
    public void addRecord(Record record) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into record values(?,?,?,?,?)";
        runner.update(sql, record.getR_id(), record.getP_id(), record.getR_time(),
                record.getR_money(), record.getR_remark());
    }

    public Record findRecordByid(String r_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from record where r_id=?";
        Record record;
        record = runner.query(sql, new BeanHandler<Record>(Record.class), r_id);
        return record;
    }

    public List<Record> findAllRecordByPid(String p_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from record where p_id=?";
        List<Record> recordList;
        recordList = runner.query(sql, new BeanListHandler<Record>(Record.class), p_id);
        return recordList;
    }

    public void delRecordByRid(String r_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from record where r_id=?";
        runner.update(sql, r_id);
    }

    public void UpdateRecord(Record record) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update record set p_id=?,r_time=?,r_money=?,r_remark=? where r_id=?";
        runner.update(sql, record.getP_id(), record.getR_time(), record.getR_money(),
                record.getR_remark(), record.getR_id());
    }

    public List<Record> findAllRecord() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from record";
        List<Record> recordList;
        recordList = runner.query(sql, new BeanListHandler<Record>(Record.class));
        return recordList;
    }

    public int getTotalCount(String p_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from record where p_id=?";
        Long query = (Long) runner.query(sql, new ScalarHandler());
        return query.intValue();
    }

    public List<Record> findRecordListForPageBean(String p_id, int index, int currentCount) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from record where p_id=? limit ?,?";
        List<Record> records = runner.query(sql, new BeanListHandler<Record>(Record.class), p_id, index, currentCount);
        return records;
    }

    public void delAllRecord(String p_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from record where p_id=?";
        runner.update(sql,p_id);
    }
}
