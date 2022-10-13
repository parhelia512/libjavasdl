package io.github.libsdl4j.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.jna.ContiguousArrayList;

/**
 * The structure that defines a point (integer)
 *
 * @see SdlRect#SDL_EnclosePoints(ContiguousArrayList, SDL_Rect, SDL_Rect)
 * @see SdlRect#SDL_PointInRect(SDL_Point, SDL_Rect)
 */
@Structure.FieldOrder({
        "x",
        "y"
})
public final class SDL_Point extends Structure {

    public int x;
    public int y;

    public SDL_Point() {
    }

    public SDL_Point(Pointer p) {
        super(p);
    }
}
