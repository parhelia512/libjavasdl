package org.libsdl.api.version;

import org.junit.jupiter.api.Test;

public final class SdlVersionTest {

    @Test
    public void control() {
        final SDL_version version = new SDL_version();
        SdlVersion.SDL_GetVersion(version);
    }
}
