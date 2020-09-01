package ch.unil.doplab.entities;

import ch.unil.doplab.entities.StudentTakesCourse;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-31T14:46:47")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> courseName;
    public static volatile ListAttribute<Course, StudentTakesCourse> studentTakesCourseList;
    public static volatile SingularAttribute<Course, Integer> courseCredits;
    public static volatile SingularAttribute<Course, Integer> courseId;

}