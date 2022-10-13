package io.github.libsdl4j.api.gamecontroller;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.gamecontroller.SDL_GameControllerBindType.SDL_CONTROLLER_BINDTYPE_AXIS;
import static io.github.libsdl4j.api.gamecontroller.SDL_GameControllerBindType.SDL_CONTROLLER_BINDTYPE_BUTTON;
import static io.github.libsdl4j.api.gamecontroller.SDL_GameControllerBindType.SDL_CONTROLLER_BINDTYPE_HAT;

/**
 * Get the SDL joystick layer binding for this controller button/axis mapping
 */
@Structure.FieldOrder({
        "bindType",
        "value"
})
public final class SDL_GameControllerButtonBind extends Structure {

    @MagicConstant(valuesFromClass = SDL_GameControllerBindType.class)
    public int bindType;
    public Value value;

    public SDL_GameControllerButtonBind() {
    }

    public SDL_GameControllerButtonBind(Pointer p) {
        super(p);
    }

    @Override
    public void read() {
        readField("bindType");
        switch (bindType) {
            case SDL_CONTROLLER_BINDTYPE_BUTTON:
                value.setType("button");
                break;
            case SDL_CONTROLLER_BINDTYPE_AXIS:
                value.setType("axis");
                break;
            case SDL_CONTROLLER_BINDTYPE_HAT:
                value.setType("hat");
                break;
            default:
                throw new IllegalStateException("Invalid bind type: " + bindType);
        }
        super.read();
    }

    public static final class Value extends Union {

        public int button;
        public int axis;
        public Hat hat;

        public Value() {
        }

        public Value(Pointer p) {
            super(p);
        }
    }

    @Structure.FieldOrder({
            "hat",
            "hatMask"
    })
    public static final class Hat extends Structure {

        public int hat;
        public int hatMask;

        public Hat() {
        }

        public Hat(Pointer p) {
            super(p);
        }
    }
}
