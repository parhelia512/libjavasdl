package org.libsdl.api.video;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.rect.SDL_Point;

@FunctionalInterface
public interface SDL_HitTest extends Callback {

    @MagicConstant(valuesFromClass = SDL_HitTestResult.class)
    int callback(
            SDL_Window win,
            SDL_Point area,
            Pointer data);
}
