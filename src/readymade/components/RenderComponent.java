package readymade.components;

import org.newdawn.slick.Graphics;

import readymade.Body;

/**
 * A component which knows how to render a body.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class RenderComponent implements Component
{

    private static final String TYPE = "renderer";

    private Body body;

    public RenderComponent(Body body)
    {
        this.body = body;
    }

    @Override
    public final String getType()
    {
        return RenderComponent.TYPE;
    }

    public final void render(Graphics g)
    {
        g.drawRect(this.body.getX(), this.body.getY(), this.body.getWidth(), this.body.getHeight());
    }

}
