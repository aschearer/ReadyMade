package readymade.entities;

import readymade.components.Component;
import readymade.events.EventListener;

/**
 * An object which is composed of a set of components and event listeners.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public interface Entity
{
    /**
     * Unique ID for the entity.
     * 
     * @return
     */
    int getIdentity();

    /**
     * Add the given component to the entity.
     * 
     * @param component
     */
    void addComponent(Component component);

    /**
     * Remove the given component from the entity.
     * 
     * @param component
     */
    void removeComponent(String component);

    /**
     * Retrieve the component of the given type.
     * 
     * @param <T>
     * @param type
     * @return
     */
    <T extends Component> T getComponent(String type);

    /**
     * Alert the listener whenever the given event is fired.
     * 
     * @param event
     * @param listener
     */
    void addEventListener(String event, EventListener listener);

    /**
     * Remove the listener for the given event.
     * 
     * @param event
     * @param listener
     */
    void removeEventListener(String event, EventListener listener);
}
