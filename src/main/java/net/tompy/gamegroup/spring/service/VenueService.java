package net.tompy.gamegroup.spring.service;

import java.util.List;

import net.tompy.gamegroup.spring.model.Venue;

public interface VenueService
{
    public List< Venue > getAllVenues();
    
    public Venue getVenue( int venueId );
    
    public void deleteVenue( int venueId );
    
    public void saveVenue( Venue g );
}
