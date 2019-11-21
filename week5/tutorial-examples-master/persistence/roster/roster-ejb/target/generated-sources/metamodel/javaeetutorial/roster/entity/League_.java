package javaeetutorial.roster.entity;

import javaeetutorial.roster.entity.Team;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-11-21T22:50:14")
@StaticMetamodel(League.class)
public abstract class League_ { 

    public static volatile CollectionAttribute<League, Team> teams;
    public static volatile SingularAttribute<League, String> name;
    public static volatile SingularAttribute<League, String> id;
    public static volatile SingularAttribute<League, String> sport;

}