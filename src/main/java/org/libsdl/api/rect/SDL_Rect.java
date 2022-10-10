package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import org.libsdl.jna.ContiguousArrayList;

/**
 * {@code SDL_Rect} is a simple structure that contains only four int values:
 * {@code x}, {@code y} which hold the position and {@code w}, {@code h} which hold width and height.
 *
 * <p>It's important to note that 0, 0 is the upper-left corner.
 * So a higher y-value means lower, and the bottom-right corner will have the coordinate x + w, y + h.</p>
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
