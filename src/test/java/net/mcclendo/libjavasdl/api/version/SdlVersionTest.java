package net.mcclendo.libjavasdl.api.version;

import org.junit.Test;

import net.mcclendo.libjavasdl.api.log.SDL_version;

public final class SdlVersionTest {

    @Test
    public void control() {
        final SDL_version version = new SDL_version();
        SdlVersion.SDL_GetVersion(version);
    }
}
