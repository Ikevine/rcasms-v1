package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.EnrolDAO;
import rw.ac.rca.webapp.orm.Enrol;
import rw.ac.rca.webapp.orm.Parents;
import rw.ac.rca.webapp.orm.Student;

import java.util.List;

public class EnrilDAOImpl extends DAO implements EnrolDAO {

    public static EnrilDAOImpl instance ;

    private EnrilDAOImpl(){}

    public static EnrilDAOImpl getInstance() {
        if (instance == null) {
            return new EnrilDAOImpl();

        } else {
            return instance;
        }
    }
    @Override
    public Enrol saveEnrol(Enrol enrol) {
        try{
            begin();
            getSession().save(enrol);
            commit();
            return enrol;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public Enrol updateEnrol(Enrol enrol) {
        try{
            begin();
            getSession().update(enrol);
            commit();
            return enrol;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }



    @Override
    public Enrol saveOrUpdateEnrol(Enrol enrol) {
        try{
            begin();
            getSession().saveOrUpdate(enrol);
            commit();
            return enrol;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public boolean deleteEnrol(int enrol) {
        try{
            begin();
            Query query = getSession().createQuery("from Enrol where id= :ref");
            query.setInteger("ref" , enrol);
            Enrol enrol1 = (Enrol) query.uniqueResult();
            getSession().delete(enrol1);
            commit();
            return  true;
        }
        catch (Exception e){
            rollback();
            return false;
        }
    }

    @Override
    public Enrol getEnrolById(int EnrolId) {
        try{
            begin();
            Query query = getSession().createQuery("from Enrol where id= :ref");
            query.setInteger("ref" , EnrolId);
            Enrol enrol1 = (Enrol) query.uniqueResult();
            commit();
            return enrol1;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public List<Enrol> getAllEnrols() {
        try{
            begin();
            Query query = getSession().createQuery("from Enrol");
            List<Enrol> enrolList = query.list();
            commit();
            return enrolList;
        }
        catch(Exception e){
            rollback();
            return  null;
        }
    }

    @Override
    public List<Enrol> getEnrolByStudent(int id) {
        try{
            begin();
            Query query = getSession().createQuery("from Enrol where student = :ref");
            query.setInteger("ref" , id);
            List<Enrol> enrolList = query.list();
            commit();
            return  enrolList;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }


}
