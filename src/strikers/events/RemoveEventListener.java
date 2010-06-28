package strikers.events;

import readymade.entities.Entity;
import readymade.events.Event;
import readymade.events.EventListener;
import strikers.Strikers;

/**
 * Responsible for removing entities from the game.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class RemoveEventListener implements EventListener
{
    private final Strikers game;

    public RemoveEventListener(Strikers game)
    {
        this.game = game;
    }

    @Override
    public final void handleEvent(Entity sender, Event event)
    {
        this.game.remove(event.getTarget());
    }

}
