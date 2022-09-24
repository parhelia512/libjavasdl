package org.libsdl.api.joystick.virtual;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_RumbleTriggersCallback extends Callback {

    void onRumble(Pointer userdata, short leftRumble, short rightRumble);
}
