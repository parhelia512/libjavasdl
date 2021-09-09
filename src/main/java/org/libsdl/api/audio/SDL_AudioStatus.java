package org.libsdl.api.audio;

import org.libsdl.jna.JnaEnum;

public final class SDL_AudioStatus implements JnaEnum {

    public static final int SDL_AUDIO_STOPPED = 0;
    public static final int SDL_AUDIO_PLAYING = 1;
    public static final int SDL_AUDIO_PAUSED = 2;

    private SDL_AudioStatus() {
    }
}
