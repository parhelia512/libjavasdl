package net.mcclendo.libjavasdl.api.gamecontroller;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.Union;

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
