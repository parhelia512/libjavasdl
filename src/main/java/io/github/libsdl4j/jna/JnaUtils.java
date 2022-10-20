package io.github.libsdl4j.jna;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_free;

public final class JnaUtils {

    public static String extractStringAndReleaseNativeSdlMemory(Pointer pointer) {
        String result = pointer.getString(0L);
        SDL_free(pointer);
        return result;
    }

    public static Memory writeArrayToNativeMemory(byte[] data) {
        if (data == null) {
            return null;
        }
        Memory memory = new Memory(data.length);
        memory.write(0L, data, 0, data.length);
        return memory;
    }

    public static Memory writeArrayToNativeMemory(short[] data) {
        if (data == null) {
            return null;
        }
        Memory memory = new Memory(data.length * 2L);
        memory.write(0L, data, 0, data.length);
        return memory;
    }

    public static void append(StringBuilder result, String name) {
        if (result.length() > 0) {
            result.append(" | ");
        }
        result.append(name);
    }

    public static String flagsUnknown(int value) {
        return "UNKNOWN(" + Integer.toBinaryString(value) + ")";
    }
}