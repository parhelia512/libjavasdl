package org.libsdl.jna;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

public final class NativeLoader {

    private NativeLoader() {
    }

    public static void registerNativeMethods(Class<?> nativeClass) {
        NativeLibrary lib = loadSdl2Library();
        Native.register(nativeClass, lib);
    }

    public static NativeLibrary loadSdl2Library() {
        return NativeLibrary.getInstance("sdl2", NativeLoader.class.getClassLoader());
    }
}
