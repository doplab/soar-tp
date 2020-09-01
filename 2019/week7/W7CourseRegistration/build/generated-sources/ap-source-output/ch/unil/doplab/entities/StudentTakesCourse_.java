package ch.unil.doplab.entities;

import ch.unil.doplab.entities.Course;
import ch.unil.doplab.entities.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-31T14:46:47")
@StaticMetamodel(StudentTakesCourse.class)
public class StudentTakesCourse_ { 

    public static volatile SingularAttribute<StudentTakesCourse, Integer> stcId;
    public static volatile SingularAttribute<StudentTakesCourse, Course> cId;
    public static volatile SingularAttribute<StudentTakesCourse, Student> sId;

}