package org.libsdl.api.power;

import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

public final class SdlPower {

    static {
        NativeLoader.registerNativeMethods(SdlPower.class);
    }

    private SdlPower() {
    }

    @MagicConstant(valuesFromClass = SDL_PowerState.class)
    public static native int SDL_GetPowerInfo(IntByReference secs, IntByReference pct);
}
