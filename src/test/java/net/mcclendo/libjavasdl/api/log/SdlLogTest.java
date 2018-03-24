package net.mcclendo.libjavasdl.api.log;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;

import com.sun.jna.Pointer;

public final class SdlLogTest {

    @Test
    public void priority() {
        Sdl.SDL_Init(0);

        Assert.assertEquals(SdlLog.SDL_LOG_PRIORITY_INFO, SdlLog.SDL_LogGetPriority(SdlLog.SDL_LOG_CATEGORY_APPLICATION));
        SdlLog.SDL_LogSetPriority(
                SdlLog.SDL_LOG_CATEGORY_APPLICATION,
                SdlLog.SDL_LOG_PRIORITY_DEBUG);
        Assert.assertEquals(SdlLog.SDL_LOG_PRIORITY_DEBUG, SdlLog.SDL_LogGetPriority(SdlLog.SDL_LOG_CATEGORY_APPLICATION));
        SdlLog.SDL_LogSetAllPriority(
                SdlLog.SDL_LOG_PRIORITY_CRITICAL);
        Assert.assertEquals(SdlLog.SDL_LOG_PRIORITY_CRITICAL, SdlLog.SDL_LogGetPriority(SdlLog.SDL_LOG_CATEGORY_APPLICATION));
        SdlLog.SDL_LogResetPriorities();
        Assert.assertEquals(SdlLog.SDL_LOG_PRIORITY_INFO, SdlLog.SDL_LogGetPriority(SdlLog.SDL_LOG_CATEGORY_APPLICATION));

        Sdl.SDL_Quit();
    }

    @Test
    public void log() {
        Sdl.SDL_Init(0);

        final String fmtString = UUID.randomUUID().toString() + " %s";

        SdlLog.SDL_Log(
                fmtString,
                UUID.randomUUID().toString());

        SdlLog.SDL_LogVerbose(
                SdlLog.SDL_LOG_CATEGORY_APPLICATION,
                fmtString,
                UUID.randomUUID().toString());

        SdlLog.SDL_LogDebug(
                SdlLog.SDL_LOG_CATEGORY_APPLICATION,
                fmtString,
                UUID.randomUUID().toString());

        SdlLog.SDL_LogInfo(
                SdlLog.SDL_LOG_CATEGORY_APPLICATION,
                fmtString,
                UUID.randomUUID().toString());

        SdlLog.SDL_LogWarn(
                SdlLog.SDL_LOG_CATEGORY_APPLICATION,
                fmtString,
                UUID.randomUUID().toString());

        SdlLog.SDL_LogError(
                SdlLog.SDL_LOG_CATEGORY_APPLICATION,
                fmtString,
                UUID.randomUUID().toString());

        SdlLog.SDL_LogCritical(
                SdlLog.SDL_LOG_CATEGORY_APPLICATION,
                fmtString,
                UUID.randomUUID().toString());

        SdlLog.SDL_LogMessage(
                SdlLog.SDL_LOG_CATEGORY_APPLICATION,
                SdlLog.SDL_LOG_PRIORITY_CRITICAL,
                fmtString,
                UUID.randomUUID().toString());

        SdlLog.SDL_LogMessage(
                SdlLog.SDL_LOG_CATEGORY_APPLICATION,
                SdlLog.SDL_LOG_PRIORITY_CRITICAL,
                UUID.randomUUID().toString(),
                Pointer.NULL);

        Sdl.SDL_Quit();
    }
}
