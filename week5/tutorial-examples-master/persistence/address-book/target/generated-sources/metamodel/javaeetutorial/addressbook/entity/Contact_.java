package javaeetutorial.addressbook.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-10-16T11:10:34")
@StaticMetamodel(Contact.class)
public class Contact_ { 

    public static volatile SingularAttribute<Contact, Date> birthday;
    public static volatile SingularAttribute<Contact, String> firstName;
    public static volatile SingularAttribute<Contact, String> lastName;
    public static volatile SingularAttribute<Contact, String> mobilePhone;
    public static volatile SingularAttribute<Contact, String> homePhone;
    public static volatile SingularAttribute<Contact, Long> id;
    public static volatile SingularAttribute<Contact, String> email;

}