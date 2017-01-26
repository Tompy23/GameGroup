package net.tompy.gamegroup.spring.dao;

import net.tompy.gamegroup.spring.model.EventPlayer;

public interface EventPlayerDAO
{
    public EventPlayer getEventPlayer( int eventId, int playerId );

    public void removeEventPlayer( EventPlayer ep );
}
