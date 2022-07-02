package org.libsdl.api.render;

import org.libsdl.jna.JnaEnum;
import org.libsdl.jna.JnaUtils;

public class SDL_TextureModulate implements JnaEnum {

    public static final int SDL_TEXTUREMODULATE_NONE = 0x00000000;
    public static final int SDL_TEXTUREMODULATE_COLOR = 0x00000001;
    public static final int SDL_TEXTUREMODULATE_ALPHA = 0x00000002;

    public static String toString(int value) {
        if (value == SDL_TEXTUREMODULATE_NONE) {
            return "SDL_TEXTUREMODULATE_NONE";
        }
        StringBuilder result = new StringBuilder(19);
        if ((value & SDL_TEXTUREMODULATE_COLOR) > 0) {
            JnaUtils.append(result, "SDL_TEXTUREMODULATE_COLOR");
        }
        if ((value & SDL_TEXTUREMODULATE_ALPHA) > 0) {
            JnaUtils.append(result, "SDL_TEXTUREMODULATE_ALPHA");
        }
        if (result.length() != 0) {
            return result.toString();
        } else {
            return JnaUtils.flagsUnknown(value);
        }
    }

    private SDL_TextureModulate() {
    }
}
