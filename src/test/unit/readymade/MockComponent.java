package test.unit.readymade;

import readymade.components.Component;

public class MockComponent implements Component
{

    private String type;

    public MockComponent(String type)
    {
        this.type = type;
    }

    @Override
    public String getType()
    {
        return this.type;
    }

}
