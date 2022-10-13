package io.github.libsdl4j.api.video;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * The structure that defines a display mode
 *
 * @see SdlVideo#SDL_GetNumDisplayModes(int)
 * @see SdlVideo#SDL_GetDisplayMode(int, int, SDL_DisplayMode)
 * @see SdlVideo#SDL_GetDesktopDisplayMode(int, SDL_DisplayMode)
 * @see SdlVideo#SDL_GetCurrentDisplayMode(int, SDL_DisplayMode)
 * @see SdlVideo#SDL_GetClosestDisplayMode(int, SDL_DisplayMode, SDL_DisplayMode)
 * @see SdlVideo#SDL_SetWindowDisplayMode(SDL_Window, SDL_DisplayMode)
 * @see SdlVideo#SDL_GetWindowDisplayMode(SDL_Window, SDL_DisplayMode)
 */
@Structure.FieldOrder({
        "format",
        "w",
        "h",
        "refreshRate",
        "driverdata"
})
public final class SDL_DisplayMode extends Structure {

    /** pixel format */
    public int format;

    /** width, in screen coordinates */
    public int w;

    /** height, in screen coordinates */
    public int h;

    /** refresh rate (or zero for unspecified) */
    public int refreshRate;

    /** driver-specific data, initialize to 0 */
    public Pointer driverdata;

    public SDL_DisplayMode() {
    }

    public SDL_DisplayMode(Pointer p) {
        super(p);
    }
}
