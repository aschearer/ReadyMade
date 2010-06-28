package strikers.components;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

import readymade.Body;
import readymade.entities.Entity;
import readymade.entities.EntityFactory;
import readymade.events.Event;

/**
 * Polls for a click adding a tracking entity when the player presses the mouse.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class MouseClickComponent extends UpdateComponent
{
    private final Entity owner;
    private final Body body;
    private final Entity marker;
    private boolean active;

    public MouseClickComponent(EntityFactory factory, Entity owner, Body body)
    {
        this.owner = owner;
        this.body = body;
        this.marker = factory.getEntity("Mark");
    }

    @Override
    public final void update(Input input, int delta)
    {
        this.testToActivate(input);
        this.testToDeactivate(input);
    }

    /**
     * If active and the player releases the mouse then remove the marker from
     * the stage.
     * 
     * @param input
     */
    private void testToDeactivate(Input input)
    {
        if (this.active && !input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
        {
            this.active = false;
            this.owner.notifyListeners(new Event(Event.REMOVE_FROM_STAGE, this.marker));
        }
    }

    /**
     * If the player clicks inside the host body, activate this component and
     * add the marker to the stage.
     * 
     * @param input
     */
    private void testToActivate(Input input)
    {
        float mx = input.getMouseX();
        float my = input.getMouseY();
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && this.intersects(this.body, mx, my))
        {
            this.active = true;
            this.owner.notifyListeners(new Event(Event.ADD_TO_STAGE, this.marker));
        }
    }

    /**
     * Test if the given point lies inside the bounding sphere for the body.
     * 
     * @param body
     * @param mx
     * @param my
     * @return
     */
    private boolean intersects(Body body, float mx, float my)
    {
        Vector2f vector = new Vector2f(mx, my);
        vector.x -= body.getX();
        vector.y -= body.getY();

        float radius = Math.max(body.getWidth(), body.getHeight());

        return vector.lengthSquared() < (radius * radius);
    }
}
