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
public class AbstractEntity implements Entity
{
    private HashMap<String, Component> components;
    private HashMap<String, HashSet<EventListener>> listeners;

    public AbstractEntity()
    {
        this.components = new HashMap<String, Component>();
        this.listeners = new HashMap<String, HashSet<EventListener>>();
    }

    @Override
    public void addComponent(Component component)
    {
        this.components.put(component.getType(), component);
    }

    @Override
    public void addEventListener(String event, EventListener listener)
    {
        HashSet<EventListener> eventListeners = this.listeners.get(event);
        if (eventListeners == null)
        {
            eventListeners = new HashSet<EventListener>();
            this.listeners.put(event, eventListeners);
        }

        eventListeners.add(listener);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Component> T getComponent(String type)
    {
        return (T) this.components.get(type);
    }

    @Override
    public void removeComponent(String component)
    {
        this.components.remove(component);
    }

    @Override
    public void removeEventListener(String event, EventListener listener)
    {
        if (this.listeners.containsKey(event))
        {
            this.listeners.get(event).remove(listener);
        }
    }

    /**
     * Notify any event listeners for the given event.
     * 
     * @param event
     */
    protected void notifyListeners(Event event)
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

}
