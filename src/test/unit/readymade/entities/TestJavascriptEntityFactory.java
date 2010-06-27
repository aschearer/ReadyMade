package test.unit.readymade.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import readymade.entities.JavascriptEntityFactory;
import test.unit.readymade.MockEntity;

/**
 * Test to ensure the JavascriptFactory correctly parses Javascript.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class TestJavascriptEntityFactory
{
    private JavascriptEntityFactory factory;
    private StringBuffer script;

    @Before
    public void setUp()
    {
        this.script = new StringBuffer();
        this.script.append("importClass(Packages.test.unit.readymade.MockEntity);\n");
        this.script.append("importClass(Packages.test.unit.readymade.MockComponent);\n");
        this.script.append("mock = new MockEntity(id);\n");
        this.script.append("mock.addComponent(new MockComponent(\"physics\"));\n");
        this.script.append("mock.addComponent(new MockComponent(\"renderer\"));\n");
        this.script.append("mock.addComponent(new MockComponent(\"engine\"));\n");
        this.script.append("mock\n");

        this.factory = new JavascriptEntityFactory();
        this.factory.registerType("mock1", this.script.toString());
    }

    @Test
    public void testGetEntity()
    {
        MockEntity e1 = (MockEntity) this.factory.getEntity("mock1");
        Assert.assertEquals(1, e1.getIdentity());
        Assert.assertEquals(3, e1.numberOfComponents);

        MockEntity e2 = (MockEntity) this.factory.getEntity("mock1");
        Assert.assertEquals(2, e2.getIdentity());
    }

}
