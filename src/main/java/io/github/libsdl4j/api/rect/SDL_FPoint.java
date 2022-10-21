package io.github.libsdl4j.api.rect;

import java.util.List;
import com.sun.jna.Pointer;

/**
 * The structure that defines a point (floating point)
 *
 * @see SdlRect#SDL_EncloseFPoints(List, SDL_FRect, SDL_FRect)
 * @see SdlRect#SDL_PointInFRect(SDL_FPoint, SDL_FRect)
 */
public final class SDL_FPoint {

    public float x;
    public float y;

    public SDL_FPoint() {
    }

    public SDL_FPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public SDL_FPoint(Pointer p) {
        x = p.getFloat(0L);
        y = p.getFloat(4L);
    }

    public long size() {
        return 8L;
    }

    public void write(Pointer p, long offset) {
        p.setFloat(0L, x);
        p.setFloat(4L, y);
    }
}
