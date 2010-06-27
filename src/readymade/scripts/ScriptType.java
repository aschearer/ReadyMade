package readymade.scripts;

/**
 * Used to determine what files to filter when loading scripts.
 * 
 * @author Alex Schearer <aschearer@gmail.com>
 */
public enum ScriptType
{
    JAVASCRIPT;

    protected String toExtension()
    {
        switch (this)
        {
            case JAVASCRIPT:
                return ".js";
            default:
                throw new RuntimeException("No extension found for given ScriptType.");
        }
    }
}
