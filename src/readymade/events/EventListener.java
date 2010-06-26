package readymade.events;

import readymade.entities.Entity;

/**
 * Handles events fired by entities.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public interface EventListener
{

    /**
     * Take custom actoin based on the event and sender.
     * 
     * @param sender
     * @param event
     */
    void handleEvent(Entity sender, Event event);
}
