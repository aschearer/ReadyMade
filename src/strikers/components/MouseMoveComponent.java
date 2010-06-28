package strikers.components;

import org.newdawn.slick.Input;

import readymade.components.PhysicsComponent;

/**
 * Move the given body such that it follows the user's mouse.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class MouseMoveComponent extends UpdateComponent
{
    private final PhysicsComponent body;

    public MouseMoveComponent(PhysicsComponent body)
    {
        this.body = body;
    }

    @Override
    public final void update(Input input, int delta)
    {
        float mx = input.getMouseX();
        float my = input.getMouseY();

        this.body.setX(mx);
        this.body.setY(my);
    }

}
