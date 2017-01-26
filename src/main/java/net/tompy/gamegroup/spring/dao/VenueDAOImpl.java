package net.tompy.gamegroup.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.tompy.gamegroup.spring.model.Venue;

public class VenueDAOImpl implements VenueDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List< Venue > getAllVenues()
    {
        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< Venue > venues = (List< Venue >) session.createQuery( "from Venue" ).list();

        return venues;

    }

    @Override
    public void saveVenue( Venue v )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.persist( v );
    }

    @Override
    public void deleteVenue( Venue venue )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.delete( venue );
    }

    @Override
    public Venue getVenue( int venueId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        Venue venue = session.get( Venue.class, venueId );

        return venue;
    }

}
