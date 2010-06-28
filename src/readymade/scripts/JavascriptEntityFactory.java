package readymade.scripts;

import java.util.HashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import readymade.entities.Entity;
import readymade.entities.EntityFactory;

/**
 * Creates new entities by executing a Javascript configuration script.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class JavascriptEntityFactory implements EntityFactory
{
    private int counter;
    private final ScriptEngine engine;
    private final HashMap<String, String> scripts;

    public JavascriptEntityFactory()
    {
        ScriptEngineManager factory = new ScriptEngineManager();
        this.engine = factory.getEngineByName("javascript");
        this.scripts = new HashMap<String, String>();
    }

    public final void registerType(String type, String script)
    {
        this.scripts.put(type, script);
    }

    @Override
    public final Entity getEntity(String type)
    {
        this.counter++;
        this.engine.put("id", this.counter);
        this.engine.put("factory", this);

        Entity entity = null;

        try
        {
            entity = (Entity) this.engine.eval(this.scripts.get(type));
        }
        catch (ScriptException e)
        {
            e.printStackTrace();
        }

        return entity;
    }

}
