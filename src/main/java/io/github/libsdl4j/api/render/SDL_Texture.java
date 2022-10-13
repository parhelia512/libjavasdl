package io.github.libsdl4j.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import io.github.libsdl4j.api.surface.SDL_Surface;

/**
 * An efficient driver-specific representation of pixel data.
 *
 * <p>{@code SDL_Texture} is used in a <b>hardware rendering</b> and textures are stored in GPU memory (where available).
 * Therefore the program doesn't have access to it directly, unlike in {@link SDL_Surface SDL_Surface}.
 * The rendering operations are accelerated by GPU (where available), using, internally, either OpenGL or
 * DirectX (available only on Windows) API, which in turn are using your video hardware, hence the <b>hardware rendering</b>.</p>
 *
 * <p>{@link SDL_Surface}, on the other hand, stores pixel data in the regular RAM
 * and in most cases you can access data buffer associated with surface directly,
 * modifying its content, i.e. it is using CPU, hence the <b>software rendering</b>.</p>
 *
 * <p>{@code SDL_Surface} is the original image data structure from SDL 1.x.
 * {@code SDL_Texture} was added in SDL 2.x for hardware optimized rendering.</p>
 *
 * <p>You can convert {@code SDL_Surface} to {@code SDL_Texture} using
 * {@link SdlRender#SDL_CreateTextureFromSurface(SDL_Renderer, SDL_Surface) SDL_CreateTextureFromSurface(...)},
 * after which you can release the SDL_Surface memory by
 * {@link io.github.libsdl4j.api.surface.SdlSurface#SDL_FreeSurface(SDL_Surface) SDL_FreeSurface(...)}</p>
 */
public final class SDL_Texture extends PointerType {

    public SDL_Texture() {
    }

    public SDL_Texture(Pointer p) {
        super(p);
    }
}
