package net.mcclendo.libjavasdl.api.haptic;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_HapticLeftRight extends AbstractSdlStructure {
    
    public short type;          
    public int length;        
    public short largeMagnitude;
    public short smallMagnitude;
}
