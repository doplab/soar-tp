package javaeetutorial.dukestutoring.entity;

import javaeetutorial.dukestutoring.entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-10-09T21:32:35")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> country;
    public static volatile SingularAttribute<Address, String> province;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, Boolean> isPrimary;
    public static volatile SingularAttribute<Address, Person> person;
    public static volatile SingularAttribute<Address, String> postalCode;
    public static volatile SingularAttribute<Address, Boolean> active;
    public static volatile SingularAttribute<Address, String> street1;
    public static volatile SingularAttribute<Address, Long> id;
    public static volatile SingularAttribute<Address, String> street2;

}