package test.unit.readymade.scripts;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import readymade.scripts.ScriptLoader;
import readymade.scripts.ScriptType;

public class TestScriptLoader
{

    private static final String TEST_DIR = "test/unit/readymade/scripts/data";

    @Test
    public void testLoadScripts()
    {
        ScriptLoader loader = new ScriptLoader(TestScriptLoader.TEST_DIR, ScriptType.JAVASCRIPT);
        Map<String, String> scripts = loader.loadScripts();

        Assert.assertEquals(2, scripts.size());
        Assert.assertTrue(scripts.containsKey("foo"));
        Assert.assertTrue(scripts.containsKey("bar"));
        Assert.assertFalse(scripts.containsKey("baz"));
    }

}
