package strikers.components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import readymade.Body;
import readymade.components.Component;

/**
 * A component which knows how to render a body.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class RenderComponent implements Component
{

    public static final String TYPE = "renderer";

    private final Body body;
    private final Image sprite;

    public RenderComponent(String spritePath, Body body)
    {
        this.body = body;
        this.sprite = this.loadSprite(spritePath);
    }

    private Image loadSprite(String spritePath)
    {
        Image sprite = null;
        try
        {
            sprite = new Image(spritePath);
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }

        return sprite;
    }

    @Override
    public final String getType()
    {
        return RenderComponent.TYPE;
    }

    public final void render(Graphics g)
    {
        this.sprite.draw(this.body.getX(), this.body.getY(), this.body.getWidth(), this.body.getHeight());
    }

}
