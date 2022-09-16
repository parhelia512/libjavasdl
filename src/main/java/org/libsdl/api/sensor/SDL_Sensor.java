package org.libsdl.api.sensor;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * A platform specific structure to identify a sensor.
 *
 * Treat it as an opaque pointer.
 */
public final class SDL_Sensor extends PointerType {

    /**
     * The default constructor wraps a NULL pointer.
     */
    public SDL_Sensor() {
    }

    /**
     * This constructor is typically used by {@link #fromNative} if generating
     * a new object instance.
     *
     * @param p pointer to the pre-allocated data
     */
    public SDL_Sensor(Pointer p) {
        super(p);
    }
}
