package io.github.libsdl4j.api.vulkan;

import java.util.Arrays;
import java.util.List;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

/**
 * Definitions from file SDL_vulkan.h
 *
 * <p>Header file for functions to creating Vulkan surfaces on SDL windows.</p>
 */
public final class SdlVulkan {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlVulkan.class);
    }

    private SdlVulkan() {
    }

    /**
     * Dynamically load the Vulkan loader library.
     *
     * <p>This should be called after initializing the video driver, but before
     * creating any Vulkan windows. If no Vulkan loader library is loaded, the
     * default library will be loaded upon creation of the first Vulkan window.</p>
     *
     * <p>It is fairly common for Vulkan applications to link with libvulkan instead
     * of explicitly loading it at run time. This will work with SDL provided the
     * application links to a dynamic library and both it and SDL use the same
     * search path.</p>
     *
     * <p>If you specify a non-null {@code path}, an application should retrieve all of the
     * Vulkan functions it uses from the dynamic library using
     * SDL_Vulkan_GetVkGetInstanceProcAddr unless you can guarantee {@code path} points
     * to the same vulkan loader library the application linked to.</p>
     *
     * <p>On Apple devices, if {@code path} is null, SDL will attempt to find the
     * {@code vkGetInstanceProcAddr} address within all the Mach-O images of the current
     * process. This is because it is fairly common for Vulkan applications to
     * link with libvulkan (and historically MoltenVK was provided as a static
     * library). If it is not found, on macOS, SDL will attempt to load
     * {@code vulkan.framework/vulkan}, {@code libvulkan.1.dylib},
     * {@code MoltenVK.framework/MoltenVK}, and {@code libMoltenVK.dylib}, in that order. On
     * iOS, SDL will attempt to load {@code libMoltenVK.dylib}. Applications using a
     * dynamic framework or .dylib must ensure it is included in its application
     * bundle.</p>
     *
     * <p>On non-Apple devices, application linking with a static libvulkan is not
     * supported. Either do not link to the Vulkan loader or link to a dynamic
     * library version.</p>
     *
     * @param path The platform dependent Vulkan loader library name or null
     * @return 0 on success or -1 if the library couldn't be loaded; call
     * SDL_GetError() for more information.
     * @see #SDL_Vulkan_GetVkGetInstanceProcAddr()
     * @see #SDL_Vulkan_UnloadLibrary()
     * @since This function is available since SDL 2.0.6.
     */
    public static native int SDL_Vulkan_LoadLibrary(
            String path);

    /**
     * Get the address of the {@code vkGetInstanceProcAddr} function.
     *
     * <p>This should be called after either calling SDL_Vulkan_LoadLibrary() or
     * creating an SDL_Window with the {@code SDL_WINDOW_VULKAN} flag.</p>
     *
     * @return the function pointer for {@code vkGetInstanceProcAddr} or null on error.
     * @since This function is available since SDL 2.0.6.
     */
    public static native Pointer SDL_Vulkan_GetVkGetInstanceProcAddr();

    /**
     * Unload the Vulkan library previously loaded by SDL_Vulkan_LoadLibrary()
     *
     * @see #SDL_Vulkan_LoadLibrary(String)
     * @since This function is available since SDL 2.0.6.
     */
    public static native void SDL_Vulkan_UnloadLibrary();

    /**
     * Get the names of the Vulkan instance extensions needed to create a surface
     * with SDL_Vulkan_CreateSurface.
     *
     * <p>The {@code window} parameter is currently needed to be valid as of SDL 2.0.8,
     * however, this parameter will likely be removed in future releases</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param window A window for which the required Vulkan instance extensions
     *               should be retrieved (will be deprecated in a future release)
     * @return the list of extension names (strings)
     * @see #SDL_Vulkan_CreateSurface(SDL_Window, Pointer, PointerByReference)
     * @since This function is available since SDL 2.0.6.
     */
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
     * Get the names of the Vulkan instance extensions needed to create a surface
     * with SDL_Vulkan_CreateSurface.
     *
     * <p>If {@code pNames} is null, then the number of required Vulkan instance extensions
     * is returned in {@code pCount}. Otherwise, {@code pCount} must point to a variable set
     * to the number of elements in the {@code pNames} array, and on return the variable
     * is overwritten with the number of names actually written to {@code pNames}. If
     * {@code pCount} is less than the number of required extensions, at most {@code pCount}
     * structures will be written. If {@code pCount} is smaller than the number of
     * required extensions, false will be returned instead of true, to
     * indicate that not all the required extensions were returned.</p>
     *
     * <p>The {@code window} parameter is currently needed to be valid as of SDL 2.0.8,
     * however, this parameter will likely be removed in future releases</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_Vulkan_GetInstanceExtensions(SDL_Window)}.</p>
     *
     * @param window A window for which the required Vulkan instance extensions
     *               should be retrieved (will be deprecated in a future release)
     * @param pCount A pointer to an unsigned int corresponding to the number of
     *               extensions to be returned
     * @param pNames null or a pointer to an array to be filled with required
     *               Vulkan instance extensions
     * @return true on success, false on error.
     * @see #SDL_Vulkan_CreateSurface(SDL_Window, Pointer, PointerByReference)
     * @since This function is available since SDL 2.0.6.
     */
    public static native boolean SDL_Vulkan_GetInstanceExtensions(
            SDL_Window window,
            IntByReference pCount,
            StringArray pNames);

    /**
     * Create a Vulkan rendering surface for a window.
     *
     * <p>The {@code window} must have been created with the {@code SDL_WINDOW_VULKAN} flag and
     * {@code instance} must have been created with extensions returned by
     * SDL_Vulkan_GetInstanceExtensions() enabled.</p>
     *
     * @param window   The window to which to attach the Vulkan surface
     * @param instance The Vulkan instance handle
     * @param surface  A pointer to a VkSurfaceKHR handle to output the newly
     *                 created surface
     * @return true on success, false on error.
     * @see #SDL_Vulkan_GetInstanceExtensions(SDL_Window)
     * @see #SDL_Vulkan_GetDrawableSize(SDL_Window, IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.6.
     */
    public static native boolean SDL_Vulkan_CreateSurface(
            SDL_Window window,
            Pointer instance,
            PointerByReference surface);

    /**
     * Get the size of the window's underlying drawable dimensions in pixels.
     *
     * <p>This may differ from SDL_GetWindowSize() if we're rendering to a high-DPI
     * drawable, i.e. the window was created with {@code SDL_WINDOW_ALLOW_HIGHDPI} on a
     * platform with high-DPI support (Apple calls this "Retina"), and not
     * disabled by the {@code SDL_HINT_VIDEO_HIGHDPI_DISABLED} hint.</p>
     *
     * @param window an SDL_Window for which the size is to be queried
     * @param w      Pointer to the variable to write the width to or null
     * @param h      Pointer to the variable to write the height to or null
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_GetWindowSize(SDL_Window, IntByReference, IntByReference)
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_CreateWindow(String, int, int, int, int, int)
     * @see #SDL_Vulkan_CreateSurface(SDL_Window, Pointer, PointerByReference)
     * @since This function is available since SDL 2.0.6.
     */
    public static native void SDL_Vulkan_GetDrawableSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);
}
