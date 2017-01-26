package net.tompy.gamegroup.spring.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "event" )
public class Event implements Comparable< Event >
{
    public Event()
    {

    }

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @OneToMany( mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List< EventPlayer > eventPlayer = new ArrayList< EventPlayer >();

    @ManyToOne
    @JoinColumn( name = "gameId" )
    private Game game;

    @Column( name = "date" )
    private Date date;

    @Column( name = "description" )
    private String description;

    @ManyToOne
    @JoinColumn( name = "venueId" )
    private Venue venue;
    
    @Override
    public int compareTo( Event o )
    {
        return o.getDate().compareTo( this.date );
    }
    
    public void addEventPlayer( EventPlayer ep )
    {
        eventPlayer.add( ep );
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public List< EventPlayer > getEventPlayer()
    {
        return eventPlayer;
    }

    public void setEventPlayer( List< EventPlayer > eventPlayer )
    {
        this.eventPlayer = eventPlayer;
    }

    public Game getGame()
    {
        return game;
    }

    public void setGame( Game game )
    {
        this.game = game;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate( Date date )
    {
        this.date = date;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public Venue getVenue()
    {
        return venue;
    }

    public void setVenue( Venue venue )
    {
        this.venue = venue;
    }


}
