package net.tompy.gamegroup.spring.dao;

import java.util.List;

import net.tompy.gamegroup.spring.model.Player;

public interface PlayerDAO
{
    public List< Player > getAllPlayers();
    
    public Player getPlayer( int playerId );
}
