package org.libsdl.api.joystick.virtual;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_SetLEDCallback extends Callback {

    void onSetLED(Pointer userdata, byte red, byte green, byte blue);
}
