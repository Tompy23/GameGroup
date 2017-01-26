package net.tompy.gamegroup.spring.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RawEvent
{
    private Integer id;
    private String date;
    private Integer venue;
    private List< Integer > players = new ArrayList< Integer >();
    private List< Integer > winners = new ArrayList< Integer >();
    private Integer game;
    private String description;

    public RawEvent()
    {

    }

    public RawEvent( Event event )
    {
        this.id = event.getId();
        this.date = event.getDate().toString();
        this.venue = event.getVenue().getId();
        this.game = event.getGame().getId();
        this.description = event.getDescription();
        for ( EventPlayer ep : event.getEventPlayer() )
        {
            players.add( ep.getPlayer().getId() );
            if ( "Y".equals( ep.getWin() ) )
            {
                winners.add( ep.getPlayer().getId() );
            }
        }
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate( String date )
    {
        this.date = date;
    }

    public Integer getVenue()
    {
        return venue;
    }

    public void setVenue( Integer venue )
    {
        this.venue = venue;
    }

    public List< Integer > getPlayers()
    {
        return players;
    }

    public void setPlayers( List< Integer > players )
    {
        this.players = players;
    }

    public List< Integer > getWinners()
    {
        return winners;
    }

    public void setWinners( List< Integer > winners )
    {
        this.winners = winners;
    }

    public Integer getGame()
    {
        return game;
    }

    public void setGame( Integer game )
    {
        this.game = game;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }
}