package io.github.libjsdl.api.joystick;

import com.sun.jna.Structure;

@SuppressWarnings({
        "checkstyle:AbbreviationAsWordInName",
        "checkstyle:MagicNumber"})
@Structure.FieldOrder({
        "data"
})
public final class SDL_JoystickGUID extends Structure {

    public byte[] data = new byte[16];
}
