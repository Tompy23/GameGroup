package net.tompy.gamegroup.spring.service;

import java.util.List;

import net.tompy.gamegroup.spring.model.Game;

public interface GameService
{
    public List< Game > getAllGames();
    
    public Game getGame( int gameId );
    
    public void deleteGame( int gameId );
    
    public void saveGame( Game g );
}
