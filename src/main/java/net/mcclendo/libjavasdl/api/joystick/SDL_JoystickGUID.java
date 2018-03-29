package net.mcclendo.libjavasdl.api.joystick;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

@SuppressWarnings({
        "checkstyle:AbbreviationAsWordInName",
        "checkstyle:MagicNumber"})
public final class SDL_JoystickGUID extends AbstractSdlStructure {
    public byte[] data = new byte[16];
}
