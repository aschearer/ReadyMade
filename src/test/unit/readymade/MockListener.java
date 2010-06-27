package test.unit.readymade;

import readymade.entities.Entity;
import readymade.events.Event;
import readymade.events.EventListener;

public class MockListener implements EventListener
{
    public int count;

    @Override
    public void handleEvent(Entity sender, Event event)
    {
        this.count++;
    }

}
