package ch.unil.doplab.entities;

import ch.unil.doplab.entities.StudentTakesCourse;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-31T14:46:47")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Integer> studentId;
    public static volatile SingularAttribute<Student, String> studentLastName;
    public static volatile ListAttribute<Student, StudentTakesCourse> studentTakesCourseList;
    public static volatile SingularAttribute<Student, String> studentFirstName;

}