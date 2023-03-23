package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_SENSORUPDATE;

/**
 * Sensor event structure (event.sensor.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "data",
        "timestampUs"
})
public final class SDL_SensorEvent extends Structure {

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_SENSORUPDATE SDL_SENSORUPDATE} */
    @MagicConstant(intValues = SDL_SENSORUPDATE)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    // TODO: Shouldn't it be SDL_SensorID?
    /** The instance ID of the sensor */
    public int which;

    /** Up to 6 values from the sensor - additional values can be queried using SDL_SensorGetData() */
    public float[] data = new float[6];

    /** The timestamp of the sensor reading in microseconds, if the hardware provides this information. */
    public long timestampUs;

    public SDL_SensorEvent() {
    }

    public SDL_SensorEvent(Pointer p) {
        super(p);
    }
}
