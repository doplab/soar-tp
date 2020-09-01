package javaeetutorial.roster.entity;

import javaeetutorial.roster.entity.Team;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-11-21T22:50:14")
@StaticMetamodel(Player.class)
public class Player_ { 

    public static volatile CollectionAttribute<Player, Team> teams;
    public static volatile SingularAttribute<Player, String> name;
    public static volatile SingularAttribute<Player, String> id;
    public static volatile SingularAttribute<Player, String> position;
    public static volatile SingularAttribute<Player, Double> salary;

}