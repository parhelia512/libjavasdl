package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.api.sensor.SDL_SensorType;

import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERSENSORUPDATE;

/**
 * Game controller sensor event structure (event.csensor.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "sensor",
        "data"
})
public final class SDL_ControllerSensorEvent extends Structure {

    /** {@link org.libsdl.api.event.SDL_EventType#SDL_CONTROLLERSENSORUPDATE SDL_CONTROLLERSENSORUPDATE} */
    @MagicConstant(intValues = SDL_CONTROLLERSENSORUPDATE)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The type of the sensor, one of the values of {@link SDL_SensorType} */
    @MagicConstant(valuesFromClass = SDL_SensorType.class)
    public int sensor;

    /** Up to 3 values from the sensor, as defined in SDL_sensor.h */
    public float[] data = new float[3];

    public SDL_ControllerSensorEvent() {
    }

    public SDL_ControllerSensorEvent(Pointer p) {
        super(p);
    }
}
