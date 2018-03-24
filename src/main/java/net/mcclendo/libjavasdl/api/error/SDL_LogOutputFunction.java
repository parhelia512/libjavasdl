package net.mcclendo.libjavasdl.api.error;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_LogOutputFunction extends Callback {

    void callback(
            Pointer userdata,
            int category,
            int priority,
            String message);
}
