package net.tompy.gamegroup.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.tompy.gamegroup.spring.model.Game;
import net.tompy.gamegroup.spring.service.GameService;

@Controller
@RequestMapping( "" )
public class GameController
{
    @Autowired
    private GameService gameService;

    @RequestMapping( value = "/games", method = RequestMethod.GET )
    public String listGames( ModelMap model )
    {
        model.clear();
        model.addAttribute( "myGameList", gameService.getAllGames() );
        model.addAttribute( "loginvisible", "visible" );

        return "listgames";
    }

    @RequestMapping( value = "/newgame" )
    public String createGame( ModelMap model )
    {
        model.clear();
        model.addAttribute( "myGame", new Game() );
        model.addAttribute( "myGameList", gameService.getAllGames() );
        model.addAttribute( "loginvisible", "visible" );

        return "editgame";
    }

    @RequestMapping( value = "/editgame" )
    public String editGame( @ModelAttribute( "gameId" ) String gameId, ModelMap model )
    {
        String returnValue = "editgame";

        model.addAttribute( "myGameList", gameService.getAllGames() );
        model.addAttribute( "loginvisible", "visible" );

        if ( !"".equals( gameId ) )
        {
            Game game = gameService.getGame( Integer.valueOf( gameId ) );
            model.addAttribute( "myGame", game );
        }
        else
        {
            returnValue = "redirect:games";
        }
        
        return returnValue;
    }

    @RequestMapping( value = "/savegame", method = RequestMethod.POST )
    public String saveGame( @ModelAttribute( "gameName" ) String gameName,
            @ModelAttribute( "gameIdOld" ) String gameIdOld,
            ModelMap model )
    {
        if ( !"".equals( gameName ) )
        {
            Game g = new Game( 0, gameName );
            if ( !"".equals( gameIdOld ) )
            {
                g.setId( Integer.valueOf( gameIdOld ) );
            }
            gameService.saveGame( g );
        }

        model.clear();
        model.addAttribute( "myGameList", gameService.getAllGames() );
        model.addAttribute( "loginvisible", "visible" );

        return "redirect:/games";
    }

    @RequestMapping( value = "/deletegame" )
    public String deleteGame( @ModelAttribute( "gameIdToDelete" ) Integer gameId, ModelMap model )
    {
        gameService.deleteGame( gameId );

        model.clear();
        model.addAttribute( "myGameList", gameService.getAllGames() );
        model.addAttribute( "loginvisible", "visible" );

        return "redirect:/games";
    }
}
