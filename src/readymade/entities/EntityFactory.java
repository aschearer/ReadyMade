package readymade.entities;

/**
 * Factory responsible for constructing new entities.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public interface EntityFactory
{

    /**
     * Return a new entity of the designated type.
     * 
     * @param type
     * @return
     */
    Entity getEntity(String type);
}
