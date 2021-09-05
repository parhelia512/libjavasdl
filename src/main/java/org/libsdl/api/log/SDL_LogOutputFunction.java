package org.libsdl.api.log;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.intellij.lang.annotations.MagicConstant;

@FunctionalInterface
public interface SDL_LogOutputFunction extends Callback {

    void callback(
            Pointer userdata,
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority,
            String message);
}
