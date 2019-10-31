package ch.unil.doplab.beans;

import ch.unil.doplab.entities.Course;
import ch.unil.doplab.entities.Student;
import ch.unil.doplab.entities.StudentTakesCourse;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Melike Geçer
 */
@Stateless
public class CourseRegistrationBean implements CourseRegistrationBeanRemote {

    @PersistenceContext(unitName = "W7CourseRegistrationPU")
    private EntityManager entityManager;

    @Override
    public void addCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public void deleteCourse(String courseName) {
        entityManager.createQuery("DELETE FROM Course c WHERE c.courseName = :courseName")
                .setParameter("courseName", courseName)
                .executeUpdate();
    }

    @Override
    public Course getCourse(String courseName) {
        return entityManager.createNamedQuery("Course.findByCourseName", Course.class)
                .setParameter("courseName", courseName)
                .getSingleResult();
    }

    @Override
    public List<Course> getCourses() {
        return entityManager.createNamedQuery("Course.findAll", Course.class)
                .getResultList();
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void deleteStudent(String firstName, String lastName) {
        entityManager.createQuery("DELETE FROM Student s WHERE s.studentFirstName = :studentFirstName AND s.studentLastName = :studentLastName")
                .setParameter("studentFirstName", firstName)
                .setParameter("studentLastName", lastName)
                .executeUpdate();
    }

    @Override
    public Student getStudent(String firstName, String lastName) {
        return entityManager.createNamedQuery("Student.findByNames", Student.class)
                .setParameter("studentFirstName", firstName)
                .setParameter("studentLastName", lastName)
                .getSingleResult();
    }

    @Override
    public List<Student> getStudents() {
        return entityManager.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    @Override
    public void studentTakesCourse(StudentTakesCourse stc) {
        entityManager.persist(stc);
    }

    @Override
    public void studentWithdrawsFromCourse(StudentTakesCourse stc) {
        entityManager.createQuery("DELETE FROM StudentTakesCourse stc WHERE stc.sId = :s_id AND stc.cId = :c_id")
                .setParameter("s_id", stc.getSId())
                .setParameter("c_id", stc.getCId())
                .executeUpdate();
    }

    @Override
    public List<Student> showStudentsOfACourse(Course course) {
        return entityManager.createQuery("SELECT s FROM Student s INNER JOIN s.studentTakesCourseList stc WHERE stc.cId = :c_id", Student.class)
                .setParameter("c_id", course)
                .getResultList();
    }

    @Override
    public List<Course> showCoursesOfAStudent(Student student) {
        return entityManager.createQuery("SELECT c FROM Course c INNER JOIN c.studentTakesCourseList stc WHERE stc.sId = :s_id", Course.class)
                .setParameter("s_id", student)
                .getResultList();
    }

}
