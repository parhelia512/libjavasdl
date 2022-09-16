package org.libsdl.api.joystick;

import java.util.UUID;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * A structure that encodes the stable unique id for a joystick device
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
@Structure.FieldOrder({
        "leastSigBits",
        "mostSigBits"
})
public final class SDL_JoystickGUID extends Structure implements Structure.ByValue {

    public long leastSigBits;
    public long mostSigBits;

    public SDL_JoystickGUID() {
    }

    public SDL_JoystickGUID(Pointer p) {
        super(p);
    }

    @Override
    public String toString() {
        return new UUID(mostSigBits, leastSigBits).toString();
    }
}
