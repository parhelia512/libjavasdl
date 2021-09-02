package io.github.libjsdl.api.event.events;

import com.sun.jna.NativeLong;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_JoyHatEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public NativeLong which;
    public byte hat;
    public byte value;
    public byte padding1;
    public byte padding2;
}
