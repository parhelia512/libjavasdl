package io.github.libsdl4j.api.video;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * An opaque handle to an OpenGL context.
 */
public final class SDL_GLContext extends PointerType {

    public SDL_GLContext() {
    }

    public SDL_GLContext(Pointer p) {
        super(p);
    }
}
