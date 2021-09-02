package io.github.libjsdl.api.version;

import org.junit.jupiter.api.Test;

import io.github.libjsdl.api.log.SDL_version;

public final class SdlVersionTest {

    @Test
    public void control() {
        final SDL_version version = new SDL_version();
        SdlVersion.SDL_GetVersion(version);
    }
}
