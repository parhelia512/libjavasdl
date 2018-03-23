package net.mcclendo.libjavasdl.api.hints;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_HintCallback extends Callback {

    void callback(
            Pointer userdata,
            String name,
            String oldValue,
            String newValue);
}
