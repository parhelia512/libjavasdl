package io.github.libjsdl.api.gamecontroller;

import com.sun.jna.Union;

import io.github.libjsdl.jna.AbstractSdlStructure;

public class SDL_GameControllerButtonBind extends AbstractSdlStructure {

    public int bindType;
    public Value value;

    public static final class Value extends Union {
        public int button;
        public int axis;
        public Hat hat;
    }

    public static final class Hat extends AbstractSdlStructure {
        public int hat;
        public int hatMask;
    }
}
