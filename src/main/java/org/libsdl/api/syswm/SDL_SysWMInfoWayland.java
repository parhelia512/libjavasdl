package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "display",
        "surface",
        "shellSurface",
        "eglWindow",
        "xdgSurface"
})
public class SDL_SysWMInfoWayland extends Structure {

    /** Wayland display */
    public Pointer display;

    /** Wayland surface */
    public Pointer surface;

    /**
     * Wayland shell surface (window manager handle)
     *
     * @deprecated
     */
    public Pointer shellSurface;

    /** Wayland EGL window (native window) */
    public Pointer eglWindow;

    /** Wayland xdg surface (window manager handle) */
    public Pointer xdgSurface;

    public SDL_SysWMInfoWayland() {
    }

    public SDL_SysWMInfoWayland(Pointer p) {
        super(p);
    }
}
