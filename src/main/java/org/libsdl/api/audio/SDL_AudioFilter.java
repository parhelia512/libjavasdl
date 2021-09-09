package org.libsdl.api.audio;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;

@FunctionalInterface
public interface SDL_AudioFilter extends Callback {

    void callback(
            SDL_AudioCVT cvt,
            SDL_AudioFormat format);
}
