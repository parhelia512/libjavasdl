package org.libsdl.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.pixels.SDL_PixelFormatEnum;

@Structure.FieldOrder({
        "name",
        "flags",
        "numTextureFormats",
        "textureFormats",
        "maxTextureWidth",
        "maxTextureHeight"
})
public final class SDL_RendererInfo extends Structure {

    public String name;

    @MagicConstant(flagsFromClass = SDL_RendererFlags.class)
    public int flags;

    public int numTextureFormats;

    @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class)
    public int[] textureFormats = new int[16];

    public int maxTextureWidth;

    public int maxTextureHeight;

    public SDL_RendererInfo() {
    }

    public SDL_RendererInfo(Pointer p) {
        super(p);
    }
}
