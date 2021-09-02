package io.github.libjsdl.api.joystick;

import io.github.libjsdl.jna.AbstractSdlStructure;

@SuppressWarnings({
        "checkstyle:AbbreviationAsWordInName",
        "checkstyle:MagicNumber"})
public final class SDL_JoystickGUID extends AbstractSdlStructure {
    public byte[] data = new byte[16];
}
