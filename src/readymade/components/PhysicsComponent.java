package readymade.components;

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
    private float xVelocity, yVelocity;

    public PhysicsComponent(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public final String getType()
    {
        return PhysicsComponent.TYPE;
    }

    @Override
    public final float getX()
    {
        return this.x;
    }

    public final void setX(float x)
    {
        this.x = x;
    }

    @Override
    public final float getY()
    {
        return this.y;
    }

    public final void setY(float y)
    {
        this.y = y;
    }

    @Override
    public final float getWidth()
    {
        return this.width;
    }

    public final void setWidth(float width)
    {
        this.width = width;
    }

    @Override
    public final float getHeight()
    {
        return this.height;
    }

    public final void setHeight(float height)
    {
        this.height = height;
    }

    public final float getXVelocity()
    {
        return this.xVelocity;
    }

    public final void setXVelocity(float velocity)
    {
        this.xVelocity = velocity;
    }

    public final float getYVelocity()
    {
        return this.yVelocity;
    }

    public final void setYVelocity(float velocity)
    {
        this.yVelocity = velocity;
    }
}
