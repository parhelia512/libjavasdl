package org.libsdl.api.audio;

import com.sun.jna.Callback;

@FunctionalInterface
public interface SDL_AudioFilter extends Callback {

    void filter(
            SDL_AudioCVT cvt,
            SDL_AudioFormat format);
}
