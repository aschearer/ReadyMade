package readymade.components;

import org.newdawn.slick.geom.Vector2f;

import readymade.Body;

/**
 * Encapsulates physics data such as position, dimension, and velocity.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class PhysicsComponent implements Body, Component
{
    public static final String TYPE = "physics";

    private float x, y;
    private float width, height;
    private Vector2f velocity;

    public PhysicsComponent(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = new Vector2f();
    }

    @Override
    public String getType()
    {
        return PhysicsComponent.TYPE;
    }

    public float getX()
    {
        return this.x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return this.y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float getWidth()
    {
        return this.width;
    }

    public void setWidth(float width)
    {
        this.width = width;
    }

    public float getHeight()
    {
        return this.height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    public Vector2f getVelocity()
    {
        return this.velocity.copy();
    }

    public void setVelocity(Vector2f velocity)
    {
        this.velocity = velocity;
    }
}
