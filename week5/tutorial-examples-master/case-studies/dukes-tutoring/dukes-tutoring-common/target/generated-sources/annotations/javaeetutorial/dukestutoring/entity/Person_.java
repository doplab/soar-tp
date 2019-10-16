package javaeetutorial.dukestutoring.entity;

import javaeetutorial.dukestutoring.entity.Address;
import javaeetutorial.dukestutoring.entity.PersonDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-10-09T21:32:35")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile ListAttribute<Person, Address> addresses;
    public static volatile SingularAttribute<Person, String> password;
    public static volatile SingularAttribute<Person, String> mobilePhone;
    public static volatile SingularAttribute<Person, String> homePhone;
    public static volatile SingularAttribute<Person, String> nickname;
    public static volatile SingularAttribute<Person, String> middleName;
    public static volatile SingularAttribute<Person, PersonDetails> details;
    public static volatile SingularAttribute<Person, Long> id;
    public static volatile SingularAttribute<Person, String> suffix;
    public static volatile SingularAttribute<Person, String> email;

}