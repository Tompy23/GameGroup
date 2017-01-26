package net.tompy.gamegroup.spring.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.tompy.gamegroup.spring.dao.PlayerDAO;
import net.tompy.gamegroup.spring.model.Player;

public class PlayerServiceImpl implements PlayerService
{
    
    @Autowired PlayerDAO playerDAO;

    @Override
    @Transactional
    public List< Player > getAllPlayers()
    {
        List< Player > players = playerDAO.getAllPlayers();
        
        Collections.sort(  players );
        
        return players;
    }

    @Override
    @Transactional
    public Player getPlayer( int playerId )
    {
        return playerDAO.getPlayer( playerId );
    }

}
