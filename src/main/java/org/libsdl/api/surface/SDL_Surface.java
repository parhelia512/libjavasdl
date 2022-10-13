package org.libsdl.api.surface;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.pixels.SDL_PixelFormat;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.api.render.SDL_Renderer;
import org.libsdl.api.render.SDL_Texture;

/**
 * {@code SDL_Surface} is a structure holding a collection of pixels used in <b>software rendering</b> (also called blitting).
 *
 * <p>The pixel data are stored in the regular RAM as opposed to SDL_Texture, which can store data in GPU memory.
 * Thus, in most cases you can access data buffer associated with surface directly,
 * modifying its content, i.e. it is using CPU, hence the <b>software rendering</b>.</p>
 *
 * <p>{@link SDL_Texture SDL_Texture} on the other hand, is used in a <b>hardware rendering</b>,
 * textures are stored in GPU memory and you don't have access to it directly, unlike in {@code SDL_Surface}.
 * The rendering operations are accelerated by GPU, using, internally, either OpenGL or DirectX (available only on Windows) API,
 * which in turn are using the video hardware, hence the <b>hardware rendering</b>.</p>
 *
 * <p>{@code SDL_Surface} is the original image data structure from SDL 1.x.
 * {@code SDL_Texture} was added in SDL 2.x for hardware optimized rendering.</p>
 *
 * <p>You can convert {@code SDL_Surface} to {@code SDL_Texture} using
 * {@link org.libsdl.api.render.SdlRender#SDL_CreateTextureFromSurface(SDL_Renderer, SDL_Surface) SDL_CreateTextureFromSurface(...)},
 * after which you can release the SDL_Surface memory by
 * {@link org.libsdl.api.surface.SdlSurface#SDL_FreeSurface(SDL_Surface) SDL_FreeSurface(...)}</p>
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
        "listBlitmap",
        "clipRect",
        "map",
        "refcount"
})
public final class SDL_Surface extends Structure {

    /** Read-only */
    @MagicConstant(flagsFromClass = SDL_SurfaceFlags.class)
    public int flags;

    /** Read-only */
    public SDL_PixelFormat format;

    /** Read-only */
    public int w;

    /** Read-only */
    public int h;

    /** Read-only */
    public int pitch;

    /** Read-write */
    public Pointer pixels;

    /**
     * Application data associated with the surface
     *
     * <p>Read-write</p>
     */
    public Pointer userdata;

    /**
     * Information needed for surfaces requiring locks
     *
     * <p>Read-only</p>
     */
    public int locked;

    /**
     * List of BlitMap that hold a reference to this surface
     *
     * <p>Private</p>
     */
    public Pointer listBlitmap;

    /**
     * Clipping information
     *
     * <p>Read-only</p>
     */
    public SDL_Rect clipRect;

    /**
     * Info for fast blit mapping to other surfaces
     *
     * <p>Private</p>
     */
    public Pointer map;

    /**
     * Reference count -- used when freeing surface
     *
     * <p>Read-mostly</p>
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

        public Ref(Pointer p) {
            super(p);
        }

        public SDL_Surface getSurface() {
            SDL_Surface surface = new SDL_Surface(getValue());
            surface.read();
            return surface;
        }
    }
}
