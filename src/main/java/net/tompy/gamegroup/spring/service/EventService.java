package net.tompy.gamegroup.spring.service;

import java.util.List;

import net.tompy.gamegroup.spring.model.Event;
import net.tompy.gamegroup.spring.model.RawEvent;

public interface EventService
{
    public List< Event > getAllEvents();

    public Event getEvent( int eventId );

    public RawEvent getRawEvent( int eventId );

    public void deleteEvent( int eventId );

    public boolean persistRawEvent( RawEvent rawEvent );
    
    public void removeEventPlayer( int eventId, int playerId );
}
