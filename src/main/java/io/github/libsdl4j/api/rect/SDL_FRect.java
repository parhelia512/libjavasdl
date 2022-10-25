package io.github.libsdl4j.api.rect;

import java.util.List;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.jna.FloatRef;

/**
 * {@code SDL_FRect} is a simple structure that contains only four floating values:
 * {@code x}, {@code y} which hold the position and {@code w}, {@code h} which hold width and height.
 *
 * @see SdlRect#SDL_FRectEmpty(SDL_FRect)
 * @see SdlRect#SDL_FRectEquals(SDL_FRect, SDL_FRect)
 * @see SdlRect#SDL_FRectEqualsEpsilon(SDL_FRect, SDL_FRect, float)
 * @see SdlRect#SDL_HasIntersectionF(SDL_FRect, SDL_FRect)
 * @see SdlRect#SDL_IntersectFRect(SDL_FRect, SDL_FRect, SDL_FRect)
 * @see SdlRect#SDL_IntersectFRectAndLine(SDL_FRect, FloatRef, FloatRef, FloatRef, FloatRef)
 * @see SdlRect#SDL_UnionFRect(SDL_FRect, SDL_FRect, SDL_FRect)
 * @see SdlRect#SDL_EncloseFPoints(List, SDL_FRect, SDL_FRect)
 * @see SdlRect#SDL_PointInFRect(SDL_FPoint, SDL_FRect)
 */
@Structure.FieldOrder({
        "x",
        "y",
        "w",
        "h"
})
public final class SDL_FRect extends Structure {

    public float x;
    public float y;
    public float w;
    public float h;

    public SDL_FRect() {
    }

    public SDL_FRect(Pointer p) {
        super(p);
    }
}
