package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.jna.ContiguousArrayList;

/**
 * The structure that defines a point (floating point)
 *
 * @see SdlRect#SDL_EncloseFPoints(ContiguousArrayList, SDL_FRect, SDL_FRect)
 * @see SdlRect#SDL_PointInFRect(SDL_FPoint, SDL_FRect)
 */
@Structure.FieldOrder({
        "x",
        "y"
})
public final class SDL_FPoint extends Structure {

    public float x;
    public float y;

    public SDL_FPoint() {
    }

    public SDL_FPoint(Pointer p) {
        super(p);
    }
}
