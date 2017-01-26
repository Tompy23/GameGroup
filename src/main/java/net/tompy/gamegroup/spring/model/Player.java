package net.tompy.gamegroup.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "player" )
public class Player implements Comparable< Player >
{
    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @OneToMany( mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< EventPlayer > eventPlayer;

    @Column( name = "name" )
    private String name;

    @Column( name = "password" )
    private String password;

    @Column( name = "email" )
    private String email;

    @Column( name = "privilege" )
    private int privilege;

    @Override
    public int compareTo( Player o )
    {
        return this.name.compareTo( o.getName() );
    }
    
    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public Set< EventPlayer > getEventPlayer()
    {
        return eventPlayer;
    }

    public void setEventPlayer( Set< EventPlayer > eventPlayer )
    {
        this.eventPlayer = eventPlayer;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public int getPrivilege()
    {
        return privilege;
    }

    public void setPrivilege( int privilege )
    {
        this.privilege = privilege;
    }


}
