package pers.c.service;

import pers.c.dao.ProprietorDao;
import pers.c.dao.RecordDao;
import pers.c.domain.PageBean;
import pers.c.domain.Proprietor;
import pers.c.domain.ProprietorRecord;
import pers.c.domain.Record;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordService {
    private static RecordDao dao = new RecordDao();

    public void addRecord(Record record) throws SQLException {
        dao.addRecord(record);
    }

    public Record findRecordById(String r_id) throws SQLException {
        return dao.findRecordByid(r_id);
    }


    public List<Record> findAllRecordByPid(String p_id) throws SQLException {
        return dao.findAllRecordByPid(p_id);
    }

    public void delRecordByRid(String r_id) throws SQLException {
        dao.delRecordByRid(r_id);
    }

    public void UpdateRecord(Record record) throws SQLException {
        dao.UpdateRecord(record);
    }

    public List<ProprietorRecord> findAllRecord() throws SQLException {
        ProprietorDao pdao = new ProprietorDao();
        List<Record> recordList = dao.findAllRecord();
        List<ProprietorRecord> proprietorRecordList = new ArrayList<>();
        for (Record record : recordList) {
            Proprietor proprietor = pdao.findProprietorById(record.getP_id());
            ProprietorRecord proprietorRecord = new ProprietorRecord(record, proprietor.getP_name());
            proprietorRecordList.add(proprietorRecord);
        }
        return proprietorRecordList;
    }

    public List<ProprietorRecord> findAllRecord(String p_name) throws SQLException {
        ProprietorDao pdao = new ProprietorDao();
        Proprietor proprietor = pdao.findProprietorByName(p_name);
        List<Record> allRecord = dao.findAllRecordByPid(proprietor.getP_id());
        List<ProprietorRecord> proprietorRecords = new ArrayList<>();
        for (Record record : allRecord) {
            ProprietorRecord proprietorRecord = new ProprietorRecord(record, p_name);
            proprietorRecords.add(proprietorRecord);
        }
        return proprietorRecords;
    }

    public PageBean findPageBean(String p_id, int currentPage, int currentCount) throws SQLException {
        List<Record> recordList = dao.findAllRecordByPid(p_id);
//        int totalCount= dao.getTotalCount(p_id);
        int totalCount = recordList.size();
        int totalPage =(int) Math.ceil(1.0 * totalCount / currentCount);
        int index = (currentPage-1)*currentCount;
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setCurrentCount(currentCount);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        List<Record> records= dao.findRecordListForPageBean(p_id,index,currentCount);
        pageBean.setRecordList(records);
        return pageBean;
    }
}
