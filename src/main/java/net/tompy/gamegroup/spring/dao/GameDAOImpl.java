package net.tompy.gamegroup.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.tompy.gamegroup.spring.model.Game;

public class GameDAOImpl implements GameDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List< Game > getAllGames()
    {
        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< Game > games = (List< Game >) session.createQuery( "from Game" ).list();

        return games;

    }

    @Override
    public void saveGame( Game g )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.persist( g );
    }

    @Override
    public void deleteGame( Game game )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.delete( game );
    }

    @Override
    public Game getGame( int gameId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        return session.get( Game.class, gameId );
    }

}
