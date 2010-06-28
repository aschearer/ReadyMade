package strikers.components;

import org.newdawn.slick.Graphics;

import readymade.components.Component;

/**
 * A component which knows how to draw an entity to the screen.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public abstract class RenderComponent implements Component
{
    public static final String TYPE = "renderer";

    @Override
    public final String getType()
    {
        return RenderComponent.TYPE;
    }

    public abstract void render(Graphics g);
}
