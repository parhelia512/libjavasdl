package org.libsdl.api.haptic;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import org.libsdl.api.joystick.SDL_Joystick;

/**
 * The haptic structure used to identify an SDL haptic.
 *
 * @see SdlHaptic#SDL_HapticOpen(int)
 * @see SdlHaptic#SDL_HapticOpenFromJoystick(SDL_Joystick)
 * @see SdlHaptic#SDL_HapticClose(SDL_Haptic)
 */
public final class SDL_Haptic extends PointerType {

    public SDL_Haptic() {
        super();
    }

    public SDL_Haptic(Pointer p) {
        super(p);
    }
}
