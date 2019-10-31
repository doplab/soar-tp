package ch.unil.doplab.beans;

import ch.unil.doplab.entities.Course;
import ch.unil.doplab.entities.Student;
import ch.unil.doplab.entities.StudentTakesCourse;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melike Geçer
 */
@Remote
public interface CourseRegistrationBeanRemote {

   void addCourse(Course course);
   void deleteCourse(String courseName);
   Course getCourse(String courseName);
   List<Course> getCourses();
   
   void addStudent(Student student);
   void deleteStudent(String firstName, String lastName);
   Student getStudent(String firstName, String lastName);
   List<Student> getStudents();
   
   void studentTakesCourse(StudentTakesCourse stc);
   void studentWithdrawsFromCourse(StudentTakesCourse stc);
   List<Student> showStudentsOfACourse(Course course);
   List<Course> showCoursesOfAStudent(Student student);
}