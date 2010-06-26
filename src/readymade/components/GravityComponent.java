package readymade.components;

import org.newdawn.slick.geom.Vector2f;

/**
 * Applies gravity to a physics component over time.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class GravityComponent extends UpdateComponent
{
    private PhysicsComponent body;

    public GravityComponent(PhysicsComponent body)
    {
        this.body = body;
    }

    @Override
    public void update(int delta)
    {
        Vector2f velocity = this.body.getVelocity();
        velocity.y -= delta * .01f;
        this.body.setVelocity(velocity);
    }
}
