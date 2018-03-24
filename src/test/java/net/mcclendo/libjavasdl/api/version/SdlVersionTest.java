package net.mcclendo.libjavasdl.api.version;

import org.junit.Assert;
import org.junit.Test;

import net.mcclendo.libjavasdl.api.log.SDL_version;

public final class SdlVersionTest {

    @Test
    public void version() {
        final SDL_version version = new SDL_version();
        SdlVersion.SDL_GetVersion(version);

        Assert.assertEquals(
                version.major,
                SdlVersion.SDL_VERSION().major);

        Assert.assertEquals(
                version.minor,
                SdlVersion.SDL_VERSION().minor);

        Assert.assertEquals(
                version.patch,
                SdlVersion.SDL_VERSION().patch);

        Assert.assertTrue(SdlVersion.SDL_VERSION_ATLEAST(1, 0, 0));

        SdlVersion.SDL_GetRevision();
        SdlVersion.SDL_GetRevisionNumber();
    }
}
