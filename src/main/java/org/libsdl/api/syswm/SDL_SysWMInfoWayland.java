package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "display",
        "surface",
        "shellSurface",
        "eglWindow",
        "xdgSurface",
        "xdgToplevel",
        "xdgPopup",
        "xdgPositioner"
})
public final class SDL_SysWMInfoWayland extends Structure {

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

    /** Wayland xdg toplevel role */
    public Pointer xdgToplevel;

    /** Wayland xdg popup role */
    public Pointer xdgPopup;

    /** Wayland xdg positioner, for popup */
    public Pointer xdgPositioner;

    public SDL_SysWMInfoWayland() {
    }

    public SDL_SysWMInfoWayland(Pointer p) {
        super(p);
    }
}
