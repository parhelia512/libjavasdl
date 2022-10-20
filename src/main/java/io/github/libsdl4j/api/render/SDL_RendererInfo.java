package io.github.libsdl4j.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.pixels.SDL_PixelFormatEnum;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Information on the capabilities of a render driver or context.
 */
@Structure.FieldOrder({
        "name",
        "flags",
        "numTextureFormats",
        "textureFormats",
        "maxTextureWidth",
        "maxTextureHeight"
})
public final class SDL_RendererInfo extends Structure {

    /** The name of the renderer */
    public String name;

    /** Supported {@link SDL_RendererFlags} */
    @MagicConstant(flagsFromClass = SDL_RendererFlags.class)
    public int flags;

    /** The number of available texture formats */
    public int numTextureFormats;

    /** The available texture formats */
    @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class)
    public int[] textureFormats = new int[16];

    /** The maximum texture width */
    public int maxTextureWidth;

    /** The maximum texture height */
    public int maxTextureHeight;

    public SDL_RendererInfo() {
    }

    public SDL_RendererInfo(Pointer p) {
        super(p);
    }
}
