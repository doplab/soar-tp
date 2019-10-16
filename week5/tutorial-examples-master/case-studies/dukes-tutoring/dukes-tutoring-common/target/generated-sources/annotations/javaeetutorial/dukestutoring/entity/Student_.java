package javaeetutorial.dukestutoring.entity;

import javaeetutorial.dukestutoring.entity.Guardian;
import javaeetutorial.dukestutoring.entity.StatusEntry;
import javaeetutorial.dukestutoring.entity.TutoringSession;
import javaeetutorial.dukestutoring.util.StatusType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-10-09T21:32:35")
@StaticMetamodel(Student.class)
public class Student_ extends Person_ {

    public static volatile ListAttribute<Student, TutoringSession> sessions;
    public static volatile SingularAttribute<Student, String> school;
    public static volatile SingularAttribute<Student, Integer> grade;
    public static volatile SingularAttribute<Student, Boolean> active;
    public static volatile ListAttribute<Student, Guardian> guardians;
    public static volatile ListAttribute<Student, StatusEntry> statusEntries;
    public static volatile SingularAttribute<Student, StatusType> status;

}