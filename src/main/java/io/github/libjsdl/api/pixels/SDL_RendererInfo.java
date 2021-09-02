package io.github.libjsdl.api.pixels;

import io.github.libjsdl.jna.AbstractSdlStructure;

@SuppressWarnings("checkstyle:MagicNumber")
public final class SDL_RendererInfo extends AbstractSdlStructure {

    public String name;
    public int flags;
    public int numTextureFormats;
    public int[] textureFormats = new int[16];
    public int maxTextureWidth;
    public int maxTextureHeight;
}
