package org.libsdl.api.joystick.virtual;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_SendEffectCallback extends Callback {

    void onSendEffect(Pointer userdata, Pointer data, int size);
}
