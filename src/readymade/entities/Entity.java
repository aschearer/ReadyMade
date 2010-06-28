package readymade.entities;

import readymade.components.Component;
import readymade.events.EventDispatcher;

/**
 * An object which is composed of a set of components and event listeners.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public interface Entity extends EventDispatcher
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
}
