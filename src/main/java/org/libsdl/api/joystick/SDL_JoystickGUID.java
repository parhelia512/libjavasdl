package org.libsdl.api.joystick;

import java.util.UUID;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

/**
 * A structure that encodes the stable unique id for a joystick device
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
@Structure.FieldOrder({
        "leastSigBits",
        "mostSigBits"
})
public final class SDL_JoystickGUID extends JnaStructure implements Structure.ByValue {

    public long leastSigBits;
    public long mostSigBits;

    @Override
    public String toString() {
        return new UUID(mostSigBits, leastSigBits).toString();
    }
}
