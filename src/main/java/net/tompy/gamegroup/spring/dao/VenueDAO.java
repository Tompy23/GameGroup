package net.tompy.gamegroup.spring.dao;

import java.util.List;

import net.tompy.gamegroup.spring.model.Game;
import net.tompy.gamegroup.spring.model.Venue;

public interface VenueDAO
{
    public List< Venue > getAllVenues();
    
    public Venue getVenue( int venueId );
    
    public void saveVenue( Venue g );
    
    public void deleteVenue( Venue venue );
}
