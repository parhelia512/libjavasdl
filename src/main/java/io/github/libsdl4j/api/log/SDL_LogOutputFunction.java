package io.github.libsdl4j.api.log;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.intellij.lang.annotations.MagicConstant;

/**
 * <p><b>Warning:</b> It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.</p>
 *
 * <p>In case you did not keep the reference you would encounter an error like this:</p>
 * <p><code>JNA: callback object has been garbage collected</code></p>
 */
@FunctionalInterface
public interface SDL_LogOutputFunction extends Callback {

    /**
     * The prototype for the log output callback function.
     *
     * <p>This function is called by SDL when there is a new text to be logged.</p>
     *
     * @param userdata what was passed as {@code userdata} to SDL_LogSetOutputFunction()
     * @param category the category of the message
     * @param priority the priority of the message
     * @param message the message being output
     */
    void onLogMessage(
            Pointer userdata,
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority,
            String message);
}
