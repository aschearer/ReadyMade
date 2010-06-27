package readymade.entities;

import java.util.HashMap;
import java.util.HashSet;

import readymade.components.Component;
import readymade.events.Event;
import readymade.events.EventListener;

/**
 * Base class handling common component and event management.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class ConcreteEntity implements Entity
{
    private int identity;
    private HashMap<String, Component> components;
    private HashMap<String, HashSet<EventListener>> listeners;
    private int numberOfEventListeners;

    public ConcreteEntity(int id)
    {
        this.identity = id;
        this.components = new HashMap<String, Component>();
        this.listeners = new HashMap<String, HashSet<EventListener>>();
    }

    @Override
    public final int getIdentity()
    {
        return this.identity;
    }

    public final int getComponentCount()
    {
        return this.components.size();
    }

    public final int getEventListenerCount()
    {
        return this.numberOfEventListeners;
    }

    @Override
    public final void addComponent(Component component)
    {
        this.components.put(component.getType(), component);
    }

    @Override
    public final void addEventListener(String event, EventListener listener)
    {
        HashSet<EventListener> eventListeners = this.listeners.get(event);
        if (eventListeners == null)
        {
            eventListeners = new HashSet<EventListener>();
            this.listeners.put(event, eventListeners);
        }

        if (!eventListeners.contains(listener))
        {
            this.numberOfEventListeners++;
            eventListeners.add(listener);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public final <T extends Component> T getComponent(String type)
    {
        return (T) this.components.get(type);
    }

    @Override
    public final void removeComponent(String component)
    {
        this.components.remove(component);
    }

    @Override
    public final void removeEventListener(String event, EventListener listener)
    {
        if (this.listeners.containsKey(event))
        {
            if (this.listeners.get(event).contains(listener))
            {
                this.numberOfEventListeners--;
                this.listeners.get(event).remove(listener);
            }
        }
    }

    /**
     * Notify any event listeners for the given event.
     * 
     * @param event
     */
    public final void notifyListeners(Event event)
    {
        HashSet<EventListener> eventListeners = this.listeners.get(event.getType());
        if (eventListeners != null)
        {
            for (EventListener listener : eventListeners)
            {
                listener.handleEvent(this, event);
            }
        }
    }

    @Override
    public final String toString()
    {
        return "Entity " + this.identity;
    }

}
