package io.github.libsdl4j.api.rect;

import java.util.List;
import com.sun.jna.Pointer;

/**
 * The structure that defines a point (integer)
 *
 * @see SdlRect#SDL_EnclosePoints(List, SDL_Rect, SDL_Rect)
 * @see SdlRect#SDL_PointInRect(SDL_Point, SDL_Rect)
 */
public final class SDL_Point {

    public int x;
    public int y;

    public SDL_Point() {
    }

    public SDL_Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public SDL_Point(Pointer p) {
        x = p.getInt(0L);
        y = p.getInt(4L);
    }

    public long size() {
        return 8L;
    }

    public void write(Pointer buffer, long offset) {
        buffer.setInt(offset, x);
        buffer.setInt(offset + 4L, y);
    }
}
