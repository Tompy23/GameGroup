package net.tompy.gamegroup.spring.dao;

import java.util.List;

import net.tompy.gamegroup.spring.model.Event;

public interface EventDAO
{
    public List< Event > getAllEvents();
    
    public Event getEvent( int eventId );
    
    public void saveEvent( Event event );
    
    public void deleteEvent( Event event );
}
