package io.github.libsdl4j.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "window",
        "framebuffer",
        "colorbuffer",
        "resolveFramebuffer"
})
public final class SDL_SysWMInfoUIKit extends Structure {

    /** The UIKit window ({@code UIWindow *}) */
    public Pointer window;

    /** The GL view's Framebuffer Object. It must be bound when rendering to the screen using GL. ({@code GLuint}) */
    public int framebuffer;

    /** The GL view's color Renderbuffer Object. It must be bound when SDL_GL_SwapWindow is called. ({@code GLuint}) */
    public int colorbuffer;

    /** The Framebuffer Object which holds the resolve color Renderbuffer, when MSAA is used. ({@code GLuint}) */
    public int resolveFramebuffer;

    public SDL_SysWMInfoUIKit() {
    }

    public SDL_SysWMInfoUIKit(Pointer p) {
        super(p);
    }
}
