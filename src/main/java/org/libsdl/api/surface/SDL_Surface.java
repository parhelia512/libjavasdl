package org.libsdl.api.surface;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.pixels.SDL_PixelFormat;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.jna.JnaStructure;

/**
 * <p>A collection of pixels used in software blitting.</p>
 *
 * @apiNote This structure should be treated as read-only, except for {@code pixels},
 * which, if not null, contains the raw pixel data for the surface.
 */
@Structure.FieldOrder({
        "flags",
        "format",
        "w",
        "h",
        "pitch",
        "pixels",
        "userdata",
        "locked",
        "list_blitmap",
        "clip_rect",
        "map",
        "refcount"
})
public class SDL_Surface extends JnaStructure {

    @MagicConstant(flagsFromClass = SDL_SurfaceFlags.class)
    public int flags;
    public SDL_PixelFormat format;
    public int w;
    public int h;
    public int pitch;
    public Pointer pixels;

    /** Application data associated with the surface */
    public Pointer userdata;

    /** information needed for surfaces requiring locks */
    public int locked;

    /** list of BlitMap that hold a reference to this surface */
    public Pointer list_blitmap;

    /** clipping information */
    public SDL_Rect clip_rect;

    /** info for fast blit mapping to other surfaces */
    public Pointer map;

    /** Reference count -- used when freeing surface */
    public int refcount;

    public SDL_Surface() {
    }

    public SDL_Surface(Pointer p) {
        super(p);
    }

    public static class Ref extends SDL_Surface implements Structure.ByReference {

        public Ref() {
        }

        public Ref(Pointer p) {
            super(p);
        }
    }
}
