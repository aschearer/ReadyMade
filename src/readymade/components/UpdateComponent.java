package readymade.components;

/**
 * A component which should be updated every frame.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public abstract class UpdateComponent implements Component
{

    private static final String TYPE = "update";

    @Override
    public String getType()
    {
        return UpdateComponent.TYPE;
    }

    public abstract void update(int delta);
}
