package readymade.scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Responsible for loading configuration scripts into memory.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public class ScriptLoader
{

    private final String directory;
    private final ScriptType type;

    /**
     * Create a new ScriptLoader working with the given directory and looking
     * for scripts of the given type.
     * 
     * @param directory
     * @param type
     */
    public ScriptLoader(String directory, ScriptType type)
    {
        this.directory = directory;
        this.type = type;
    }

    /**
     * Retrieve a list of name-script key-value pairs.
     * 
     * @return
     */
    public final Map<String, String> loadScripts()
    {
        HashMap<String, String> scripts = new HashMap<String, String>();
        try
        {
            URL url = this.getClass().getClassLoader().getResource(this.directory);
            if (url == null)
            {
                throw new RuntimeException("The following directory was not found: " + this.directory);
            }

            URI uri = new URI(url.toString());

            File directory = new File(uri);
            FilenameFilter filter = new JavascriptFilter();

            for (String file : directory.list(filter))
            {
                String script = this.readScript(directory, file);

                int dotIndex = file.lastIndexOf('.');
                scripts.put(file.substring(0, dotIndex), script.toString());
            }
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return scripts;
    }

    private String readScript(File directory, String file) throws FileNotFoundException
    {
        File script = new File(directory, file);
        Scanner scanner = new Scanner(script);

        StringBuffer buffer = new StringBuffer();
        while (scanner.hasNextLine())
        {
            buffer.append(scanner.nextLine() + "\n");
        }
        return buffer.toString();
    }

    /**
     * Filters out files with the wrong extension.
     * 
     * @author Alex Schearer <aschearer@gmail.com>
     */
    private class JavascriptFilter implements FilenameFilter
    {

        @Override
        public boolean accept(File dir, String name)
        {
            return name.endsWith(ScriptLoader.this.type.toExtension());
        }

    }
}
