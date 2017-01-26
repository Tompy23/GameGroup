package net.tompy.gamegroup.spring.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.tompy.gamegroup.spring.dao.GameDAO;
import net.tompy.gamegroup.spring.model.Game;

public class GameServiceImpl implements GameService
{
    @Autowired
    private GameDAO gameDAO;

    @Override
    @Transactional
    public List< Game > getAllGames()
    {
        List< Game > returnValue = gameDAO.getAllGames();
        
        Collections.sort( returnValue );

        return returnValue;
    }

    @Override
    @Transactional
    public Game getGame( int gameId )
    {
        return gameDAO.getGame( gameId );
    }

    @Override
    @Transactional
    public void saveGame( Game g )
    {
        Game game = null;
        if ( g.getId() > 0 )
        {
            game = gameDAO.getGame( g.getId() );
            game.setName( g.getName() );
        }
        else
        {
            game = new Game( g.getId(), g.getName() );
        }
        gameDAO.saveGame( game );
    }

    @Override
    @Transactional
    public void deleteGame( int gameId )
    {
        Game g = gameDAO.getGame( gameId );
        gameDAO.deleteGame( g );
    }

}
