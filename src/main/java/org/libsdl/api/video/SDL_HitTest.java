package org.libsdl.api.video;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.libsdl.api.rect.SDL_Point;

@FunctionalInterface
public interface SDL_HitTest extends Callback {

    int callback(
            SDL_Window win,
            SDL_Point area,
            Pointer data);
}
