package org.libsdl.api.log;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.intellij.lang.annotations.MagicConstant;

/**
 * <p><b>Warning:</b> It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.<br/>
 * In case you did not keep the reference you would encounter an error like this:<br/>
 * <code>JNA: callback object has been garbage collected</code></p>
 */
@FunctionalInterface
public interface SDL_LogOutputFunction extends Callback {

    void onLogMessage(
            Pointer userdata,
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority,
            String message);
}
