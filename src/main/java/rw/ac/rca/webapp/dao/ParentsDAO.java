package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Parents;
import rw.ac.rca.webapp.orm.Student;

import java.util.List;

public interface ParentsDAO {

    public Parents saveParent(Parents parents);
    public  Parents updateParent(Parents parents);
    public  boolean deleteParent(int id);
    public  Parents findParentById(int id);
    public List<Parents> getAllParents();

    public Parents getStudent(int id);
}
