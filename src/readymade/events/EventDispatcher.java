package readymade.events;

/**
 * An object which can dispatch events to event listeners.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public interface EventDispatcher
{

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

    /**
     * Fire listeners registered for the given event.
     * 
     * @param event
     */
    void notifyListeners(Event event);
}
