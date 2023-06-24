package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.AcademicYearDAO;
import rw.ac.rca.webapp.orm.AcademicYear;

import java.util.List;

public class AcademcYearDAOImpl extends DAO implements AcademicYearDAO {

    private  static AcademcYearDAOImpl instance;

    private AcademcYearDAOImpl(){}

    public  static  AcademcYearDAOImpl getInstance(){
        if(instance == null)
            return new AcademcYearDAOImpl();

        return instance;
    }

    @Override
    public AcademicYear saveAcademicYear(AcademicYear academicYear) {
        try{
            begin();
            getSession().save(academicYear);
            commit();
            return academicYear;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public AcademicYear updateAcademicYear(AcademicYear academicYear) {
        try{
            begin();
            getSession().update(academicYear);
            commit();
            return academicYear;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public AcademicYear saveOrUpdateAcademicYear(AcademicYear academicYear) {
        try{
            begin();
            getSession().saveOrUpdate(academicYear);
            commit();
            return academicYear;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public boolean deleteAcademicYear(int academicYear) {
        try{
            begin();
            Query query = getSession().createQuery("from AcademicYear where id=:ref");
            query.setInteger("ref", academicYear);
            AcademicYear academicYear1 = (AcademicYear) query.uniqueResult();
            getSession().delete(academicYear1);
            commit();
            return true;
        }
        catch (Exception e){
            rollback();
            return false;
        }
    }

    @Override
    public AcademicYear getAcademicYearById(int id) {
        try {
            begin();
            Query query = getSession().createQuery("from AcademicYear where id=:ref");
            query.setInteger("ref", id);
            AcademicYear academicYear = (AcademicYear) query.uniqueResult();
            commit();
            return academicYear;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public List<AcademicYear> getAllAcademicYears() {
        try{
            begin();
            Query query = getSession().createQuery("from AcademicYear");
            List<AcademicYear>academicYears = query.list();
            commit();
            return academicYears;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public AcademicYear getByName(String name) {
        try{
            begin();
            Query query = getSession().createQuery("from AcademicYear where name= :ref");
            query.setString("ref", name);
            AcademicYear academicYear = (AcademicYear) query.uniqueResult();
            System.out.println(academicYear + "keke quick");
            commit();
            return academicYear;
        }
        catch (Exception e){
            rollback();
            e.printStackTrace();
            return null;
        }
    }
}
