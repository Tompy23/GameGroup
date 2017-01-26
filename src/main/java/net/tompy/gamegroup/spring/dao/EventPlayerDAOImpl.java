package net.tompy.gamegroup.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.tompy.gamegroup.spring.model.EventPlayer;

public class EventPlayerDAOImpl implements EventPlayerDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public EventPlayer getEventPlayer( int eventId, int playerId )
    {
        EventPlayer returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< EventPlayer > event = (List< EventPlayer >) session.createQuery( "from EventPlayer where eventId=:eventId and playerId=:playerId" ).setParameter( "eventId", eventId )
                .setParameter( "playerId", playerId ).list();

        if ( null != event && !event.isEmpty() )
        {
            returnValue = event.get( 0 );
        }
        return returnValue;
    }

    @Override
    public void removeEventPlayer( EventPlayer ep )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.createQuery( "delete from EventPlayer where eventId=:eventId and playerId=:playerId" ).setParameter( "eventId", ep.getEvent().getId() )
                .setParameter( "playerId", ep.getPlayer().getId() ).executeUpdate();
    }

}
