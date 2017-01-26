package net.tompy.gamegroup.spring.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.tompy.gamegroup.spring.model.Event;
import net.tompy.gamegroup.spring.model.Game;

public class EventDAOImpl implements EventDAO
{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List< Event > getAllEvents()
    {
        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< Event > events = (List< Event >) session.createQuery( "from Event" ).list();
        
        return events;
    }
    
    @Override
    public void saveEvent( Event e )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.persist( e );
    }

    @Override
    public void deleteEvent( Event event )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.delete( event );
    }

    @Override
    public Event getEvent( int eventId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        Event event =  session.get(  Event.class, eventId );
        
        Hibernate.initialize( event.getEventPlayer() );
        
        return event;
    }


}
