package strikers.events;

import readymade.entities.Entity;
import readymade.events.Event;
import readymade.events.EventListener;
import strikers.Strikers;

/**
 * Responsible for adding entities to the game.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class AddEventListener implements EventListener
{
    private final Strikers game;

    public AddEventListener(Strikers game)
    {
        this.game = game;
    }

    @Override
    public final void handleEvent(Entity sender, Event event)
    {
        this.game.add(event.getTarget());
    }

}
