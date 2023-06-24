package rw.ac.rca.webapp.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.orm.Student;

import java.util.List;

public class StudentDAOImpl extends  DAO implements StudentDAO {

     public static final Logger LOG = Logger.getLogger(StudentDAOImpl.class);
     public static StudentDAOImpl instance ;
     private StudentDAOImpl(){}
     public static StudentDAOImpl getInstance() {
          if (instance == null) {
               return new StudentDAOImpl();

          } else {
               return instance;
          }
     }


     @Override
     public Student saveStudent(Student student) {
         try{
              begin();
              getSession().save(student);
              commit();
              return student;
         }
         catch (Exception e){
              e.printStackTrace();
              LOG.error("oooooop srry sweet I can't go");
              rollback();
             return  null;
         }
     }

     @Override
     public Student updateStudent(Student student) {
          try {
               begin();
               getSession().update(student);
               commit();
               return student;
          }
          catch (Exception e){
               rollback();
               return  null;
          }
     }

     @Override
     public boolean deleteStudent(int id) {
          try {
               begin();
               Query query = getSession().createQuery("from Student where id= :ref");
               query.setInteger("ref",id);
               Student student =(Student) query.uniqueResult();
               getSession().delete(student);
               commit();
               return true;
          }
          catch (Exception e){
               rollback();
               return false;

          }
     }

     @Override
     public Student getStudentById(int id) {
         try{
              begin();
              Query query = getSession().createQuery("from Student where id = :ref");
              query.setInteger("ref" , id);
              Student student = (Student) query.uniqueResult();
              commit();
              return student;
         }
         catch(Exception e){
              rollback();
              return null;
         }
     }

     @Override
     public List<Student> getAllStudents() {
          try{
               begin();
               Query query = getSession().createQuery("from Student");
               List<Student> students = query.list();
               commit();
               return students;
          }
          catch(Exception e){
               rollback();
               return  null;
          }
     }

     @Override
     public Student getByFullname(String fullname) {
          try{
               begin();
               Query query = getSession().createQuery("from Student where fullName = :ref");
               query.setString("ref" , fullname);
               Student student = (Student) query.uniqueResult();
               commit();
               return student;
          }
          catch (Exception e){
               rollback();
               return null;
          }
     }
}
