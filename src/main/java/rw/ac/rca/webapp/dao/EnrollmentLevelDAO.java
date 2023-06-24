package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.EnrollmentLevel;

import java.util.List;

public interface EnrollmentLevelDAO {

    public EnrollmentLevel saveLevel(EnrollmentLevel enrollmentLevel);
    public EnrollmentLevel updateLevel(EnrollmentLevel enrollmentLevel);
    public EnrollmentLevel getEnrolmentLevel(int id);
    public boolean deleteEnrolment(int id);
    public List<EnrollmentLevel> getAllLevels();

    public EnrollmentLevel getByName(String name);


}
