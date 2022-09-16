package org.libsdl.api.vulkan;

import java.util.Arrays;
import java.util.List;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.NativeLoader;

public final class SdlVulkan {

    static {
        NativeLoader.registerNativeMethods(SdlVulkan.class);
    }

    public static native int SDL_Vulkan_LoadLibrary(
            String path);

    public static native Pointer SDL_Vulkan_GetVkGetInstanceProcAddr();

    public static native void SDL_Vulkan_UnloadLibrary();

    public static List<String> SDL_Vulkan_GetInstanceExtensions(
            SDL_Window window) {
        IntByReference requiredStringArrayLength = new IntByReference(0);
        if (!SDL_Vulkan_GetInstanceExtensions(window, requiredStringArrayLength, null)) {
            return null;
        }

        String[] extensions = new String[requiredStringArrayLength.getValue()];
        StringArray stringArray = new StringArray(extensions);
        if (!SDL_Vulkan_GetInstanceExtensions(window, requiredStringArrayLength, stringArray)) {
            return null;
        }
        stringArray.read();
        return Arrays.asList(extensions);
    }

    /**
     * @deprecated Use more Java-style version: {@link #SDL_Vulkan_GetInstanceExtensions(SDL_Window)}
     */
    public static native boolean SDL_Vulkan_GetInstanceExtensions(
            SDL_Window window,
            IntByReference pCount,
            StringArray pNames);

    public static native boolean SDL_Vulkan_CreateSurface(
            SDL_Window window,
            Pointer instance,
            PointerByReference surface);

    public static native void SDL_Vulkan_GetDrawableSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);
}
