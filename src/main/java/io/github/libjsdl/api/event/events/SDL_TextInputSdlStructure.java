package io.github.libjsdl.api.event.events;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_TextInputSdlStructure extends AbstractSdlStructure {

    private static final int BUF_SIZE = 32;

    public int type;
    public int timestamp;
    public int windowID;
    public byte[] text = new byte[BUF_SIZE];
}
