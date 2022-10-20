package io.github.libsdl4j.api.surface;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.pixels.SDL_PixelFormat;
import io.github.libsdl4j.api.rect.SDL_Rect;
import org.intellij.lang.annotations.MagicConstant;

/**
 * This is an internal {@link Structure} co-located with its parent Pointer-like {@link SDL_Surface}.
 * It is used for reading fields from the parent pointer.
 *
 * <p>Do not use it explicitly in your code.</p>
 *
 * <p><b>Implementation note:</b> No-arg constructor is intentionally omitted
 * as this structure will always be instantiated as part of an existing {@code SDL_Surface}.</p>
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
public final class SDL_Surface_internal extends Structure {

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

    public SDL_Surface_internal(Pointer p) {
        super(p);
    }
}
