package net.tompy.gamegroup.spring.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.tompy.gamegroup.spring.model.Event;
import net.tompy.gamegroup.spring.model.Game;
import net.tompy.gamegroup.spring.model.Player;
import net.tompy.gamegroup.spring.model.RawEvent;
import net.tompy.gamegroup.spring.model.Venue;
import net.tompy.gamegroup.spring.service.EventService;
import net.tompy.gamegroup.spring.service.GameService;
import net.tompy.gamegroup.spring.service.PlayerService;
import net.tompy.gamegroup.spring.service.VenueService;

@Controller
@RequestMapping( value = "" )
public class EventController
{
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private VenueService venueService;
    @Autowired
    private EventService eventService;

    @RequestMapping( value = "/home", method = RequestMethod.GET )
    public String showEvents( ModelMap model )
    {
        List< Event > events = eventService.getAllEvents();
        model.addAttribute( "myEventList", events );
        model.addAttribute( "loginvisible", "visible" );
        return "index";
    }

    @RequestMapping( value = "/newevent" )
    public String createEvent( ModelMap model )
    {
        model.clear();

        RawEvent rawEvent = new RawEvent();

        Map< Integer, String > tmp = new LinkedHashMap< Integer, String >();
        for ( Venue v : venueService.getAllVenues() )
        {
            tmp.put( v.getId(), v.getName() );
        }
        Map< Integer, String > tmp2 = new LinkedHashMap< Integer, String >();
        for ( Player v : playerService.getAllPlayers() )
        {
            tmp2.put( v.getId(), v.getName() );
        }
        Map< Integer, String > tmp3 = new LinkedHashMap< Integer, String >();
        for ( Game v : gameService.getAllGames() )
        {
            tmp3.put( v.getId(), v.getName() );
        }
        model.addAttribute( "venueList", tmp );
        model.addAttribute( "playerList", tmp2 );
        model.addAttribute( "gameList", tmp3 );
        model.addAttribute( "loginvisible", "visible" );

        model.addAttribute( "myEvent", rawEvent );

        return "editevent";
    }

    @RequestMapping( value = "/editevent" )
    public String editEvent( @ModelAttribute( "eventIdToEdit" ) String eventId,
            ModelMap model )
    {
        RawEvent rawEvent = eventService.getRawEvent( Integer.valueOf( eventId ) );
        
        Map< Integer, String > tmp = new LinkedHashMap< Integer, String >();
        for ( Venue v : venueService.getAllVenues() )
        {
            tmp.put( v.getId(), v.getName() );
        }
        Map< Integer, String > tmp2 = new LinkedHashMap< Integer, String >();
        for ( Player v : playerService.getAllPlayers() )
        {
            tmp2.put( v.getId(), v.getName() );
        }
        Map< Integer, String > tmp3 = new LinkedHashMap< Integer, String >();
        for ( Game v : gameService.getAllGames() )
        {
            tmp3.put( v.getId(), v.getName() );
        }
        model.clear();
        model.addAttribute( "venueList", tmp );
        model.addAttribute( "playerList", tmp2 );
        model.addAttribute( "gameList", tmp3 );
        model.addAttribute( "loginvisible", "visible" );
        model.addAttribute( "myEvent", rawEvent );

        return "editevent";
    }

    @RequestMapping( value = "/saveevent" )
    public String saveEvent( @ModelAttribute( "myEvent" ) RawEvent myEvent, ModelMap model )
    {
        eventService.persistRawEvent( myEvent );

        return "redirect:/home";
    }

    @RequestMapping( value = "/deleteevent" )
    public String deleteEvent( @ModelAttribute( "eventIdToDelete" ) Integer eventId, ModelMap model )
    {
        eventService.deleteEvent( eventId );

        model.clear();
        model.addAttribute( "loginvisible", "visible" );

        return "redirect:/home";
    }

}