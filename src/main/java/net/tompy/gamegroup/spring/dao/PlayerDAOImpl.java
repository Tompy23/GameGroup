package net.tompy.gamegroup.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.tompy.gamegroup.spring.model.Player;

public class PlayerDAOImpl implements PlayerDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List< Player > getAllPlayers()
    {
        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< Player > players = (List< Player >) session.createQuery( "from Player" ).list();

        return players;
    }

    @Override
    public Player getPlayer( int playerId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        return session.get(  Player.class, playerId );
    }

}
