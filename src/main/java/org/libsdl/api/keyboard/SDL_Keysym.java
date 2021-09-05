package org.libsdl.api.keyboard;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.keycode.SDL_Keycode;
import org.libsdl.api.scancode.SDL_Scancode;

@Structure.FieldOrder({
        "scancode",
        "sym",
        "mod",
        "unused"
})
public final class SDL_Keysym extends Structure {

    @MagicConstant(valuesFromClass = SDL_Scancode.class)
    public int scancode;

    @MagicConstant(valuesFromClass = SDL_Keycode.class)
    public int sym;

    public short mod;

    public int unused;
}
