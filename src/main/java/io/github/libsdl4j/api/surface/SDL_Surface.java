package io.github.libsdl4j.api.surface;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.api.pixels.SDL_PixelFormat;
import io.github.libsdl4j.api.rect.SDL_Rect;
import io.github.libsdl4j.api.render.SDL_Renderer;
import io.github.libsdl4j.api.render.SDL_Texture;

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
 * {@link io.github.libsdl4j.api.render.SdlRender#SDL_CreateTextureFromSurface(SDL_Renderer, SDL_Surface) SDL_CreateTextureFromSurface(...)},
 * after which you can release the {@code SDL_Surface} memory by
 * {@link io.github.libsdl4j.api.surface.SdlSurface#SDL_FreeSurface(SDL_Surface) SDL_FreeSurface(...)}</p>
 *
 * <p><b>Note:</b>This structure should be treated as read-only, except for {@code pixels},
 * which, if not null, contains the raw pixel data for the surface.</p>
 *
 * <p><b>Implementation note:</b> {@code SDL_Surface} would normally be implemented as a JNA {@link Structure}
 * but the SDL internals keep references to all allocated {@code SDL_Surface}s
 * and change their internal fields without notice. Thus it is implemented as
 * an opaque Pointer and there is a co-located {@link SDL_Surface_internal}
 * which allows a read-only access to the fields.</p>
 */
public final class SDL_Surface extends PointerType {

    private SDL_Surface_internal semanticStruct;

    public SDL_Surface() {
        super();
    }

    public SDL_Surface(Pointer p) {
        super(p);
    }

    public int getFlags() {
        return (Integer) readField("flags");
    }

    public SDL_PixelFormat getFormat() {
        return (SDL_PixelFormat) readField("format");
    }

    public int getW() {
        return (Integer) readField("w");
    }

    public int getH() {
        return (Integer) readField("h");
    }

    public int getPitch() {
        return (Integer) readField("pitch");
    }

    public Pointer getPixels() {
        return (Pointer) readField("pixels");
    }

    /**
     * Read the application data associated with the surface
     */
    public Pointer getUserdata() {
        return (Pointer) readField("userdata");
    }

    /**
     * Set the application data associated with the surface
     */
    public void setUserdata(Pointer newValue) {
        writeField("userdata", newValue);
    }

    public int getLocked() {
        return (Integer) readField("locked");
    }

    /**
     * Get the clipping information
     */
    public SDL_Rect getClipRect() {
        return (SDL_Rect) readField("clipRect");
    }

    /**
     * Get the reference count -- used when freeing surface
     */
    public int getRefcount() {
        return (Integer) readField("refcount");
    }

    private Object readField(String name) {
        if (semanticStruct == null) {
            semanticStruct = new SDL_Surface_internal(getPointer());
        }
        return semanticStruct.readField(name);
    }

    private void writeField(String name, Object newValue) {
        if (semanticStruct == null) {
            semanticStruct = new SDL_Surface_internal(getPointer());
        }
        semanticStruct.writeField(name, newValue);
    }

    public static final class Ref extends PointerByReference {

        public Ref() {
        }

        public Ref(Pointer p) {
            super(p);
        }

        public SDL_Surface getSurface() {
            return new SDL_Surface(getValue());
        }
    }
}
