package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_SENSORUPDATE;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "data"
})
public final class SDL_SensorEvent extends JnaStructure {

    @MagicConstant(intValues = SDL_SENSORUPDATE)
    public int type;
    public int timestamp;
    public int which;           // TODO: Shouldn't it be SDL_SensorID?
    public float[] data = new float[6];

    public SDL_SensorEvent() {
    }

    public SDL_SensorEvent(Pointer p) {
        super(p);
    }
}
