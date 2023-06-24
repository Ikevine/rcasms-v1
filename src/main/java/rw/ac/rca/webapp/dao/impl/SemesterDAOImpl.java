package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.SemesterDAO;
import rw.ac.rca.webapp.orm.Semester;

import java.util.List;

public class SemesterDAOImpl extends DAO implements SemesterDAO {

    private static SemesterDAOImpl instance;

    private SemesterDAOImpl() {
    }

    public static SemesterDAOImpl getInstance() {
        if (instance == null) {
            return new SemesterDAOImpl();
        }
        return instance;
    }


    @Override
    public Semester saveSemeter(Semester semester) {
        try {
            begin();
            getSession().save(semester);
            commit();
            return semester;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Semester updateSemester(Semester semester) {
        try {
            begin();
            getSession().update(semester);
            commit();
            return semester;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public boolean deleteSemester(int semesterId) {
        try {
            begin();
            Query query = getSession().createQuery("from Semester where id = :ref ");
            query.setInteger("ref", semesterId);
            Semester semester = (Semester) query.uniqueResult();
            getSession().delete(semester);
            commit();
            return true;
        } catch (Exception e) {
            rollback();
            return false;
        }
    }

    @Override
    public Semester findBySemesterId(int semesterId) {
        try {
            begin();
            Query query = getSession().createQuery("from Semester where id = :ref");
            query.setInteger("ref", semesterId);
            Semester semester = (Semester) query.uniqueResult();
            commit();
            return semester;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public List<Semester> getallSemester() {
        try{
            begin();
            Query query = getSession().createQuery("from Semester");
            List<Semester> semesters = query.list();
            commit();
            return semesters;
        }
        catch (Exception e){
            rollback();
            return  null;
        }
    }

    @Override
    public Semester getByName(String name) {
        try{
            begin();
            Query query = getSession().createQuery("from Semester where name = :ref");
            query.setString("ref", name);
            Semester semester = (Semester) query.uniqueResult();
            commit();
            return semester;

        }
        catch (Exception e){
            rollback();
            return null;
        }
    }
}