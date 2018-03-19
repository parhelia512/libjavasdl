package net.mcclendo.libjavasdl.api.error;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public final class SdlErrorTest {

    @Test
    public void control() {
        final String testErrorString = UUID.randomUUID().toString();

        Assert.assertEquals(
                -1,
                SdlError.SDL_SetError(
                        "%s",
                        testErrorString));

        Assert.assertEquals(testErrorString, SdlError.SDL_GetError());

        SdlError.SDL_ClearError();

        Assert.assertEquals("", SdlError.SDL_GetError());
    }
}
