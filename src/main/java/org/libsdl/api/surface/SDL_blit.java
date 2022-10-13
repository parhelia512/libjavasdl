package org.libsdl.api.surface;

import org.libsdl.api.rect.SDL_Rect;

@FunctionalInterface
public interface SDL_blit {

    /** The prototype of any and all functions used for surface blitting functions. */
    int SDL_BlitSurface(
            SDL_Surface src,
            SDL_Rect srcRect,
            SDL_Surface dst,
            SDL_Rect dstRect);
}
