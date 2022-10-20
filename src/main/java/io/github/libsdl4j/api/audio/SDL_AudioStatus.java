package io.github.libsdl4j.api.audio;

import io.github.libsdl4j.jna.JnaEnum;
import org.intellij.lang.annotations.MagicConstant;

public final class SDL_AudioStatus implements JnaEnum {

    public static final int SDL_AUDIO_STOPPED = 0;
    public static final int SDL_AUDIO_PLAYING = 1;
    public static final int SDL_AUDIO_PAUSED = 2;

    public static String toString(
            @MagicConstant(valuesFromClass = SDL_AudioStatus.class) int value) {
        switch (value) {
            case SDL_AUDIO_STOPPED:
                return "SDL_AUDIO_STOPPED";
            case SDL_AUDIO_PLAYING:
                return "SDL_AUDIO_PLAYING";
            case SDL_AUDIO_PAUSED:
                return "SDL_AUDIO_PAUSED";
            default:
                return "UNKNOWN";
        }
    }

    private SDL_AudioStatus() {
    }
}
