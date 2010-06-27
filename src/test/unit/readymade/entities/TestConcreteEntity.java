package test.unit.readymade.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import readymade.entities.ConcreteEntity;
import readymade.events.Event;
import test.unit.readymade.MockComponent;
import test.unit.readymade.MockListener;

/**
 * Exercises the ConcreteEntity's methods ensuring that components and events
 * work as expected.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class TestConcreteEntity
{
    private ConcreteEntity entity;

    @Before
    public void setUp()
    {
        this.entity = new ConcreteEntity(0);
    }

    @Test
    public void testAddComponent()
    {
        this.entity.addComponent(new MockComponent("mock"));
        Assert.assertEquals(1, this.entity.getComponentCount());

        this.entity.addComponent(new MockComponent("renderer"));
        Assert.assertEquals(2, this.entity.getComponentCount());

        this.entity.addComponent(new MockComponent("renderer"));
        Assert.assertEquals(2, this.entity.getComponentCount());
    }

    @Test
    public void testAddEventListener()
    {
        this.entity.addEventListener("mock", new MockListener());
        Assert.assertEquals(1, this.entity.getEventListenerCount());

        this.entity.addEventListener("mock", new MockListener());
        Assert.assertEquals(2, this.entity.getEventListenerCount());

        this.entity.addEventListener("remove", new MockListener());
        Assert.assertEquals(3, this.entity.getEventListenerCount());
    }

    @Test
    public void testGetComponent()
    {
        MockComponent component = new MockComponent("mock");
        this.entity.addComponent(component);
        Assert.assertEquals(component, this.entity.getComponent("mock"));

        this.entity.addComponent(new MockComponent("mock"));
        Assert.assertNotSame(component, this.entity.getComponent("mock"));
    }

    @Test
    public void testRemoveComponent()
    {
        this.entity.addComponent(new MockComponent("mock"));
        Assert.assertEquals(1, this.entity.getComponentCount());

        this.entity.addComponent(new MockComponent("renderer"));
        Assert.assertEquals(2, this.entity.getComponentCount());

        this.entity.removeComponent("mock");
        Assert.assertEquals(1, this.entity.getComponentCount());

        this.entity.removeComponent("fake");
    }

    @Test
    public void testRemoveEventListener()
    {
        MockListener listener1 = new MockListener();
        this.entity.addEventListener("mock", listener1);
        Assert.assertEquals(1, this.entity.getEventListenerCount());

        MockListener listener2 = new MockListener();
        this.entity.addEventListener("mock", listener2);
        Assert.assertEquals(2, this.entity.getEventListenerCount());

        this.entity.removeEventListener("mock", listener1);
        Assert.assertEquals(1, this.entity.getEventListenerCount());

        this.entity.removeEventListener("fake", null);
        this.entity.removeEventListener("mock", null);
    }

    @Test
    public void testNotifyListeners()
    {
        this.entity.notifyListeners(new Event("mock", null));

        MockListener listener1 = new MockListener();
        this.entity.addEventListener("mock", listener1);
        this.entity.notifyListeners(new Event("mock", null));
        Assert.assertEquals(1, listener1.count);

        MockListener listener2 = new MockListener();
        this.entity.addEventListener("mock", listener2);
        this.entity.notifyListeners(new Event("mock", null));
        Assert.assertEquals(1, listener2.count);
        Assert.assertEquals(2, listener1.count);
    }

}
