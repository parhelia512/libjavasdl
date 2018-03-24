package net.mcclendo.libjavasdl.api.video;

import net.mcclendo.libjavasdl.api.rect.SDL_Point;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_HitTest extends Callback {

    int callback(
            SDL_Window win,
            SDL_Point area,
            Pointer data);
}
