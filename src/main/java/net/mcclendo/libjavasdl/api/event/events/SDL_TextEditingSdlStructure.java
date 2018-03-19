package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_TextEditingSdlStructure extends AbstractSdlStructure {

    private static final int BUF_SIZE = 32;

    public int type;
    public int timestamp;
    public int windowID;
    public byte[] text = new byte[BUF_SIZE];
    public int start;
    public int length;
}
