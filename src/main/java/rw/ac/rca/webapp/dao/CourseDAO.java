/**
 * 
 */
package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Course;

import java.util.List;

/**
 * @author Aphrodice Rwagaju
 *
 */
public interface CourseDAO {
	
	public Course saveCourse(Course course);
	public Course updateCourse(Course course);
	public Course saveOrUpdateCourse(Course course);
	public boolean deleteCourse(Course course);
	public Course getCourseById(int courseId);
	public List<Course> getAllCourses();

	public Course getByName(String name);

}
