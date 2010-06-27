package readymade.entities;

import java.util.HashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Creates new entities by executing a Javascript configuration script.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class JavascriptEntityFactory implements EntityFactory
{
    private int counter;
    private ScriptEngine engine;
    private HashMap<String, String> scripts;

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
        engine.put("id", this.counter);

        Entity entity = null;

        try
        {
            entity = (Entity) engine.eval(this.scripts.get(type));
        }
        catch (ScriptException e)
        {
            e.printStackTrace();
        }

        return entity;
    }

}
