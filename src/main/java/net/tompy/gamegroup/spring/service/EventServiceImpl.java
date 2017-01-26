package net.tompy.gamegroup.spring.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.tompy.gamegroup.spring.dao.EventDAO;
import net.tompy.gamegroup.spring.dao.EventPlayerDAO;
import net.tompy.gamegroup.spring.model.Event;
import net.tompy.gamegroup.spring.model.EventPlayer;
import net.tompy.gamegroup.spring.model.Player;
import net.tompy.gamegroup.spring.model.RawEvent;

public class EventServiceImpl implements EventService
{
    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private EventPlayerDAO eventPlayerDAO;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private VenueService venueService;
    @Autowired
    private GameService gameService;

    @Override
    @Transactional
    public List< Event > getAllEvents()
    {
        List< Event > events = eventDAO.getAllEvents();

        // sort here
        for ( Event e : events )
        {
            Hibernate.initialize( e.getEventPlayer() );
            Collections.sort( e.getEventPlayer() );
        }

        Collections.sort( events );

        return events;
    }

    @Override
    @Transactional
    public void deleteEvent( int eventId )
    {
        Event event = eventDAO.getEvent( eventId );
        eventDAO.deleteEvent( event );
    }

    @Override
    @Transactional
    public Event getEvent( int eventId )
    {
        return eventDAO.getEvent( eventId );
    }

    @Override
    @Transactional
    public RawEvent getRawEvent( int eventId )
    {
        Event e = eventDAO.getEvent( eventId );

        return new RawEvent( e );
    }

    @Override
    @Transactional
    public boolean persistRawEvent( RawEvent rawEvent )
    {
        boolean returnValue = true;

        try
        {
            Event event = null;
            boolean newEvent = false;

            DateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );
            java.util.Date utilDate = df.parse( rawEvent.getDate() );
            Date date = new Date( utilDate.getTime() );

            if ( null != rawEvent.getId() )
            {
                event = eventDAO.getEvent( rawEvent.getId() );
            }
            else
            {
                event = new Event();
                newEvent = true;
            }

            event.setDate( date );
            event.setDescription( rawEvent.getDescription() );
            event.setVenue( venueService.getVenue( rawEvent.getVenue() ) );
            event.setGame( gameService.getGame( rawEvent.getGame() ) );

            if ( newEvent )
            {
                for ( int i : rawEvent.getPlayers() )
                {
                    Player player = playerService.getPlayer( i );
                    event.addEventPlayer( new EventPlayer( event, player, ( rawEvent.getWinners().contains( i ) ? "Y" : "N" ), "" ) );
                }
            }
            else
            {
                // See if any players have been removed
                List< Integer > eventPlayerIds = new ArrayList< Integer >();
                event.getEventPlayer().forEach( ep->eventPlayerIds.add( ep.getPlayer().getId() ) );
                for ( int i : eventPlayerIds )
                {
                    if ( !rawEvent.getPlayers().contains( i ) )
                    {
                        // EventPlayer ep = findEventPlayer(
                        // event.getEventPlayer(), i );
                        // event.getEventPlayer().remove( ep );
                        this.removeEventPlayer( event.getId(), i );
                    }
                }

                // See if any players have been added
                eventPlayerIds.clear();
                event.getEventPlayer().forEach( ep->eventPlayerIds.add( ep.getPlayer().getId() ) );
                for ( int i : rawEvent.getPlayers() )
                {
                    if ( !eventPlayerIds.contains( i ) )
                    {
                        Player player = playerService.getPlayer( i );
                        event.addEventPlayer( new EventPlayer( event, player, ( rawEvent.getWinners().contains( i ) ? "Y" : "N" ), "" ) );
                    }
                }

                // Assign winners
                for ( EventPlayer ep : event.getEventPlayer() )
                {
                    ep.setWin( ( rawEvent.getWinners().contains( ep.getPlayer().getId() ) ? "Y" : "N" ) );
                }
            }

            eventDAO.saveEvent( event );
        }
        catch (

        java.text.ParseException e )
        {
            e.printStackTrace();
            returnValue = false;
        }

        return returnValue;
    }

    @Override
    @Transactional
    public void removeEventPlayer( int eventId, int playerId )
    {
        EventPlayer ep = eventPlayerDAO.getEventPlayer( eventId, playerId );
        eventPlayerDAO.removeEventPlayer( ep );
    }

}
