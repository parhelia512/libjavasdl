package io.github.libsdl4j.api.syswm;

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

    /** Wayland display ({@code wl_display *}) */
    public Pointer display;

    /** Wayland surface ({@code wl_surface *}) */
    public Pointer surface;

    /**
     * Wayland shell surface (window manager handle) ({@code void *})
     *
     * @deprecated
     */
    public Pointer shellSurface;

    /** Wayland EGL window (native window) ({@code wl_egl_window *}) */
    public Pointer eglWindow;

    /** Wayland xdg surface (window manager handle) ({@code xdg_surface *}) */
    public Pointer xdgSurface;

    /** Wayland xdg toplevel role ({@code xdg_toplevel *}) */
    public Pointer xdgToplevel;

    /** Wayland xdg popup role ({@code xdg_popup *}) */
    public Pointer xdgPopup;

    /** Wayland xdg positioner, for popup ({@code xdg_positioner *}) */
    public Pointer xdgPositioner;

    public SDL_SysWMInfoWayland() {
    }

    public SDL_SysWMInfoWayland(Pointer p) {
        super(p);
    }
}
