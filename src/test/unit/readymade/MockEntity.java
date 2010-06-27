package test.unit.readymade;

import readymade.components.Component;
import readymade.entities.Entity;
import readymade.events.EventListener;

public class MockEntity implements Entity
{
    public int id;
    public int numberOfComponents;
    public int numberOfEventListeners;

    public MockEntity(int id)
    {
        this.id = id;
    }

    @Override
    public int getIdentity()
    {
        return this.id;
    }

    @Override
    public void addComponent(Component component)
    {
        this.numberOfComponents++;
    }

    @Override
    public void removeComponent(String component)
    {
        this.numberOfComponents--;
    }

    @Override
    public <T extends Component> T getComponent(String type)
    {
        return null;
    }

    @Override
    public void addEventListener(String event, EventListener listener)
    {
        this.numberOfEventListeners++;
    }

    @Override
    public void removeEventListener(String event, EventListener listener)
    {
        this.numberOfEventListeners--;
    }

}
