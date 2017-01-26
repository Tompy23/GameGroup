package net.tompy.gamegroup.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "event_player" )
public class EventPlayer implements Serializable, Comparable< EventPlayer >
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public EventPlayer()
    {

    }

    public EventPlayer( Event event, Player player, String win, String notes )
    {
        this.event = event;
        this.player = player;
        this.win = win;
        this.notes = notes;
    }

    @Override
    public int compareTo( EventPlayer arg0 )
    {
        return this.player.compareTo( arg0.getPlayer() );
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "eventId" )
    private Event event;

    @Id
    @ManyToOne
    @JoinColumn( name = "playerId" )
    private Player player;

    @Column( name = "win" )
    private String win;

    @Column( name = "notes" )
    private String notes;

    public Event getEvent()
    {
        return event;
    }

    public void setEvent( Event event )
    {
        this.event = event;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer( Player player )
    {
        this.player = player;
    }

    public String getWin()
    {
        return win;
    }

    public void setWin( String win )
    {
        this.win = win;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes( String notes )
    {
        this.notes = notes;
    }

}
