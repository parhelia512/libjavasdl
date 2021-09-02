package io.github.libjsdl.api.video;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

import io.github.libjsdl.api.rect.SDL_Point;

@FunctionalInterface
public interface SDL_HitTest extends Callback {

    int callback(
            SDL_Window win,
            SDL_Point area,
            Pointer data);
}
