package org.libsdl.api.joystick.virtual;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_RumbleCallback extends Callback {

    void onRumble(Pointer userdata, short lowFrequencyRumble, short highFrequencyRumble);
}
