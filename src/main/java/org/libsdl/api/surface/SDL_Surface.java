package org.libsdl.api.surface;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import org.libsdl.api.pixels.SDL_PixelFormat;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.api.video.SDL_Window;
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
        "lockData",
        "clipRect",
        "map",
        "refcount"
})
public class SDL_Surface extends JnaStructure {

    public int flags;
    public SDL_PixelFormat.ByReference format;
    public int w;
    public int h;
    public int pitch;
    public Pointer pixels;

    /**
     * Application data associated with the surface
     */
    public Pointer userdata;

    /**
     * information needed for surfaces requiring locks
     */
    public int locked;

    /**
     * list of BlitMap that hold a reference to this surface
     */
    public Pointer lockData;

    /**
     * clipping information
     */
    public SDL_Rect clipRect;

    /**
     * info for fast blit mapping to other surfaces
     */
    public Pointer map;

    /**
     * Reference count -- used when freeing surface
     */
    public int refcount;

    public SDL_Surface() {
    }

    public SDL_Surface(Pointer p) {
        super(p);
    }

    public static final class Ref extends PointerByReference {

        public Ref() {
        }

        public Ref(Pointer value) {
            super(value);
        }

        public SDL_Surface getSurface() {
            return new SDL_Surface(getPointer());
        }
    }
}
