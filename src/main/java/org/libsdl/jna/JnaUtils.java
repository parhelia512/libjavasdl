package org.libsdl.jna;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

import static org.libsdl.api.stdinc.SdlStdinc.SDL_free;

public class JnaUtils {

    public static String extractStringAndReleaseNativeSdlMemory(Pointer pointer) {
        String result = pointer.getString(0L);
        SDL_free(pointer);
        return result;
    }

    public static Memory writeArrayToNativeMemory(JnaStructure[] objects) {
        if (objects == null || objects.length == 0) {
            throw new IllegalArgumentException("Array of objects must not be empty or null.");
        }
        int size = objects[0].size();
        Memory memory = new Memory((long) objects.length * size);
        int offset = 0;
        for (JnaStructure singleObject : objects) {
            Pointer backup = singleObject.getPointer();
            singleObject.useMemory(memory, offset);
            singleObject.write();
            singleObject.useMemory(backup, 0);
            offset += size;
        }
        return memory;
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
