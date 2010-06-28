package readymade;

/**
 * A physical object used for collision detection and similar.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public interface Body
{

    /**
     * Returns the leftmost x value for the body.
     * 
     * @return
     */
    float getX();

    /**
     * Returns the topmost y value for the body.
     * 
     * @return
     */
    float getY();

    float getWidth();

    float getHeight();
}
