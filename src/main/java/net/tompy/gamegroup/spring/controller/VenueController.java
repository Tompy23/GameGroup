package net.tompy.gamegroup.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.tompy.gamegroup.spring.model.Venue;
import net.tompy.gamegroup.spring.service.VenueService;

@Controller
@RequestMapping( "" )
public class VenueController
{
    @Autowired
    private VenueService venueService;

    @RequestMapping( value = "/venues", method = RequestMethod.GET )
    public String listVenues( ModelMap model )
    {
        model.clear();
        model.addAttribute( "myVenueList", venueService.getAllVenues() );
        model.addAttribute( "loginvisible", "visible" );

        return "listvenues";
    }

    @RequestMapping( value = "/newvenue" )
    public String createVenue( ModelMap model )
    {
        model.clear();
        model.addAttribute( "myVenue", new Venue() );
        model.addAttribute( "myVenueList", venueService.getAllVenues() );
        model.addAttribute( "loginvisible", "visible" );

        return "editvenue";
    }

    @RequestMapping( value = "/editvenue" )
    public String editVenue( @ModelAttribute( "venueId" ) String venueId, ModelMap model )
    {
        String returnValue = "editvenue";

        model.addAttribute( "myVenueList", venueService.getAllVenues() );
        model.addAttribute( "loginvisible", "visible" );

        if ( !"".equals( venueId ) )
        {
            Venue venue = venueService.getVenue( Integer.valueOf( venueId ) );
            model.addAttribute( "myVenue", venue );
        }
        else
        {
            returnValue = "redirect:venues";
        }
        
        return returnValue;
    }

    @RequestMapping( value = "/savevenue", method = RequestMethod.POST )
    public String saveVenue( @ModelAttribute( "venueName" ) String venueName,
            @ModelAttribute( "venueIdOld" ) String venueIdOld,
            ModelMap model )
    {
        if ( !"".equals( venueName ) )
        {
            Venue g = new Venue( 0, venueName );
            if ( !"".equals( venueIdOld ) )
            {
                g.setId( Integer.valueOf( venueIdOld ) );
            }
            venueService.saveVenue( g );
        }

        model.clear();
        model.addAttribute( "myVenueList", venueService.getAllVenues() );
        model.addAttribute( "loginvisible", "visible" );

        return "redirect:/venues";
    }

    @RequestMapping( value = "/deletevenue" )
    public String deleteVenue( @ModelAttribute( "venueIdToDelete" ) Integer venueId, ModelMap model )
    {
        venueService.deleteVenue( venueId );

        model.clear();
        model.addAttribute( "myVenueList", venueService.getAllVenues() );
        model.addAttribute( "loginvisible", "visible" );

        return "redirect:/venues";
    }
}
