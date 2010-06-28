package strikers;

import java.util.HashSet;
import java.util.Map;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import readymade.entities.Entity;
import readymade.events.Event;
import readymade.scripts.JavascriptEntityFactory;
import readymade.scripts.ScriptLoader;
import readymade.scripts.ScriptType;
import strikers.components.RenderComponent;
import strikers.components.UpdateComponent;
import strikers.events.AddEventListener;
import strikers.events.RemoveEventListener;

/**
 * Tactical soccer game.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class Strikers extends BasicGame
{

    private static final String TITLE = "Strikers";
    private static final int WIDTH = 550;
    private static final int HEIGHT = 400;
    private static final int FPS = 30;
    private static final int BACKGROUND_COLOR = 0x00FF21;

    private final Color color;
    private final HashSet<Entity> entities;

    public Strikers()
    {
        super(Strikers.TITLE);
        this.color = new Color(BACKGROUND_COLOR);
        this.entities = new HashSet<Entity>();
    }

    @Override
    public final void render(GameContainer container, Graphics g) throws SlickException
    {
        g.setBackground(this.color);

        for (Entity entity : this.entities)
        {
            RenderComponent renderer = entity.getComponent(RenderComponent.TYPE);
            if (renderer != null)
            {
                renderer.render(g);
            }
        }
    }

    @Override
    public final void init(GameContainer container) throws SlickException
    {
        JavascriptEntityFactory factory = new JavascriptEntityFactory();
        ScriptLoader loader = new ScriptLoader("strikers/data/conf", ScriptType.JAVASCRIPT);
        Map<String, String> scripts = loader.loadScripts();

        for (String script : scripts.keySet())
        {
            factory.registerType(script, scripts.get(script));
        }

        this.add(factory.getEntity("SoccerBall"));
        this.add(factory.getEntity("Player"));
        this.add(factory.getEntity("Goal"));
    }

    @Override
    public final void update(GameContainer container, int delta) throws SlickException
    {
        Entity[] entities = this.entities.toArray(new Entity[0]);
        for (Entity entity : entities)
        {
            UpdateComponent engine = entity.getComponent(UpdateComponent.TYPE);
            if (engine != null)
            {
                engine.update(container.getInput(), delta);
            }
        }
    }

    public final void add(Entity e)
    {
        this.entities.add(e);
        e.addEventListener(Event.ADD_TO_STAGE, new AddEventListener(this));
        e.addEventListener(Event.REMOVE_FROM_STAGE, new RemoveEventListener(this));
    }

    public final void remove(Entity e)
    {
        this.entities.remove(e);
    }

    public static void main(String[] args)
    {
        try
        {
            AppGameContainer container = new AppGameContainer(new Strikers(), Strikers.WIDTH, Strikers.HEIGHT, false);
            container.setTargetFrameRate(Strikers.FPS);
            container.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

}
