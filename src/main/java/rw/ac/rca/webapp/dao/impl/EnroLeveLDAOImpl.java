package rw.ac.rca.webapp.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import rw.ac.rca.webapp.dao.EnrollmentLevelDAO;
import rw.ac.rca.webapp.orm.EnrollmentLevel;

import java.util.List;

public  class EnroLeveLDAOImpl extends DAO implements EnrollmentLevelDAO {

    public static final Logger LOG = Logger.getLogger(EnroLeveLDAOImpl.class);
    private EnroLeveLDAOImpl(){};

    public static  EnroLeveLDAOImpl instance;

    public static EnroLeveLDAOImpl getInstance() {
        if (instance == null) {
            return new EnroLeveLDAOImpl();

        } else {
            return instance;
        }
    }

    @Override
    public EnrollmentLevel saveLevel(EnrollmentLevel enrollmentLevel) {
        try{
            begin();
            getSession().save(enrollmentLevel);
            commit();
            return enrollmentLevel;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public EnrollmentLevel updateLevel(EnrollmentLevel enrollmentLevel) {
        try {
            begin();
            getSession().update(enrollmentLevel);
            commit();
            return enrollmentLevel;
        }
        catch (Exception e) {
            rollback();
            return  null;
        }
    }

    @Override
    public EnrollmentLevel getEnrolmentLevel(int id) {
        try{
            begin();
            Query query = getSession().createQuery("from EnrollmentLevel where id = :ref");
            query.setInteger("ref" , id);
            EnrollmentLevel enrollmentLevel = (EnrollmentLevel) query.uniqueResult();
            commit();
            return enrollmentLevel;
        }
        catch (Exception e){
            rollback();
            return  null;
        }
    }

    @Override
    public boolean deleteEnrolment(int id) {
        try{
            begin();
            Query query = getSession().createQuery("from EnrollmentLevel where id = :ref");
            query.setInteger("ref" , id);
            EnrollmentLevel enrollmentLevel = (EnrollmentLevel) query.uniqueResult();
            getSession().delete(enrollmentLevel);
            commit();
            return true;
        }
        catch (Exception e){
            rollback();
            return  false;
        }
    }

    @Override
    public List<EnrollmentLevel> getAllLevels() {
        try{
            begin();
            Query query = getSession().createQuery("from EnrollmentLevel");
            List<EnrollmentLevel> enrollmentLevelList = query.list();
            commit();
            return enrollmentLevelList;
        }
        catch (Exception e){
            rollback();
            return  null;
        }
    }

    @Override
    public EnrollmentLevel getByName(String name) {
        try{
            begin();
            Query query = getSession().createQuery("from EnrollmentLevel where name = :ref");
            query.setString("ref" , name);
            EnrollmentLevel enrollmentLevel = (EnrollmentLevel) query.uniqueResult();
            commit();
            return enrollmentLevel;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }
}
