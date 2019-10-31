package ch.unil.doplab.servlets;

import ch.unil.doplab.beans.CourseRegistrationBeanRemote;
import ch.unil.doplab.entities.Course;
import ch.unil.doplab.entities.Student;
import ch.unil.doplab.entities.StudentTakesCourse;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Melike Geçer
 */
@WebServlet(name = "CourseRegistrationServlet", urlPatterns = {"/CourseRegistrationServlet"})
public class CourseRegistrationServlet extends HttpServlet {

    @EJB
    private CourseRegistrationBeanRemote crb;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //
        String action = request.getParameter("action");
        if (action.equals("Add A New Course")) {
            request.getRequestDispatcher("/CourseTransactions/AddCourse/AddCourseFirst.jsp").forward(request, response);
        } else if (action.equals("Add The Course")) {
            String courseName = request.getParameter("CourseName");
            int courseCredits = Integer.valueOf(request.getParameter("CourseCredit"));
            Course course = new Course();
            course.setCourseName(courseName);
            course.setCourseCredits(courseCredits);
            crb.addCourse(course);
            String courseInfo = crb.getCourse(courseName).toString();
            request.setAttribute("resultMessage", "Successful! The course is added.<br><br>" + courseInfo);
            request.getRequestDispatcher("/CourseTransactions/AddCourse/AddCourseSecond.jsp").forward(request, response);
        } else if (action.equals("Delete A Course")) {
            List<Course> courseList = crb.getCourses();
            request.setAttribute("courseList", courseList);
            request.getRequestDispatcher("/CourseTransactions/DeleteCourse/DeleteCourseFirst.jsp").forward(request, response);
        } else if (action.equals("Delete The Course")) {
            String courseName = request.getParameter("Select A Course Name To Delete");
            crb.deleteCourse(courseName);
            request.setAttribute("resultMessage", "Successful! The course is deleted.");
            request.getRequestDispatcher("/CourseTransactions/DeleteCourse/DeleteCourseSecond.jsp").forward(request, response);
        } else if (action.equals("Find A Course")) {
            request.setAttribute("courseList", crb.getCourses());
            request.getRequestDispatcher("/CourseTransactions/FindCourse/FindCourseFirst.jsp").forward(request, response);
        } else if (action.equals("Find The Course")) {
            String courseName = request.getParameter("Select A Course Name To Find");
            request.setAttribute("course", crb.getCourse(courseName));
            request.getRequestDispatcher("/CourseTransactions/FindCourse/FindCourseSecond.jsp").forward(request, response);
        } else if (action.equals("Find All Courses")) {
            request.setAttribute("courseList", crb.getCourses());
            request.getRequestDispatcher("/CourseTransactions/FindAllCourses.jsp").forward(request, response);
        } else if (action.equals("Add A New Student")) {
            request.getRequestDispatcher("/StudentTransactions/AddStudent/AddStudentFirst.jsp").forward(request, response);
        } else if (action.equals("Add The Student")) {
            String firstName = request.getParameter("StudentFirstName");
            String lastName = request.getParameter("StudentLastName");
            Student student = new Student();
            student.setStudentFirstName(firstName);
            student.setStudentLastName(lastName);
            crb.addStudent(student);
            String courseInfo = crb.getStudent(firstName, lastName).toString();
            request.setAttribute("resultMessage", "Successful! The student is added.<br><br>" + courseInfo);
            request.getRequestDispatcher("/StudentTransactions/AddStudent/AddStudentSecond.jsp").forward(request, response);
        } else if (action.equals("Delete A Student")) {
            List<Student> studentList = crb.getStudents();
            request.setAttribute("studentList", studentList);
            request.getRequestDispatcher("/StudentTransactions/DeleteStudent/DeleteStudentFirst.jsp").forward(request, response);
        } else if (action.equals("Delete The Student")) {
            String str = request.getParameter("Select A Student To Delete");
            String firstName = str.split(",")[0];
            String lastName = str.split(",")[1];
            crb.deleteStudent(firstName, lastName);
            request.setAttribute("resultMessage", "Successful! The student is deleted.");
            request.getRequestDispatcher("/StudentTransactions/DeleteStudent/DeleteStudentSecond.jsp").forward(request, response);
        } else if (action.equals("Find A Student")) {
            request.setAttribute("studentList", crb.getStudents());
            request.getRequestDispatcher("/StudentTransactions/FindStudent/FindStudentFirst.jsp").forward(request, response);
        } else if (action.equals("Find The Student")) {
            String str = request.getParameter("Select A Student To Find");
            String firstName = str.split(",")[0];
            String lastName = str.split(",")[1];
            request.setAttribute("student", crb.getStudent(firstName, lastName));
            request.getRequestDispatcher("/StudentTransactions/FindStudent/FindStudentSecond.jsp").forward(request, response);
        } else if (action.equals("Find All Students")) {
            request.setAttribute("studentList", crb.getStudents());
            request.getRequestDispatcher("/StudentTransactions/FindAllStudents.jsp").forward(request, response);
        } else if (action.equals("Student Takes A Course")) {
            request.setAttribute("courseList", crb.getCourses());
            request.setAttribute("studentList", crb.getStudents());
            request.getRequestDispatcher("/StudentCourseTransactions/TakeCourse/StudentTakesCourseFirst.jsp").forward(request, response);
        } else if (action.equals("Student Takes The Course")) {
            String str = request.getParameter("Select A Student To Take A Course");
            String firstName = str.split(",")[0];
            String lastName = str.split(",")[1];
            String courseName = request.getParameter("Select A Course Name For A Student");
            StudentTakesCourse stc = new StudentTakesCourse();
            stc.setCId(crb.getCourse(courseName));
            stc.setSId(crb.getStudent(firstName, lastName));
            crb.studentTakesCourse(stc);
            request.setAttribute("message", stc.getSId().getStudentFirstName() + stc.getSId().getStudentLastName() + " takes the course " + stc.getCId().getCourseName());
            request.getRequestDispatcher("/StudentCourseTransactions/TakeCourse/StudentTakesCourseSecond.jsp").forward(request, response);
        } else if (action.equals("Student Withdraws From A Course")) {
            request.setAttribute("courseList", crb.getCourses());
            request.setAttribute("studentList", crb.getStudents());
            request.getRequestDispatcher("/StudentCourseTransactions/WithdrawCourse/StudentWithdrawsFirst.jsp").forward(request, response);
        } else if (action.equals("Student Withdraws From The Course")) {
            String str = request.getParameter("Select A Student To Withdraw A Course");
            String firstName = str.split(",")[0];
            String lastName = str.split(",")[1];
            String courseName = request.getParameter("Select A Course Name To Withdraw");
            StudentTakesCourse stc = new StudentTakesCourse();
            stc.setCId(crb.getCourse(courseName));
            stc.setSId(crb.getStudent(firstName, lastName));
            crb.studentWithdrawsFromCourse(stc);
            request.setAttribute("message", stc.getSId().getStudentFirstName() + stc.getSId().getStudentLastName() + " withdraws the course " + stc.getCId().getCourseName());
            request.getRequestDispatcher("/StudentCourseTransactions/WithdrawCourse/StudentWithdrawsSecond.jsp").forward(request, response);
        } else if (action.equals("Show Students Of A Course")) {
            request.setAttribute("courseList", crb.getCourses());
            request.getRequestDispatcher("/StudentCourseTransactions/FindStudentsOfACourse/FindStudentsOfACourseFirst.jsp").forward(request, response);
        } else if (action.equals("Show The Students Of The Course")) {
            String courseName = request.getParameter("Select A Course To Show");
            Course course = crb.getCourse(courseName);
            List<Student> studentList = crb.showStudentsOfACourse(course);
            request.setAttribute("studentList", studentList);
            request.getRequestDispatcher("/StudentCourseTransactions/FindStudentsOfACourse/FindStudentsOfACourseSecond.jsp").forward(request, response);
        } else if (action.equals("Show Courses of A Student")) {
            request.setAttribute("studentList", crb.getStudents());
            request.getRequestDispatcher("/StudentCourseTransactions/FindCoursesOfAStudent/FindCoursesOfAStudentFirst.jsp").forward(request, response);
        } else if (action.equals("Find The Courses Of A Student")) {
            String str = request.getParameter("Select A Student To Show");
            String firstName = str.split(",")[0];
            String lastName = str.split(",")[1];
            Student student = crb.getStudent(firstName, lastName);
            List<Course> courseList = crb.showCoursesOfAStudent(student);
            request.setAttribute("courseList", courseList);
            request.getRequestDispatcher("/StudentCourseTransactions/FindCoursesOfAStudent/FindCoursesOfAStudentSecond.jsp").forward(request, response);
        }

        //
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
