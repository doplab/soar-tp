package javaeetutorial.roster.entity;

import javaeetutorial.roster.entity.League;
import javaeetutorial.roster.entity.Player;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-11-21T22:50:14")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile SingularAttribute<Team, String> city;
    public static volatile CollectionAttribute<Team, Player> players;
    public static volatile SingularAttribute<Team, League> league;
    public static volatile SingularAttribute<Team, String> name;
    public static volatile SingularAttribute<Team, String> id;

}