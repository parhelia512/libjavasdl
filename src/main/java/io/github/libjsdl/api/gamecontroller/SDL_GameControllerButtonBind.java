package io.github.libjsdl.api.gamecontroller;

import com.sun.jna.Structure;
import com.sun.jna.Union;

@Structure.FieldOrder({
        "bindType",
        "value"
})
public class SDL_GameControllerButtonBind extends Structure {

    public int bindType;
    public Value value;

    public static final class Value extends Union {
        public int button;
        public int axis;
        public Hat hat;
    }

    @Structure.FieldOrder({
            "hat",
            "hatMask"
    })
    public static final class Hat extends Structure {
        public int hat;
        public int hatMask;
    }
}
