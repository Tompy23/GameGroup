package net.tompy.gamegroup.spring.dao;

import java.util.List;

import net.tompy.gamegroup.spring.model.Game;

public interface GameDAO
{
    public List< Game > getAllGames();
    
    public Game getGame( int gameId );
    
    public void saveGame( Game g );
    
    public void deleteGame( Game game );
}
