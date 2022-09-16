package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "display",
        "surface",
        "shell_surface",
        "egl_window",
        "xdg_surface"
})
public class SDL_SysWMInfoWayland extends Structure {

    /** Wayland display */
    public Pointer display;

    /** Wayland surface */
    public Pointer surface;

    /**
     * Wayland shell_surface (window manager handle)
     *
     * @deprecated
     */
    public Pointer shell_surface;

    /** Wayland EGL window (native window) */
    public Pointer egl_window;

    /** Wayland xdg surface (window manager handle) */
    public Pointer xdg_surface;

    public SDL_SysWMInfoWayland() {
    }

    public SDL_SysWMInfoWayland(Pointer p) {
        super(p);
    }
}
