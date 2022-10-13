package io.github.libsdl4j.api.sensor;

import com.sun.jna.IntegerType;

/**
 * This is a unique ID for a sensor for the time it is connected to the system,
 * and is never reused for the lifetime of the application.
 *
 * <p>The ID value starts at 0 and increments from there. The value -1 is an invalid ID.</p>
 */
public final class SDL_SensorID extends IntegerType {

    /**
     * Create a zero-valued signed IntegerType.
     */
    public SDL_SensorID() {
        this(0L);
    }

    /**
     * Create a signed IntegerType with the given value.
     */
    public SDL_SensorID(long value) {
        super(4, value, false);
    }
}
