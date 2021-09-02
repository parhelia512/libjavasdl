package io.github.libjsdl.api.event.events;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_AudioDeviceEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public int which;
    public byte iscapture;
    public byte padding1;
    public byte padding2;
    public byte padding3;
}
