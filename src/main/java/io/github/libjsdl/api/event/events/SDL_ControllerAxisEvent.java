package io.github.libjsdl.api.event.events;

import com.sun.jna.NativeLong;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_ControllerAxisEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public NativeLong which;
    public byte axis;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    public short value;
    public short padding4;
}
