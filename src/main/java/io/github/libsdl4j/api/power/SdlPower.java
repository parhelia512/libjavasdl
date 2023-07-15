package io.github.libsdl4j.api.power;

import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_power.h
 *
 * <p>Header for the SDL power management routines.</p>
 */
public final class SdlPower {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlPower.class);
    }

    private SdlPower() {
    }

    /**
     * Get the current power supply details.
     *
     * <p>You should never take a battery status as absolute truth. Batteries
     * (especially failing batteries) are delicate hardware, and the values
     * reported here are best estimates based on what that hardware reports. It's
     * not uncommon for older batteries to lose stored power much faster than it
     * reports, or completely drain when reporting it has 20 percent left, etc.</p>
     *
     * <p>Battery status can change at any time; if you are concerned with power
     * state, you should call this function frequently, and perhaps ignore changes
     * until they seem to be stable for a few seconds.</p>
     *
     * <p>It's possible a platform can only report battery percentage or time left
     * but not both.</p>
     *
     * @param seconds seconds of battery life left, you can pass a null here if
     *                you don't care, will return -1 if we can't determine a
     *                value, or we're not running on a battery
     * @param percent percentage of battery life left, between 0 and 100, you can
     *                pass a null here if you don't care, will return -1 if we
     *                can't determine a value, or we're not running on a battery
     * @return an SDL_PowerState enum representing the current battery state.
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_PowerState.class)
    public static native int SDL_GetPowerInfo(
            IntByReference seconds,
            IntByReference percent);
}
