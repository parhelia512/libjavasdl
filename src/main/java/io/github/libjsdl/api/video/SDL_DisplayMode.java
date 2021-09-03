package io.github.libjsdl.api.video;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "format",
        "w",
        "h",
        "refreshRate",
        "driverdata"
})
public final class SDL_DisplayMode extends Structure {

    public int format;
    public int w;
    public int h;
    public int refreshRate;
    public Pointer driverdata;
}
