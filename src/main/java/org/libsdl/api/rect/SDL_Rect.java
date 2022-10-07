package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import org.libsdl.jna.ContiguousArrayList;

/**
 * A rectangle, with the origin at the upper left (integer).
 *
 * @see SdlRect#SDL_RectEmpty(SDL_Rect)
 * @see SdlRect#SDL_RectEquals(SDL_Rect, SDL_Rect)
 * @see SdlRect#SDL_HasIntersection(SDL_Rect, SDL_Rect)
 * @see SdlRect#SDL_IntersectRect(SDL_Rect, SDL_Rect, SDL_Rect)
 * @see SdlRect#SDL_IntersectRectAndLine(SDL_Rect, IntByReference, IntByReference, IntByReference, IntByReference)
 * @see SdlRect#SDL_UnionRect(SDL_Rect, SDL_Rect, SDL_Rect)
 * @see SdlRect#SDL_EnclosePoints(ContiguousArrayList, SDL_Rect, SDL_Rect)
 */
@Structure.FieldOrder({
        "x",
        "y",
        "w",
        "h"
})
public final class SDL_Rect extends Structure {

    public int x;
    public int y;
    public int w;
    public int h;

    public SDL_Rect() {
    }

    public SDL_Rect(Pointer p) {
        super(p);
    }
}
