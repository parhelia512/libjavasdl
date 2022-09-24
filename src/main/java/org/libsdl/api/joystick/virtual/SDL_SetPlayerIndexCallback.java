package org.libsdl.api.joystick.virtual;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_SetPlayerIndexCallback extends Callback {

    void onSetPlayerIndex(Pointer userdata, int playerIndex);
}
