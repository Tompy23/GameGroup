package net.tompy.gamegroup.spring.service;

import java.util.List;

import net.tompy.gamegroup.spring.model.Player;

public interface PlayerService
{
    public List< Player > getAllPlayers();
    
    public Player getPlayer( int playerId );
}
