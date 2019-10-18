package javaeetutorial.dukestutoring.entity;

import java.util.Calendar;
import javaeetutorial.dukestutoring.entity.StatusEntry;
import javaeetutorial.dukestutoring.entity.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-10-09T21:32:35")
@StaticMetamodel(TutoringSession.class)
public class TutoringSession_ { 

    public static volatile SingularAttribute<TutoringSession, Calendar> sessionDate;
    public static volatile ListAttribute<TutoringSession, Student> students;
    public static volatile SingularAttribute<TutoringSession, Long> id;
    public static volatile ListAttribute<TutoringSession, StatusEntry> statusEntries;

}