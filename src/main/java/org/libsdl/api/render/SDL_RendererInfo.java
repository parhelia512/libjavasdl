package org.libsdl.api.pixels;

import com.sun.jna.Structure;

@SuppressWarnings("checkstyle:MagicNumber")
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
    public int flags;
    public int numTextureFormats;
    public int[] textureFormats = new int[16];
    public int maxTextureWidth;
    public int maxTextureHeight;
}
