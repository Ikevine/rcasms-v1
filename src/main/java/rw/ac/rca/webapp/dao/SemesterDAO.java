package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Semester;

import java.util.List;

public interface SemesterDAO {
    public Semester saveSemeter(Semester semester);
    public Semester updateSemester(Semester semester);
    public boolean deleteSemester(int semesterId);
    public  Semester findBySemesterId(int semesterId);
    public List<Semester> getallSemester();

    public Semester getByName(String name);

}
