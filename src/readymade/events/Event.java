package readymade.events;

import readymade.entities.Entity;

/**
 * Payload for an event listener.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class Event
{
    private String type;
    private Entity target;

    public Event(String type, Entity target)
    {
        this.type = type;
        this.target = target;
    }

    public final String getType()
    {
        return this.type;
    }

    public final Entity getTarget()
    {
        return this.target;
    }
}
