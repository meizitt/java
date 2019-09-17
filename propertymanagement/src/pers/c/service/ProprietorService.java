package pers.c.service;

import pers.c.dao.ProprietorDao;
import pers.c.dao.RecordDao;
import pers.c.domain.Proprietor;
import pers.c.domain.Record;

import java.sql.SQLException;
import java.util.List;

public class ProprietorService {

    private static ProprietorDao dao = new ProprietorDao();

    public void addProprietor(Proprietor proprietor) throws SQLException {

        if (dao.findProprietorById(proprietor.getP_id()) != null) {
            System.out.println("this proprietor is already exist");
        } else
            dao.addProprietor(proprietor);

    }

    public Proprietor findProprietorById(String p_id) throws SQLException {
        return dao.findProprietorById(p_id);
    }

    public List<Proprietor> findAllProprietor() throws SQLException {
        return dao.findAllProprietor();
    }



    public void delProprietorById(String p_id) throws SQLException {
        RecordDao rDao=new RecordDao();
        rDao.delAllRecord(p_id);
        dao.delProprietorById(p_id);
    }

    public void updateProprietorInfo(Proprietor proprietor) throws SQLException {
        Proprietor old_proprietor = dao.findProprietorById(proprietor.getP_id());
        proprietor.setP_pwd(old_proprietor.getP_pwd());
        dao.updatePropritedInfo(proprietor);
    }

    public void updateProprietorPwd(String p_id, String new_pwd) throws SQLException {
        Proprietor proprietor = dao.findProprietorById(p_id);
        proprietor.setP_pwd(new_pwd);
        dao.updatePropritedInfo(proprietor);
    }

    public Proprietor findProprietor(String p_name, String p_pwd) throws SQLException {
        return dao.findProprietor(p_name,p_pwd);
    }

    public Proprietor findProprietorByName(String p_name) throws SQLException {
        return dao.findProprietorByName(p_name);
    }
}
