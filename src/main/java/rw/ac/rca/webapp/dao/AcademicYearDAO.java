/**
 * 
 */
package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.AcademicYear;

import java.util.List;

/**
 * @author Aphrodice Rwagaju
 *
 */
public interface AcademicYearDAO {
	
	public AcademicYear saveAcademicYear(AcademicYear academicYear);
	public AcademicYear updateAcademicYear(AcademicYear academicYear);
	public AcademicYear saveOrUpdateAcademicYear(AcademicYear academicYear);
	public boolean deleteAcademicYear(int academicYear);
	public AcademicYear getAcademicYearById(int id);
	public List<AcademicYear> getAllAcademicYears();
	public AcademicYear getByName(String name);
}
