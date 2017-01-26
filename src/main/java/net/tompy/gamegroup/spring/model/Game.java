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
@Table( name = "game" )
public class Game implements Comparable<Game>
{
    public Game()
    {

    }

    public Game( int id, String name )
    {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public int compareTo( Game o )
    {
        return this.name == o.getName() ? 0 : this.name.compareTo( o.getName() );
    }

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column( name = "name" )
    private String name;

    @OneToMany( mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< Event > events;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public Set< Event > getEvents()
    {
        return events;
    }

    public void setEvents( Set< Event > events )
    {
        this.events = events;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

}
