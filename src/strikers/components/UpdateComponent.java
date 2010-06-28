package strikers.components;

import org.newdawn.slick.Input;

import readymade.components.Component;

/**
 * A component which should be updated every frame.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public abstract class UpdateComponent implements Component
{

    public static final String TYPE = "update";

    @Override
    public final String getType()
    {
        return UpdateComponent.TYPE;
    }

    public abstract void update(Input input, int delta);
}
