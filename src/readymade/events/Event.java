package readymade.events;

import readymade.entities.Entity;

/**
 * Payload for an event listener.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class Event
{
    public static final String ADD_TO_STAGE = "added";
    public static final String REMOVE_FROM_STAGE = "removed";

    private final String type;
    private final Entity target;

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
