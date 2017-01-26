package net.tompy.gamegroup.spring.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.tompy.gamegroup.spring.dao.VenueDAO;
import net.tompy.gamegroup.spring.model.Venue;

public class VenueServiceImpl implements VenueService
{
    @Autowired
    private VenueDAO venueDAO;

    @Override
    @Transactional
    public List< Venue > getAllVenues()
    {
        List< Venue > returnValue = venueDAO.getAllVenues();

        Collections.sort( returnValue );

        return returnValue;
    }

    @Override
    @Transactional
    public Venue getVenue( int venueId )
    {
        return venueDAO.getVenue( venueId );
    }

    @Override
    @Transactional
    public void saveVenue( Venue v )
    {
        Venue venue = null;
        if ( v.getId() > 0 )
        {
            venue = venueDAO.getVenue( v.getId() );
            venue.setName( v.getName() );
        }
        else
        {
            venue = new Venue( v.getId(), v.getName() );
        }
        venueDAO.saveVenue( venue );
    }

    @Override
    @Transactional
    public void deleteVenue( int venueId )
    {
        Venue v = venueDAO.getVenue( venueId );
        venueDAO.deleteVenue( v );
    }

}
