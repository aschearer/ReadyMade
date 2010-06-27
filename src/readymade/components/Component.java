package readymade.components;

/**
 * Re-usable piece of logic which can be composed along with other components to
 * create a complex entity.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public interface Component
{
    /**
     * Handle for working with the component.
     * 
     * @return
     */
    String getType();
}
