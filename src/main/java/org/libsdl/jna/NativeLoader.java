package org.libsdl.jna;

import java.util.HashMap;
import java.util.Map;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import static com.sun.jna.Library.OPTION_CLASSLOADER;
import static com.sun.jna.Library.OPTION_STRING_ENCODING;

public final class NativeLoader {

    private NativeLoader() {
    }

    public static void registerNativeMethods(Class<?> nativeClass) {
        NativeLibrary lib = loadSdl2Library();
        Native.register(nativeClass, lib);
    }

    public static NativeLibrary loadSdl2Library() {
        Map<String, Object> options = new HashMap<>();
        options.put(OPTION_STRING_ENCODING, "UTF-8");
        options.put(OPTION_CLASSLOADER, NativeLoader.class.getClassLoader());
        return NativeLibrary.getInstance("sdl2", options);
    }
}
