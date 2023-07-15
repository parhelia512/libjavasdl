package io.github.libsdl4j.api.video;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.api.pixels.SDL_PixelFormatEnum;
import io.github.libsdl4j.api.rect.SDL_Point;
import io.github.libsdl4j.api.rect.SDL_Rect;
import io.github.libsdl4j.api.surface.SDL_Surface;
import io.github.libsdl4j.jna.ContiguousArrayList;
import io.github.libsdl4j.jna.JnaUtils;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import io.github.libsdl4j.jna.size_t;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_free;
import static io.github.libsdl4j.api.video.SDL_WindowFlags.SDL_WINDOW_FULLSCREEN;
import static io.github.libsdl4j.api.video.SDL_WindowFlags.SDL_WINDOW_FULLSCREEN_DESKTOP;

/**
 * Definitions from file SDL_video.h
 *
 * <p>Header file for SDL video functions.</p>
 */
public final class SdlVideo {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlVideo.class);
    }

    private SdlVideo() {
    }

    /**
     * Get the number of video drivers compiled into SDL.
     *
     * @return a number greater or equal to 1 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetVideoDriver(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetNumVideoDrivers();

    /**
     * Get the name of a built in video driver.
     *
     * <p>The video drivers are presented in the order in which they are normally
     * checked during initialization.</p>
     *
     * @param index the index of a video driver
     * @return the name of the video driver with the given **index**.
     * @see #SDL_GetNumVideoDrivers()
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetVideoDriver(
            int index);

    /**
     * Initialize the video subsystem, optionally specifying a video driver.
     *
     * <p>This function initializes the video subsystem, setting up a connection to
     * the window manager, etc, and determines the available display modes and
     * pixel formats, but does not initialize a window or graphics mode.</p>
     *
     * <p>If you use this function and you haven't used the SDL_INIT_VIDEO flag with
     * either SDL_Init() or SDL_InitSubSystem(), you should call SDL_VideoQuit()
     * before calling SDL_Quit().</p>
     *
     * <p>It is safe to call this function multiple times. SDL_VideoInit() will call
     * SDL_VideoQuit() itself if the video subsystem has already been initialized.</p>
     *
     * <p>You can use SDL_GetNumVideoDrivers() and SDL_GetVideoDriver() to find a
     * specific {@code driver_name}.</p>
     *
     * @param driverName the name of a video driver to initialize, or null for
     *                   the default driver
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetNumVideoDrivers()
     * @see #SDL_GetVideoDriver(int)
     * @see io.github.libsdl4j.api.Sdl#SDL_InitSubSystem(int) SDL_InitSubSystem(int)
     * @see #SDL_VideoQuit()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_VideoInit(
            String driverName);

    /**
     * Shut down the video subsystem, if initialized with SDL_VideoInit().
     *
     * <p>This function closes all windows, and restores the original video mode.</p>
     *
     * @see #SDL_VideoInit(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_VideoQuit();

    /**
     * Get the name of the currently initialized video driver.
     *
     * @return the name of the current video driver or null if no driver has been
     * initialized.
     * @see #SDL_GetNumVideoDrivers()
     * @see #SDL_GetVideoDriver(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetCurrentVideoDriver();

    /**
     * Get the number of available video displays.
     *
     * @return a number greater or equal to 1 or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetDisplayBounds(int, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetNumVideoDisplays();

    /**
     * Get the name of a display in UTF-8 encoding.
     *
     * @param displayIndex the index of display from which the name should be
     *                     queried
     * @return the name of a display or null for an invalid display index or
     * failure; call SDL_GetError() for more information.
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetDisplayName(
            int displayIndex);

    /**
     * Get the desktop area represented by a display.
     *
     * <p>The primary display ({@code displayIndex} zero) is always located at 0,0.</p>
     *
     * @param displayIndex the index of the display to query
     * @param rect         the SDL_Rect structure filled in with the display bounds
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetDisplayBounds(
            int displayIndex,
            SDL_Rect rect);

    /**
     * Get the usable desktop area represented by a display.
     *
     * <p>The primary display ({@code displayIndex} zero) is always located at 0,0.</p>
     *
     * <p>This is the same area as SDL_GetDisplayBounds() reports, but with portions
     * reserved by the system removed. For example, on Apple's macOS, this
     * subtracts the area occupied by the menu bar and dock.</p>
     *
     * <p>Setting a window to be fullscreen generally bypasses these unusable areas,
     * so these are good guidelines for the maximum space available to a
     * non-fullscreen window.</p>
     *
     * <p>The parameter {@code rect} is ignored if it is null.</p>
     *
     * <p>This function also returns -1 if the parameter {@code displayIndex} is out of
     * range.</p>
     *
     * @param displayIndex the index of the display to query the usable bounds
     *                     from
     * @param rect         the SDL_Rect structure filled in with the display bounds
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetDisplayBounds(int, SDL_Rect)
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.0.5.
     */
    public static native int SDL_GetDisplayUsableBounds(
            int displayIndex,
            SDL_Rect rect);

    /**
     * Get the dots/pixels-per-inch for a display.
     *
     * <p>Diagonal, horizontal and vertical DPI can all be optionally returned if the
     * appropriate parameter is non-null.</p>
     *
     * <p>A failure of this function usually means that either no DPI information is
     * available or the {@code displayIndex} is out of range.</p>
     *
     * **WARNING**: This reports the DPI that the hardware reports, and it is not
     * always reliable! It is almost always better to use SDL_GetWindowSize() to
     * find the window size, which might be in logical points instead of pixels,
     * and then SDL_GL_GetDrawableSize(), SDL_Vulkan_GetDrawableSize(),
     * SDL_Metal_GetDrawableSize(), or SDL_GetRendererOutputSize(), and compare
     * the two values to get an actual scaling value between the two. We will be
     * rethinking how high-dpi details should be managed in SDL3 to make things
     * more consistent, reliable, and clear.
     *
     * @param displayIndex the index of the display from which DPI information
     *                     should be queried
     * @param ddpi         a pointer filled in with the diagonal DPI of the display; may
     *                     be null
     * @param hdpi         a pointer filled in with the horizontal DPI of the display; may
     *                     be null
     * @param vdpi         a pointer filled in with the vertical DPI of the display; may
     *                     be null
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.0.4.
     */
    public static native int SDL_GetDisplayDPI(
            int displayIndex,
            FloatByReference ddpi,
            FloatByReference hdpi,
            FloatByReference vdpi);

    /**
     * Get the orientation of a display.
     *
     * @param displayIndex the index of the display to query
     * @return The SDL_DisplayOrientation enum value of the display, or
     * {@code SDL_ORIENTATION_UNKNOWN} if it isn't available.
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.0.9.
     */
    @MagicConstant(valuesFromClass = SDL_DisplayOrientation.class)
    public static native int SDL_GetDisplayOrientation(
            int displayIndex);

    /**
     * Get the number of available display modes.
     *
     * <p>The {@code displayIndex} needs to be in the range from 0 to
     * SDL_GetNumVideoDisplays() - 1.</p>
     *
     * @param displayIndex the index of the display to query
     * @return a number greater or equal to 1 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetDisplayMode(int, int, SDL_DisplayMode)
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetNumDisplayModes(
            int displayIndex);

    /**
     * Get information about a specific display mode.
     *
     * <p>The display modes are sorted in this priority:</p>
     *
     * <ul>
     *     <li>width ... largest to smallest</li>
     *     <li>height ... largest to smallest</li>
     *     <li>bits per pixel ... more colors to fewer colors</li>
     *     <li>packed pixel layout ... largest to smallest</li>
     *     <li>refresh rate ... highest to lowest</li>
     * </ul>
     *
     * @param displayIndex the index of the display to query
     * @param modeIndex    the index of the display mode to query
     * @param mode         an SDL_DisplayMode structure filled in with the mode at
     *                     {@code modeIndex}
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetNumDisplayModes(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetDisplayMode(
            int displayIndex,
            int modeIndex,
            SDL_DisplayMode mode);

    /**
     * Get information about the desktop's display mode.
     *
     * <p>There's a difference between this function and SDL_GetCurrentDisplayMode()
     * when SDL runs fullscreen and has changed the resolution. In that case this
     * function will return the previous native display mode, and not the current
     * display mode.</p>
     *
     * @param displayIndex the index of the display to query
     * @param mode         an SDL_DisplayMode structure filled in with the current display
     *                     mode
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetCurrentDisplayMode(int, SDL_DisplayMode)
     * @see #SDL_GetDisplayMode(int, int, SDL_DisplayMode)
     * @see #SDL_SetWindowDisplayMode(SDL_Window, SDL_DisplayMode)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetDesktopDisplayMode(
            int displayIndex,
            SDL_DisplayMode mode);

    /**
     * Get information about the current display mode.
     *
     * <p>There's a difference between this function and SDL_GetDesktopDisplayMode()
     * when SDL runs fullscreen and has changed the resolution. In that case this
     * function will return the current display mode, and not the previous native
     * display mode.</p>
     *
     * @param displayIndex the index of the display to query
     * @param mode         an SDL_DisplayMode structure filled in with the current display
     *                     mode
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetDesktopDisplayMode(int, SDL_DisplayMode)
     * @see #SDL_GetDisplayMode(int, int, SDL_DisplayMode)
     * @see #SDL_GetNumVideoDisplays()
     * @see #SDL_SetWindowDisplayMode(SDL_Window, SDL_DisplayMode)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetCurrentDisplayMode(
            int displayIndex,
            SDL_DisplayMode mode);

    /**
     * Get the closest match to the requested display mode.
     *
     * <p>The available display modes are scanned and {@code closest} is filled in with the
     * closest mode matching the requested mode and returned. The mode format and
     * refresh rate default to the desktop mode if they are set to 0. The modes
     * are scanned with size being first priority, format being second priority,
     * and finally checking the refresh rate. If all the available modes are too
     * small, then null is returned.</p>
     *
     * @param displayIndex the index of the display to query
     * @param mode         an SDL_DisplayMode structure containing the desired display
     *                     mode
     * @param closest      an SDL_DisplayMode structure filled in with the closest
     *                     match of the available display modes
     * @return the passed in value {@code closest} or null if no matching video mode
     * was available; call SDL_GetError() for more information.
     * @see #SDL_GetDisplayMode(int, int, SDL_DisplayMode)
     * @see #SDL_GetNumDisplayModes(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_DisplayMode SDL_GetClosestDisplayMode(
            int displayIndex,
            SDL_DisplayMode mode,
            SDL_DisplayMode closest);

    /**
     * Get the index of the display containing a point
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param point the SDL_Point to query
     * @return the index of the display containing the point or a negative error
     * code on failure; call SDL_GetError() for more information.
     * @see #SDL_GetDisplayBounds(int, SDL_Rect)
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.24.0.
     */
    public static int SDL_GetPointDisplayIndex(
            SDL_Point point) {
        try (Memory rawPoint = new Memory(point.size())) {
            point.write(rawPoint, 0L);
            return SDL_GetPointDisplayIndex(rawPoint);
        }
    }

    /**
     * Get the index of the display containing a point
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_GetPointDisplayIndex(SDL_Point)}.</p>
     *
     * @param point the Pointer to an SDL_Point struct to query
     * @return the index of the display containing the point or a negative error
     * code on failure; call SDL_GetError() for more information.
     * @see #SDL_GetDisplayBounds(int, SDL_Rect)
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.24.0.
     */
    public static native int SDL_GetPointDisplayIndex(
            Pointer point);

    /**
     * Get the index of the display primarily containing a rect
     *
     * @param rect the rect to query
     * @return the index of the display entirely containing the rect or closest
     * to the center of the rect on success or a negative error code on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_GetDisplayBounds(int, SDL_Rect)
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.24.0.
     */
    public static native int SDL_GetRectDisplayIndex(
            SDL_Rect rect);

    /**
     * Get the index of the display associated with a window.
     *
     * @param window the window to query
     * @return the index of the display containing the center of the window on
     * success or a negative error code on failure; call SDL_GetError()
     * for more information.
     * @see #SDL_GetDisplayBounds(int, SDL_Rect)
     * @see #SDL_GetNumVideoDisplays()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetWindowDisplayIndex(
            SDL_Window window);

    /**
     * Set the display mode to use when a window is visible at fullscreen.
     *
     * <p>This only affects the display mode used when the window is fullscreen. To
     * change the window size when the window is not fullscreen, use
     * SDL_SetWindowSize().</p>
     *
     * @param window the window to affect
     * @param mode   the SDL_DisplayMode structure representing the mode to use, or
     *               null to use the window's dimensions and the desktop's format
     *               and refresh rate
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowDisplayMode(SDL_Window, SDL_DisplayMode)
     * @see #SDL_SetWindowFullscreen(SDL_Window, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetWindowDisplayMode(
            SDL_Window window,
            SDL_DisplayMode mode);

    /**
     * Query the display mode to use when a window is visible at fullscreen.
     *
     * @param window the window to query
     * @param mode   an SDL_DisplayMode structure filled in with the fullscreen
     *               display mode
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_SetWindowDisplayMode(SDL_Window, SDL_DisplayMode)
     * @see #SDL_SetWindowFullscreen(SDL_Window, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetWindowDisplayMode(
            SDL_Window window,
            SDL_DisplayMode mode);

    /**
     * Get the raw ICC profile data for the screen the window is currently on.
     *
     * @param window the window to query
     * @return the raw ICC profile data on success or null on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.18.
     */
    public static byte[] SDL_GetWindowICCProfile(
            SDL_Window window) {
        size_t.Ref sizeRef = new size_t.Ref();
        Pointer mem = InternalNativeFunctions.SDL_GetWindowICCProfile(window, sizeRef);
        if (Pointer.nativeValue(mem) == 0L) {
            return null;
        }
        byte[] buffer = mem.getByteArray(0L, sizeRef.getValue().intValue());
        SDL_free(mem);
        return buffer;
    }

    /**
     * Get the pixel format associated with the window.
     *
     * @param window the window to query
     * @return the pixel format of the window on success or
     * SDL_PIXELFORMAT_UNKNOWN on failure; call SDL_GetError() for more
     * information.
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class)
    public static native int SDL_GetWindowPixelFormat(
            SDL_Window window);

    /**
     * Create a window with the specified position, dimensions, and flags.
     *
     * <p>{@code flags} may be any of the following OR'd together:</p>
     *
     * <ul>
     *     <li>{@code SDL_WINDOW_FULLSCREEN}: fullscreen window</li>
     *     <li>{@code SDL_WINDOW_FULLSCREEN_DESKTOP}: fullscreen window at desktop resolution</li>
     *     <li>{@code SDL_WINDOW_OPENGL}: window usable with an OpenGL context</li>
     *     <li>{@code SDL_WINDOW_VULKAN}: window usable with a Vulkan instance</li>
     *     <li>{@code SDL_WINDOW_METAL}: window usable with a Metal instance</li>
     *     <li>{@code SDL_WINDOW_HIDDEN}: window is not visible</li>
     *     <li>{@code SDL_WINDOW_BORDERLESS}: no window decoration</li>
     *     <li>{@code SDL_WINDOW_RESIZABLE}: window can be resized</li>
     *     <li>{@code SDL_WINDOW_MINIMIZED}: window is minimized</li>
     *     <li>{@code SDL_WINDOW_MAXIMIZED}: window is maximized</li>
     *     <li>{@code SDL_WINDOW_INPUT_GRABBED}: window has grabbed input focus</li>
     *     <li>{@code SDL_WINDOW_ALLOW_HIGHDPI}: window should be created in high-DPI mode if
     *         supported (SDL 2.0.1 and newer)</li>
     * </ul>
     *
     * <p>{@code SDL_WINDOW_SHOWN} is ignored by SDL_CreateWindow(). The SDL_Window is
     * implicitly shown if SDL_WINDOW_HIDDEN is not set. {@code SDL_WINDOW_SHOWN} may be
     * queried later using SDL_GetWindowFlags().</p>
     *
     * <p>On Apple's macOS, you **must** set the NSHighResolutionCapable Info.plist
     * property to YES, otherwise you will not receive a High-DPI OpenGL canvas.</p>
     *
     * <p>If the window is created with the {@code SDL_WINDOW_ALLOW_HIGHDPI} flag, its size
     * in pixels may differ from its size in screen coordinates on platforms with
     * high-DPI support (e.g. iOS and macOS). Use SDL_GetWindowSize() to query the
     * client area's size in screen coordinates, and SDL_GL_GetDrawableSize() or
     * SDL_GetRendererOutputSize() to query the drawable size in pixels. Note that
     * when this flag is set, the drawable size can vary after the window is
     * created and should be queried after major window events such as when the
     * window is resized or moved between displays.</p>
     *
     * <p>If the window is set fullscreen, the width and height parameters {@code w} and
     * {@code h} will not be used. However, invalid size parameters (e.g. too large) may
     * still fail. Window size is actually limited to 16384 x 16384 for all
     * platforms at window creation.</p>
     *
     * <p>If the window is created with any of the SDL_WINDOW_OPENGL or
     * SDL_WINDOW_VULKAN flags, then the corresponding LoadLibrary function
     * (SDL_GL_LoadLibrary or SDL_Vulkan_LoadLibrary) is called and the
     * corresponding UnloadLibrary function is called by SDL_DestroyWindow().</p>
     *
     * <p>If SDL_WINDOW_VULKAN is specified and there isn't a working Vulkan driver,
     * SDL_CreateWindow() will fail because SDL_Vulkan_LoadLibrary() will fail.</p>
     *
     * <p>If SDL_WINDOW_METAL is specified on an OS that does not support Metal,
     * SDL_CreateWindow() will fail.</p>
     *
     * <p>On non-Apple devices, SDL requires you to either not link to the Vulkan
     * loader or link to a dynamic library version. This limitation may be removed
     * in a future version of SDL.</p>
     *
     * @param title the title of the window, in UTF-8 encoding
     * @param x     the x position of the window, {@code SDL_WINDOWPOS_CENTERED}, or
     *              {@code SDL_WINDOWPOS_UNDEFINED}
     * @param y     the y position of the window, {@code SDL_WINDOWPOS_CENTERED}, or
     *              {@code SDL_WINDOWPOS_UNDEFINED}
     * @param w     the width of the window, in screen coordinates
     * @param h     the height of the window, in screen coordinates
     * @param flags 0, or one or more SDL_WindowFlags OR'd together
     * @return the window that was created or null on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateWindowFrom(Pointer)
     * @see #SDL_DestroyWindow(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Window SDL_CreateWindow(
            String title,
            int x,
            int y,
            int w,
            int h,
            @MagicConstant(flagsFromClass = SDL_WindowFlags.class) int flags);

    /**
     * Create an SDL window from an existing native window.
     *
     * <p>In some cases (e.g. OpenGL) and on some platforms (e.g. Microsoft Windows)
     * the hint {@code SDL_HINT_VIDEO_WINDOW_SHARE_PIXEL_FORMAT} needs to be configured
     * before using SDL_CreateWindowFrom().</p>
     *
     * @param data a pointer to driver-dependent window creation data, typically
     *             your native window cast to a void*
     * @return the window that was created or null on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateWindow(String, int, int, int, int, int)
     * @see #SDL_DestroyWindow(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Window SDL_CreateWindowFrom(
            Pointer data);

    /**
     * Get the numeric ID of a window.
     *
     * <p>The numeric ID is what SDL_WindowEvent references, and is necessary to map
     * these events to specific SDL_Window objects.</p>
     *
     * @param window the window to query
     * @return the ID of the window on success or 0 on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowFromID(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetWindowID(
            SDL_Window window);

    /**
     * Get a window from a stored ID.
     *
     * <p>The numeric ID is what SDL_WindowEvent references, and is necessary to map
     * these events to specific SDL_Window objects.</p>
     *
     * @param id the ID of the window
     * @return the window associated with {@code id} or null if it doesn't exist; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowID(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Window SDL_GetWindowFromID(
            int id);

    /**
     * Get the window flags.
     *
     * @param window the window to query
     * @return a mask of the SDL_WindowFlags associated with {@code window}
     * @see #SDL_CreateWindow(String, int, int, int, int, int)
     * @see #SDL_HideWindow(SDL_Window)
     * @see #SDL_MaximizeWindow(SDL_Window)
     * @see #SDL_MinimizeWindow(SDL_Window)
     * @see #SDL_SetWindowFullscreen(SDL_Window, int)
     * @see #SDL_SetWindowGrab(SDL_Window, boolean)
     * @see #SDL_ShowWindow(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(flagsFromClass = SDL_WindowFlags.class)
    public static native int SDL_GetWindowFlags(
            SDL_Window window);

    /**
     * Set the title of a window.
     *
     * <p>This string is expected to be in UTF-8 encoding.</p>
     *
     * @param window the window to change
     * @param title  the desired window title in UTF-8 format
     * @see #SDL_GetWindowTitle(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetWindowTitle(
            SDL_Window window,
            String title);

    /**
     * Get the title of a window.
     *
     * @param window the window to query
     * @return the title of the window in UTF-8 format or "" if there is no
     * title.
     * @see #SDL_SetWindowTitle(SDL_Window, String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetWindowTitle(
            SDL_Window window);

    /**
     * Set the icon for a window.
     *
     * @param window the window to change
     * @param icon   an SDL_Surface structure containing the icon for the window
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetWindowIcon(
            SDL_Window window,
            SDL_Surface icon);

    /**
     * Associate an arbitrary named pointer with a window.
     *
     * <p>{@code name} is case-sensitive.</p>
     *
     * @param window   the window to associate with the pointer
     * @param name     the name of the pointer
     * @param userdata the associated pointer
     * @return the previous value associated with {@code name}.
     * @see #SDL_GetWindowData(SDL_Window, String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native Pointer SDL_SetWindowData(
            SDL_Window window,
            String name,
            Pointer userdata);

    /**
     * Retrieve the data pointer associated with a window.
     *
     * @param window the window to query
     * @param name   the name of the pointer
     * @return the value associated with {@code name}.
     * @see #SDL_SetWindowData(SDL_Window, String, Pointer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native Pointer SDL_GetWindowData(
            SDL_Window window,
            String name);

    /**
     * Set the position of a window.
     *
     * <p>The window coordinate origin is the upper left of the display.</p>
     *
     * @param window the window to reposition
     * @param x      the x coordinate of the window in screen coordinates, or
     *               {@code SDL_WINDOWPOS_CENTERED} or {@code SDL_WINDOWPOS_UNDEFINED}
     * @param y      the y coordinate of the window in screen coordinates, or
     *               {@code SDL_WINDOWPOS_CENTERED} or {@code SDL_WINDOWPOS_UNDEFINED}
     * @see #SDL_GetWindowPosition(SDL_Window, IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetWindowPosition(
            SDL_Window window,
            int x,
            int y);

    /**
     * Get the position of a window.
     *
     * <p>If you do not need the value for one of the positions a null may be passed
     * in the {@code x} or {@code y} parameter.</p>
     *
     * @param window the window to query
     * @param x      a pointer filled in with the x position of the window, in screen
     *               coordinates, may be null
     * @param y      a pointer filled in with the y position of the window, in screen
     *               coordinates, may be null
     * @see #SDL_SetWindowPosition(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GetWindowPosition(
            SDL_Window window,
            IntByReference x,
            IntByReference y);

    /**
     * Set the size of a window's client area.
     *
     * <p>The window size in screen coordinates may differ from the size in pixels,
     * if the window was created with {@code SDL_WINDOW_ALLOW_HIGHDPI} on a platform
     * with high-dpi support (e.g. iOS or macOS). Use SDL_GL_GetDrawableSize() or
     * SDL_GetRendererOutputSize() to get the real client area size in pixels.</p>
     *
     * <p>Fullscreen windows automatically match the size of the display mode, and
     * you should use SDL_SetWindowDisplayMode() to change their size.</p>
     *
     * @param window the window to change
     * @param w      the width of the window in pixels, in screen coordinates, must be
     *               greater than 0
     * @param h      the height of the window in pixels, in screen coordinates, must be
     *               greater than 0
     * @see #SDL_GetWindowSize(SDL_Window, IntByReference, IntByReference)
     * @see #SDL_SetWindowDisplayMode(SDL_Window, SDL_DisplayMode)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetWindowSize(
            SDL_Window window,
            int w,
            int h);

    /**
     * Get the size of a window's client area.
     *
     * <p>null can safely be passed as the {@code w} or {@code h} parameter if the width or
     * height value is not desired.</p>
     *
     * <p>The window size in screen coordinates may differ from the size in pixels,
     * if the window was created with {@code SDL_WINDOW_ALLOW_HIGHDPI} on a platform
     * with high-dpi support (e.g. iOS or macOS). Use SDL_GL_GetDrawableSize(),
     * SDL_Vulkan_GetDrawableSize(), or SDL_GetRendererOutputSize() to get the
     * real client area size in pixels.</p>
     *
     * @param window the window to query the width and height from
     * @param w      a pointer filled in with the width of the window, in screen
     *               coordinates, may be null
     * @param h      a pointer filled in with the height of the window, in screen
     *               coordinates, may be null
     * @see #SDL_GL_GetDrawableSize(SDL_Window, IntByReference, IntByReference)
     * @see io.github.libsdl4j.api.vulkan.SdlVulkan#SDL_Vulkan_GetDrawableSize(SDL_Window, IntByReference, IntByReference) SDL_Vulkan_GetDrawableSize(SDL_Window, IntByReference, IntByReference)
     * @see #SDL_SetWindowSize(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GetWindowSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);

    /**
     * Get the size of a window's borders (decorations) around the client area.
     *
     * <p>Note: If this function fails (returns -1), the size values will be
     * initialized to 0, 0, 0, 0 (if a non-null pointer is provided), as if the
     * window in question was borderless.</p>
     *
     * <p>Note: This function may fail on systems where the window has not yet been
     * decorated by the display server (for example, immediately after calling
     * SDL_CreateWindow). It is recommended that you wait at least until the
     * window has been presented and composited, so that the window system has a
     * chance to decorate the window and provide the border dimensions to SDL.</p>
     *
     * <p>This function also returns -1 if getting the information is not supported.</p>
     *
     * @param window the window to query the size values of the border
     *               (decorations) from
     * @param top    pointer to variable for storing the size of the top border; null
     *               is permitted
     * @param left   pointer to variable for storing the size of the left border;
     *               null is permitted
     * @param bottom pointer to variable for storing the size of the bottom
     *               border; null is permitted
     * @param right  pointer to variable for storing the size of the right border;
     *               null is permitted
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowSize(SDL_Window, IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.5.
     */
    public static native int SDL_GetWindowBordersSize(
            SDL_Window window,
            IntByReference top,
            IntByReference left,
            IntByReference bottom,
            IntByReference right);

    /**
     * Get the size of a window in pixels.
     *
     * <p>This may differ from SDL_GetWindowSize() if we're rendering to a high-DPI
     * drawable, i.e. the window was created with {@code SDL_WINDOW_ALLOW_HIGHDPI} on a
     * platform with high-DPI support (Apple calls this "Retina"), and not
     * disabled by the {@code SDL_HINT_VIDEO_HIGHDPI_DISABLED} hint.</p>
     *
     * @param window the window from which the drawable size should be queried
     * @param w      a pointer to variable for storing the width in pixels, may be null
     * @param h      a pointer to variable for storing the height in pixels, may be null
     * @see #SDL_CreateWindow(String, int, int, int, int, int)
     * @see #SDL_GetWindowSize(SDL_Window, IntByReference, IntByReference)
     * @since This function is available since SDL 2.26.0.
     */
    public static native void SDL_GetWindowSizeInPixels(
            SDL_Window window,
            IntByReference w,
            IntByReference h);

    /**
     * Set the minimum size of a window's client area.
     *
     * @param window the window to change
     * @param minW   the minimum width of the window in pixels
     * @param minH   the minimum height of the window in pixels
     * @see #SDL_GetWindowMinimumSize(SDL_Window, IntByReference, IntByReference)
     * @see #SDL_SetWindowMaximumSize(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetWindowMinimumSize(
            SDL_Window window,
            int minW,
            int minH);

    /**
     * Get the minimum size of a window's client area.
     *
     * @param window the window to query
     * @param w      a pointer filled in with the minimum width of the window, may be
     *               null
     * @param h      a pointer filled in with the minimum height of the window, may be
     *               null
     * @see #SDL_GetWindowMaximumSize(SDL_Window, IntByReference, IntByReference)
     * @see #SDL_SetWindowMinimumSize(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GetWindowMinimumSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);

    /**
     * Set the maximum size of a window's client area.
     *
     * @param window the window to change
     * @param maxW   the maximum width of the window in pixels
     * @param maxH   the maximum height of the window in pixels
     * @see #SDL_GetWindowMaximumSize(SDL_Window, IntByReference, IntByReference)
     * @see #SDL_SetWindowMinimumSize(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetWindowMaximumSize(
            SDL_Window window,
            int maxW,
            int maxH);

    /**
     * Get the maximum size of a window's client area.
     *
     * @param window the window to query
     * @param w      a pointer filled in with the maximum width of the window, may be
     *               null
     * @param h      a pointer filled in with the maximum height of the window, may be
     *               null
     * @see #SDL_GetWindowMinimumSize(SDL_Window, IntByReference, IntByReference)
     * @see #SDL_SetWindowMaximumSize(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GetWindowMaximumSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);

    /**
     * Set the border state of a window.
     *
     * <p>This will add or remove the window's {@code SDL_WINDOW_BORDERLESS} flag and add
     * or remove the border from the actual window. This is a no-op if the
     * window's border already matches the requested state.</p>
     *
     * <p>You can't change the border state of a fullscreen window.</p>
     *
     * @param window   the window of which to change the border state
     * @param bordered false to remove border, true to add border
     * @see #SDL_GetWindowFlags(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetWindowBordered(
            SDL_Window window,
            boolean bordered);

    /**
     * Set the user-resizable state of a window.
     *
     * <p>This will add or remove the window's {@code SDL_WINDOW_RESIZABLE} flag and
     * allow/disallow user resizing of the window. This is a no-op if the window's
     * resizable state already matches the requested state.</p>
     *
     * <p>You can't change the resizable state of a fullscreen window.</p>
     *
     * @param window    the window of which to change the resizable state
     * @param resizable true to allow resizing, false to disallow
     * @see #SDL_GetWindowFlags(SDL_Window)
     * @since This function is available since SDL 2.0.5.
     */
    public static native void SDL_SetWindowResizable(
            SDL_Window window,
            boolean resizable);

    /**
     * Set the window to always be above the others.
     *
     * <p>This will add or remove the window's {@code SDL_WINDOW_ALWAYS_ON_TOP} flag. This
     * will bring the window to the front and keep the window above the rest.</p>
     *
     * @param window The window of which to change the always on top state
     * @param onTop  true to set the window always on top, false to
     *               disable
     * @see #SDL_GetWindowFlags(SDL_Window)
     * @since This function is available since SDL 2.0.16.
     */
    public static native void SDL_SetWindowAlwaysOnTop(
            SDL_Window window,
            boolean onTop);

    /**
     * Show a window.
     *
     * @param window the window to show
     * @see #SDL_HideWindow(SDL_Window)
     * @see #SDL_RaiseWindow(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_ShowWindow(
            SDL_Window window);

    /**
     * Hide a window.
     *
     * @param window the window to hide
     * @see #SDL_ShowWindow(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_HideWindow(
            SDL_Window window);

    /**
     * Raise a window above other windows and set the input focus.
     *
     * @param window the window to raise
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_RaiseWindow(
            SDL_Window window);

    /**
     * Make a window as large as possible.
     *
     * @param window the window to maximize
     * @see #SDL_MinimizeWindow(SDL_Window)
     * @see #SDL_RestoreWindow(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_MaximizeWindow(
            SDL_Window window);

    /**
     * Minimize a window to an iconic representation.
     *
     * @param window the window to minimize
     * @see #SDL_MaximizeWindow(SDL_Window)
     * @see #SDL_RestoreWindow(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_MinimizeWindow(
            SDL_Window window);

    /**
     * Restore the size and position of a minimized or maximized window.
     *
     * @param window the window to restore
     * @see #SDL_MaximizeWindow(SDL_Window)
     * @see #SDL_MinimizeWindow(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_RestoreWindow(
            SDL_Window window);

    /**
     * Set a window's fullscreen state.
     *
     * <p>{@code flags} may be {@code SDL_WINDOW_FULLSCREEN}, for "real" fullscreen with a
     * videomode change; {@code SDL_WINDOW_FULLSCREEN_DESKTOP} for "fake" fullscreen
     * that takes the size of the desktop; and 0 for windowed mode.</p>
     *
     * @param window the window to change
     * @param flags  {@code SDL_WINDOW_FULLSCREEN}, {@code SDL_WINDOW_FULLSCREEN_DESKTOP} or 0
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowDisplayMode(SDL_Window, SDL_DisplayMode)
     * @see #SDL_SetWindowDisplayMode(SDL_Window, SDL_DisplayMode)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetWindowFullscreen(
            SDL_Window window,
            @MagicConstant(flags = {SDL_WINDOW_FULLSCREEN, SDL_WINDOW_FULLSCREEN_DESKTOP, 0}) int flags);

    /**
     * Return whether the window has a surface associated with it.
     *
     * @return true if there is a surface associated with the window, or false otherwise.
     * @see #SDL_GetWindowSurface(SDL_Window)
     * @since This function is available since SDL 2.28.0.
     */
    public static native boolean SDL_HasWindowSurface(
            SDL_Window window);

    /**
     * Get the SDL surface associated with the window.
     *
     * <p>A new surface will be created with the optimal format for the window, if
     * necessary. This surface will be freed when the window is destroyed. Do not
     * free this surface.</p>
     *
     * <p>This surface will be invalidated if the window is resized. After resizing a
     * window this function must be called again to return a valid surface.</p>
     *
     * <p>You may not combine this with 3D or the rendering API on this window.</p>
     *
     * <p>This function is affected by {@code SDL_HINT_FRAMEBUFFER_ACCELERATION}.</p>
     *
     * @param window the window to query
     * @return the surface associated with the window, or null on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_DestroyWindowSurface(SDL_Window)
     * @see #SDL_HasWindowSurface(SDL_Window)
     * @see #SDL_UpdateWindowSurface(SDL_Window)
     * @see #SDL_UpdateWindowSurfaceRects(SDL_Window, ContiguousArrayList)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Surface SDL_GetWindowSurface(
            SDL_Window window);

    /**
     * Copy the window surface to the screen.
     *
     * <p>This is the function you use to reflect any changes to the surface on the
     * screen.</p>
     *
     * <p>This function is equivalent to the SDL 1.2 API SDL_Flip().</p>
     *
     * @param window the window to update
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowSurface(SDL_Window)
     * @see #SDL_UpdateWindowSurfaceRects(SDL_Window, ContiguousArrayList)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_UpdateWindowSurface(
            SDL_Window window);

    /**
     * Copy areas of the window surface to the screen.
     *
     * <p>This is the function you use to reflect changes to portions of the surface
     * on the screen.</p>
     *
     * <p>This function is equivalent to the SDL 1.2 API SDL_UpdateRects().</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param window the window to update
     * @param rects  a {@link ContiguousArrayList} of SDL_Rect structures representing areas of the
     *               surface to copy, in pixels
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowSurface(SDL_Window)
     * @see #SDL_UpdateWindowSurface(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_UpdateWindowSurfaceRects(
            SDL_Window window,
            ContiguousArrayList<SDL_Rect> rects) {
        return SDL_UpdateWindowSurfaceRects(window, rects.autoWriteAndGetPointer(), rects.size());
    }

    /**
     * Copy areas of the window surface to the screen.
     *
     * <p>This is the function you use to reflect changes to portions of the surface
     * on the screen.</p>
     *
     * <p>This function is equivalent to the SDL 1.2 API SDL_UpdateRects().</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_UpdateWindowSurfaceRects(SDL_Window, ContiguousArrayList)}.</p>
     *
     * @param window   the window to update
     * @param rects    an array of SDL_Rect structures representing areas of the
     *                 surface to copy, in pixels
     * @param numrects the number of rectangles
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowSurface(SDL_Window)
     * @see #SDL_UpdateWindowSurface(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_UpdateWindowSurfaceRects(
            SDL_Window window,
            Pointer rects,
            int numrects);

    /**
     * Destroy the surface associated with the window.
     *
     * @param window the window to update
     * @return 0 on success or a negative error code on failure; call
     *         SDL_GetError() for more information.
     *
     * @since This function is available since SDL 2.28.0.
     *
     * @see #SDL_GetWindowSurface(SDL_Window)
     * @see #SDL_HasWindowSurface(SDL_Window)
     */
    public static native int SDL_DestroyWindowSurface(
            SDL_Window window);

    /**
     * Set a window's input grab mode.
     *
     * <p>When input is grabbed, the mouse is confined to the window. This function
     * will also grab the keyboard if {@code SDL_HINT_GRAB_KEYBOARD} is set. To grab the
     * keyboard without also grabbing the mouse, use SDL_SetWindowKeyboardGrab().</p>
     *
     * <p>If the caller enables a grab while another window is currently grabbed, the
     * other window loses its grab in favor of the caller's window.</p>
     *
     * @param window  the window for which the input grab mode should be set
     * @param grabbed true to grab input or false to release input
     * @see #SDL_GetGrabbedWindow()
     * @see #SDL_GetWindowGrab(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetWindowGrab(
            SDL_Window window,
            boolean grabbed);

    /**
     * Set a window's keyboard grab mode.
     *
     * <p>Keyboard grab enables capture of system keyboard shortcuts like Alt+Tab or
     * the Meta/Super key. Note that not all system keyboard shortcuts can be
     * captured by applications (one example is Ctrl+Alt+Del on Windows).</p>
     *
     * <p>This is primarily intended for specialized applications such as VNC clients
     * or VM frontends. Normal games should not use keyboard grab.</p>
     *
     * <p>When keyboard grab is enabled, SDL will continue to handle Alt+Tab when the
     * window is full-screen to ensure the user is not trapped in your
     * application. If you have a custom keyboard shortcut to exit fullscreen
     * mode, you may suppress this behavior with
     * {@code SDL_HINT_ALLOW_ALT_TAB_WHILE_GRABBED}.</p>
     *
     * <p>If the caller enables a grab while another window is currently grabbed, the
     * other window loses its grab in favor of the caller's window.</p>
     *
     * @param window  The window for which the keyboard grab mode should be set.
     * @param grabbed This is true to grab keyboard, and false to release.
     * @see #SDL_GetWindowKeyboardGrab(SDL_Window)
     * @see #SDL_SetWindowMouseGrab(SDL_Window, boolean)
     * @see #SDL_SetWindowGrab(SDL_Window, boolean)
     * @since This function is available since SDL 2.0.16.
     */
    public static native void SDL_SetWindowKeyboardGrab(
            SDL_Window window,
            boolean grabbed);

    /**
     * Set a window's mouse grab mode.
     *
     * <p>Mouse grab confines the mouse cursor to the window.</p>
     *
     * @param window  The window for which the mouse grab mode should be set.
     * @param grabbed This is true to grab mouse, and false to release.
     * @see #SDL_GetWindowMouseGrab(SDL_Window)
     * @see #SDL_SetWindowKeyboardGrab(SDL_Window, boolean)
     * @see #SDL_SetWindowGrab(SDL_Window, boolean)
     * @since This function is available since SDL 2.0.16.
     */
    public static native void SDL_SetWindowMouseGrab(
            SDL_Window window,
            boolean grabbed);

    /**
     * Get a window's input grab mode.
     *
     * @param window the window to query
     * @return true if input is grabbed, false otherwise.
     * @see #SDL_SetWindowGrab(SDL_Window, boolean)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_GetWindowGrab(
            SDL_Window window);

    /**
     * Get a window's keyboard grab mode.
     *
     * @param window the window to query
     * @return true if keyboard is grabbed, and false otherwise.
     * @see #SDL_SetWindowKeyboardGrab(SDL_Window, boolean)
     * @see #SDL_GetWindowGrab(SDL_Window)
     * @since This function is available since SDL 2.0.16.
     */
    public static native boolean SDL_GetWindowKeyboardGrab(
            SDL_Window window);

    /**
     * Get a window's mouse grab mode.
     *
     * @param window the window to query
     * @return true if mouse is grabbed, and false otherwise.
     * @see #SDL_SetWindowKeyboardGrab(SDL_Window, boolean)
     * @see #SDL_GetWindowGrab(SDL_Window)
     * @since This function is available since SDL 2.0.16.
     */
    public static native boolean SDL_GetWindowMouseGrab(
            SDL_Window window);

    /**
     * Get the window that currently has an input grab enabled.
     *
     * @return the window if input is grabbed or null otherwise.
     * @see #SDL_GetWindowGrab(SDL_Window)
     * @see #SDL_SetWindowGrab(SDL_Window, boolean)
     * @since This function is available since SDL 2.0.4.
     */
    public static native SDL_Window SDL_GetGrabbedWindow();

    /**
     * Confines the cursor to the specified area of a window.
     *
     * <p>Note that this does NOT grab the cursor, it only defines the area a cursor
     * is restricted to when the window has mouse focus.</p>
     *
     * @param window The window that will be associated with the barrier.
     * @param rect   A rectangle area in window-relative coordinates. If null the
     *               barrier for the specified window will be destroyed.
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowMouseRect(SDL_Window)
     * @see #SDL_SetWindowMouseGrab(SDL_Window, boolean)
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_SetWindowMouseRect(
            SDL_Window window, SDL_Rect rect);

    /**
     * Get the mouse confinement rectangle of a window.
     *
     * @param window The window to query
     * @return A pointer to the mouse confinement rectangle of a window, or null
     * if there isn't one.
     * @see #SDL_SetWindowMouseRect(SDL_Window, SDL_Rect)
     * @since This function is available since SDL 2.0.18.
     */
    public static native SDL_Rect SDL_GetWindowMouseRect(
            SDL_Window window);

    /**
     * Set the brightness (gamma multiplier) for a given window's display.
     *
     * <p>Despite the name and signature, this method sets the brightness of the
     * entire display, not an individual window. A window is considered to be
     * owned by the display that contains the window's center pixel. (The index of
     * this display can be retrieved using SDL_GetWindowDisplayIndex().) The
     * brightness set will not follow the window if it is moved to another
     * display.</p>
     *
     * <p>Many platforms will refuse to set the display brightness in modern times.
     * You are better off using a shader to adjust gamma during rendering, or
     * something similar.</p>
     *
     * @param window     the window used to select the display whose brightness will
     *                   be changed
     * @param brightness the brightness (gamma multiplier) value to set where 0.0
     *                   is completely dark and 1.0 is normal brightness
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowBrightness(SDL_Window)
     * @see #SDL_SetWindowGammaRamp(SDL_Window, short[], short[], short[])
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetWindowBrightness(
            SDL_Window window,
            float brightness);

    /**
     * Get the brightness (gamma multiplier) for a given window's display.
     *
     * <p>Despite the name and signature, this method retrieves the brightness of the
     * entire display, not an individual window. A window is considered to be
     * owned by the display that contains the window's center pixel. (The index of
     * this display can be retrieved using SDL_GetWindowDisplayIndex().)</p>
     *
     * @param window the window used to select the display whose brightness will
     *               be queried
     * @return the brightness for the display where 0.0 is completely dark and
     * 1.0 is normal brightness.
     * @see #SDL_SetWindowBrightness(SDL_Window, float)
     * @since This function is available since SDL 2.0.0.
     */
    public static native float SDL_GetWindowBrightness(
            SDL_Window window);

    /**
     * Set the opacity for a window.
     *
     * <p>The parameter {@code opacity} will be clamped internally between 0.0f
     * (transparent) and 1.0f (opaque).</p>
     *
     * <p>This function also returns -1 if setting the opacity isn't supported.</p>
     *
     * @param window  the window which will be made transparent or opaque
     * @param opacity the opacity value (0.0f - transparent, 1.0f - opaque)
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowOpacity(SDL_Window, FloatByReference)
     * @since This function is available since SDL 2.0.5.
     */
    public static native int SDL_SetWindowOpacity(
            SDL_Window window,
            float opacity);

    /**
     * Get the opacity of a window.
     *
     * <p>If transparency isn't supported on this platform, opacity will be reported
     * as 1.0f without error.</p>
     *
     * <p>The parameter {@code opacity} is ignored if it is null.</p>
     *
     * <p>This function also returns -1 if an invalid window was provided.</p>
     *
     * @param window     the window to get the current opacity value from
     * @param outOpacity the float filled in (0.0f - transparent, 1.0f - opaque)
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_SetWindowOpacity(SDL_Window, float)
     * @since This function is available since SDL 2.0.5.
     */
    public static native int SDL_GetWindowOpacity(
            SDL_Window window,
            FloatByReference outOpacity);

    /**
     * Set the window as a modal for another window.
     *
     * @param modalWindow  the window that should be set modal
     * @param parentWindow the parent window for the modal window
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.5.
     */
    public static native int SDL_SetWindowModalFor(
            SDL_Window modalWindow,
            SDL_Window parentWindow);

    /**
     * Explicitly set input focus to the window.
     *
     * <p>You almost certainly want SDL_RaiseWindow() instead of this function. Use
     * this with caution, as you might give focus to a window that is completely
     * obscured by other windows.</p>
     *
     * @param window the window that should get the input focus
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RaiseWindow(SDL_Window)
     * @since This function is available since SDL 2.0.5.
     */
    public static native int SDL_SetWindowInputFocus(
            SDL_Window window);

    /**
     * Set the gamma ramp for the display that owns a given window.
     *
     * <p>Set the gamma translation table for the red, green, and blue channels of
     * the video hardware. Each table is an array of 256 16-bit quantities,
     * representing a mapping between the input and output for that channel. The
     * input is the index into the array, and the output is the 16-bit gamma value
     * at that index, scaled to the output color precision.</p>
     *
     * <p>Despite the name and signature, this method sets the gamma ramp of the
     * entire display, not an individual window. A window is considered to be
     * owned by the display that contains the window's center pixel. (The index of
     * this display can be retrieved using SDL_GetWindowDisplayIndex().) The gamma
     * ramp set will not follow the window if it is moved to another display.</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param window the window used to select the display whose gamma ramp will
     *               be changed
     * @param red    a 256 element array of 16-bit quantities representing the
     *               translation table for the red channel, or null
     * @param green  a 256 element array of 16-bit quantities representing the
     *               translation table for the green channel, or null
     * @param blue   a 256 element array of 16-bit quantities representing the
     *               translation table for the blue channel, or null
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowGammaRamp(SDL_Window, short[], short[], short[])
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_SetWindowGammaRamp(
            SDL_Window window,
            short[] red,
            short[] green,
            short[] blue) {
        if (red == null || red.length != 256) {
            throw new IllegalArgumentException("Red array length must be 256 but was " + (red != null ? red.length : "null"));
        }
        if (green == null || green.length != 256) {
            throw new IllegalArgumentException("Green array length must be 256 but was " + (green != null ? green.length : "null"));
        }
        if (blue == null || blue.length != 256) {
            throw new IllegalArgumentException("Blue array length must be 256 but was " + (blue != null ? blue.length : "null"));
        }
        try (Memory redMemory = JnaUtils.writeArrayToNativeMemory(red);
             Memory greenMemory = JnaUtils.writeArrayToNativeMemory(green);
             Memory blueMemory = JnaUtils.writeArrayToNativeMemory(blue)) {
            return SDL_SetWindowGammaRamp(window, redMemory, greenMemory, blueMemory);
        }
    }

    /**
     * Set the gamma ramp for the display that owns a given window.
     *
     * <p>Set the gamma translation table for the red, green, and blue channels of
     * the video hardware. Each table is an array of 256 16-bit quantities,
     * representing a mapping between the input and output for that channel. The
     * input is the index into the array, and the output is the 16-bit gamma value
     * at that index, scaled to the output color precision.</p>
     *
     * <p>Despite the name and signature, this method sets the gamma ramp of the
     * entire display, not an individual window. A window is considered to be
     * owned by the display that contains the window's center pixel. (The index of
     * this display can be retrieved using SDL_GetWindowDisplayIndex().) The gamma
     * ramp set will not follow the window if it is moved to another display.</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_SetWindowGammaRamp(SDL_Window, short[], short[], short[])}.</p>
     *
     * @param window the window used to select the display whose gamma ramp will
     *               be changed
     * @param red    a 256 element array of 16-bit quantities representing the
     *               translation table for the red channel, or null
     * @param green  a 256 element array of 16-bit quantities representing the
     *               translation table for the green channel, or null
     * @param blue   a 256 element array of 16-bit quantities representing the
     *               translation table for the blue channel, or null
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetWindowGammaRamp(SDL_Window, short[], short[], short[])
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetWindowGammaRamp(
            SDL_Window window,
            Pointer red,
            Pointer green,
            Pointer blue);

    /**
     * Get the gamma ramp for a given window's display.
     *
     * <p>Despite the name and signature, this method retrieves the gamma ramp of the
     * entire display, not an individual window. A window is considered to be
     * owned by the display that contains the window's center pixel. (The index of
     * this display can be retrieved using SDL_GetWindowDisplayIndex().)</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param window the window used to select the display whose gamma ramp will
     *               be queried
     * @param red    a 256 element array of 16-bit quantities filled in with the
     *               translation table for the red channel
     * @param green  a 256 element array of 16-bit quantities filled in with the
     *               translation table for the green channel
     * @param blue   a 256 element array of 16-bit quantities filled in with the
     *               translation table for the blue channel
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_SetWindowGammaRamp(SDL_Window, short[], short[], short[])
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_GetWindowGammaRamp(
            SDL_Window window,
            short[] red,
            short[] green,
            short[] blue) {
        try (Memory redMemory = new Memory(256 * 2L);
             Memory greenMemory = new Memory(256 * 2L);
             Memory blueMemory = new Memory(256 * 2L)) {
            int result = SDL_GetWindowGammaRamp(window, redMemory, greenMemory, blueMemory);
            redMemory.read(0L, red, 0, 256);
            greenMemory.read(0L, green, 0, 256);
            blueMemory.read(0L, blue, 0, 256);
            return result;
        }
    }

    /**
     * Get the gamma ramp for a given window's display.
     *
     * <p>Despite the name and signature, this method retrieves the gamma ramp of the
     * entire display, not an individual window. A window is considered to be
     * owned by the display that contains the window's center pixel. (The index of
     * this display can be retrieved using SDL_GetWindowDisplayIndex().)</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_GetWindowGammaRamp(SDL_Window, short[], short[], short[])}.</p>
     *
     * @param window the window used to select the display whose gamma ramp will
     *               be queried
     * @param red    a 256 element array of 16-bit quantities filled in with the
     *               translation table for the red channel, or null
     * @param green  a 256 element array of 16-bit quantities filled in with the
     *               translation table for the green channel, or null
     * @param blue   a 256 element array of 16-bit quantities filled in with the
     *               translation table for the blue channel, or null
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_SetWindowGammaRamp(SDL_Window, short[], short[], short[])
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetWindowGammaRamp(
            SDL_Window window,
            Pointer red,
            Pointer green,
            Pointer blue);

    /**
     * Provide a callback that decides if a window region has special properties.
     *
     * <p>Normally windows are dragged and resized by decorations provided by the
     * system window manager (a title bar, borders, etc), but for some apps, it
     * makes sense to drag them from somewhere else inside the window itself; for
     * example, one might have a borderless window that wants to be draggable from
     * any part, or simulate its own title bar, etc.</p>
     *
     * <p>This function lets the app provide a callback that designates pieces of a
     * given window as special. This callback is run during event processing if we
     * need to tell the OS to treat a region of the window specially; the use of
     * this callback is known as "hit testing."</p>
     *
     * <p>Mouse input may not be delivered to your application if it is within a
     * special area; the OS will often apply that input to moving the window or
     * resizing the window and not deliver it to the application.</p>
     *
     * <p>Specifying null for a callback disables hit-testing. Hit-testing is
     * disabled by default.</p>
     *
     * <p>Platforms that don't support this functionality will return -1
     * unconditionally, even if you're attempting to disable hit-testing.</p>
     *
     * <p>Your callback may fire at any time, and its firing does not indicate any
     * specific behavior (for example, on Windows, this certainly might fire when
     * the OS is deciding whether to drag your window, but it fires for lots of
     * other reasons, too, some unrelated to anything you probably care about _and
     * when the mouse isn't actually at the location it is testing_). Since this
     * can fire at any time, you should try to keep your callback efficient,
     * devoid of allocations, etc.</p>
     *
     * @param window       the window to set hit-testing on
     * @param callback     the function to call when doing a hit-test
     * @param callbackData an app-defined void pointer passed to **callback**
     * @return 0 on success or -1 on error (including unsupported); call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.4.
     */
    public static native int SDL_SetWindowHitTest(
            SDL_Window window,
            SDL_HitTest callback,
            Pointer callbackData);

    /**
     * Request a window to demand attention from the user.
     *
     * @param window    the window to be flashed
     * @param operation the flash operation
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.16.
     */
    public static native int SDL_FlashWindow(
            SDL_Window window,
            @MagicConstant(valuesFromClass = SDL_FlashOperation.class) int operation);

    /**
     * Destroy a window.
     *
     * <p>If {@code window} is null, this function will return immediately after setting
     * the SDL error message to "Invalid window". See SDL_GetError().</p>
     *
     * @param window the window to destroy
     * @see #SDL_CreateWindow(String, int, int, int, int, int)
     * @see #SDL_CreateWindowFrom(Pointer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_DestroyWindow(
            SDL_Window window);

    /**
     * Check whether the screensaver is currently enabled.
     *
     * <p>The screensaver is disabled by default since SDL 2.0.2. Before SDL 2.0.2
     * the screensaver was enabled by default.</p>
     *
     * <p>The default can also be changed using {@code SDL_HINT_VIDEO_ALLOW_SCREENSAVER}.</p>
     *
     * @return true if the screensaver is enabled, false if it is
     * disabled.
     * @see #SDL_DisableScreenSaver()
     * @see #SDL_EnableScreenSaver()
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_IsScreenSaverEnabled();

    /**
     * Allow the screen to be blanked by a screen saver.
     *
     * @see #SDL_DisableScreenSaver()
     * @see #SDL_IsScreenSaverEnabled()
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_EnableScreenSaver();

    /**
     * Prevent the screen from being blanked by a screen saver.
     *
     * <p>If you disable the screensaver, it is automatically re-enabled when SDL
     * quits.</p>
     *
     * <p>The screensaver is disabled by default since SDL 2.0.2. Before SDL 2.0.2
     * the screensaver was enabled by default.</p>
     *
     * @see #SDL_EnableScreenSaver()
     * @see #SDL_IsScreenSaverEnabled()
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_DisableScreenSaver();

    /**
     * Dynamically load an OpenGL library.
     *
     * <p>This should be done after initializing the video driver, but before
     * creating any OpenGL windows. If no OpenGL library is loaded, the default
     * library will be loaded upon creation of the first OpenGL window.</p>
     *
     * <p>If you do this, you need to retrieve all of the GL functions used in your
     * program from the dynamic library using SDL_GL_GetProcAddress().</p>
     *
     * @param path the platform dependent OpenGL library name, or null to open the
     *             default OpenGL library
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GL_GetProcAddress(String)
     * @see #SDL_GL_UnloadLibrary()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GL_LoadLibrary(
            String path);

    /**
     * Get an OpenGL function by name.
     *
     * <p>If the GL library is loaded at runtime with SDL_GL_LoadLibrary(), then all
     * GL functions must be retrieved this way. Usually this is used to retrieve
     * function pointers to OpenGL extensions.</p>
     *
     * <p>There are some quirks to looking up OpenGL functions that require some
     * extra care from the application. If you code carefully, you can handle
     * these quirks without any platform-specific code, though:</p>
     *
     * - On Windows, function pointers are specific to the current GL context;
     * this means you need to have created a GL context and made it current
     * before calling SDL_GL_GetProcAddress(). If you recreate your context or
     * create a second context, you should assume that any existing function
     * pointers aren't valid to use with it. This is (currently) a
     * Windows-specific limitation, and in practice lots of drivers don't suffer
     * this limitation, but it is still the way the wgl API is documented to
     * work and you should expect crashes if you don't respect it. Store a copy
     * of the function pointers that comes and goes with context lifespan.
     * - On X11, function pointers returned by this function are valid for any
     * context, and can even be looked up before a context is created at all.
     * This means that, for at least some common OpenGL implementations, if you
     * look up a function that doesn't exist, you'll get a non-null result that
     * is _NOT_ safe to call. You must always make sure the function is actually
     * available for a given GL context before calling it, by checking for the
     * existence of the appropriate extension with SDL_GL_ExtensionSupported(),
     * or verifying that the version of OpenGL you're using offers the function
     * as core functionality.
     * - Some OpenGL drivers, on all platforms, *will* return null if a function
     * isn't supported, but you can't count on this behavior. Check for
     * extensions you use, and if you get a null anyway, act as if that
     * extension wasn't available. This is probably a bug in the driver, but you
     * can code defensively for this scenario anyhow.
     * - Just because you're on Linux/Unix, don't assume you'll be using X11.
     * Next-gen display servers are waiting to replace it, and may or may not
     * make the same promises about function pointers.
     * - OpenGL function pointers must be declared {@code APIENTRY} as in the example
     * code. This will ensure the proper calling convention is followed on
     * platforms where this matters (Win32) thereby avoiding stack corruption.
     *
     * @param proc the name of an OpenGL function
     * @return a pointer to the named OpenGL function. The returned pointer
     * should be cast to the appropriate function signature.
     * @see #SDL_GL_ExtensionSupported(String)
     * @see #SDL_GL_LoadLibrary(String)
     * @see #SDL_GL_UnloadLibrary()
     * @since This function is available since SDL 2.0.0.
     */
    public static native Pointer SDL_GL_GetProcAddress(
            String proc);

    /**
     * Unload the OpenGL library previously loaded by SDL_GL_LoadLibrary().
     *
     * @see #SDL_GL_LoadLibrary(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GL_UnloadLibrary();

    /**
     * Check if an OpenGL extension is supported for the current context.
     *
     * <p>This function operates on the current GL context; you must have created a
     * context and it must be current before calling this function. Do not assume
     * that all contexts you create will have the same set of extensions
     * available, or that recreating an existing context will offer the same
     * extensions again.</p>
     *
     * <p>While it's probably not a massive overhead, this function is not an O(1)
     * operation. Check the extensions you care about after creating the GL
     * context and save that information somewhere instead of calling the function
     * every time you need to know.</p>
     *
     * @param extension the name of the extension to check
     * @return true if the extension is supported, false otherwise.
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_GL_ExtensionSupported(
            String extension);

    /**
     * Reset all previously set OpenGL context attributes to their default values.
     *
     * @see #SDL_GL_GetAttribute(int, IntByReference) SDL_GL_GetAttribute(SDL_GLattr, IntByReference)
     * @see #SDL_GL_SetAttribute(int, int) SDL_GL_SetAttribute(SDL_GLattr, int)
     * @since This function is available since SDL 2.0.2.
     */
    public static native void SDL_GL_ResetAttributes();

    /**
     * Set an OpenGL window attribute before window creation.
     *
     * <p>This function sets the OpenGL attribute {@code attr} to {@code value}. The requested
     * attributes should be set before creating an OpenGL window. You should use
     * SDL_GL_GetAttribute() to check the values after creating the OpenGL
     * context, since the values obtained can differ from the requested ones.</p>
     *
     * @param attr  an SDL_GLattr enum value specifying the OpenGL attribute to set
     * @param value the desired value for the attribute
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GL_GetAttribute(int, IntByReference) SDL_GL_GetAttribute(SDL_GLattr, IntByReference)
     * @see #SDL_GL_ResetAttributes()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GL_SetAttribute(
            @MagicConstant(valuesFromClass = SDL_GLattr.class) int attr,
            int value);

    /**
     * Get the actual value for an attribute from the current context.
     *
     * @param attr  an SDL_GLattr enum value specifying the OpenGL attribute to get
     * @param value a pointer filled in with the current value of {@code attr}
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GL_ResetAttributes()
     * @see #SDL_GL_SetAttribute(int, int) SDL_GL_SetAttribute(SDL_GLattr, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GL_GetAttribute(
            @MagicConstant(valuesFromClass = SDL_GLattr.class) int attr,
            IntByReference value);

    /**
     * Create an OpenGL context for an OpenGL window, and make it current.
     *
     * <p>Windows users new to OpenGL should note that, for historical reasons, GL
     * functions added after OpenGL version 1.1 are not available by default.
     * Those functions must be loaded at run-time, either with an OpenGL
     * extension-handling library or with SDL_GL_GetProcAddress() and its related
     * functions.</p>
     *
     * <p>SDL_GLContext is an alias for {@code void *}. It's opaque to the application.</p>
     *
     * @param window the window to associate with the context
     * @return the OpenGL context associated with {@code window} or null on error; call
     * SDL_GetError() for more details.
     * @see #SDL_GL_DeleteContext(SDL_GLContext)
     * @see #SDL_GL_MakeCurrent(SDL_Window, SDL_GLContext)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_GLContext SDL_GL_CreateContext(
            SDL_Window window);

    /**
     * Set up an OpenGL context for rendering into an OpenGL window.
     *
     * <p>The context must have been created with a compatible window.</p>
     *
     * @param window  the window to associate with the context
     * @param context the OpenGL context to associate with the window
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GL_CreateContext(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GL_MakeCurrent(
            SDL_Window window,
            SDL_GLContext context);

    /**
     * Get the currently active OpenGL window.
     *
     * @return the currently active OpenGL window on success or null on failure;
     * call SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Window SDL_GL_GetCurrentWindow();

    /**
     * Get the currently active OpenGL context.
     *
     * @return the currently active OpenGL context or null on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GL_MakeCurrent(SDL_Window, SDL_GLContext)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_GLContext SDL_GL_GetCurrentContext();

    /**
     * Get the size of a window's underlying drawable in pixels.
     *
     * <p>This returns info useful for calling glViewport().</p>
     *
     * <p>This may differ from SDL_GetWindowSize() if we're rendering to a high-DPI
     * drawable, i.e. the window was created with {@code SDL_WINDOW_ALLOW_HIGHDPI} on a
     * platform with high-DPI support (Apple calls this "Retina"), and not
     * disabled by the {@code SDL_HINT_VIDEO_HIGHDPI_DISABLED} hint.</p>
     *
     * @param window the window from which the drawable size should be queried
     * @param w      a pointer to variable for storing the width in pixels, may be null
     * @param h      a pointer to variable for storing the height in pixels, may be
     *               null
     * @see #SDL_CreateWindow(String, int, int, int, int, int)
     * @see #SDL_GetWindowSize(SDL_Window, IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.1.
     */
    public static native void SDL_GL_GetDrawableSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);

    /**
     * Set the swap interval for the current OpenGL context.
     *
     * <p>Some systems allow specifying -1 for the interval, to enable adaptive
     * vsync. Adaptive vsync works the same as vsync, but if you've already missed
     * the vertical retrace for a given frame, it swaps buffers immediately, which
     * might be less jarring for the user during occasional framerate drops. If an
     * application requests adaptive vsync and the system does not support it,
     * this function will fail and return -1. In such a case, you should probably
     * retry the call with 1 for the interval.</p>
     *
     * <p>Adaptive vsync is implemented for some glX drivers with
     * GLX_EXT_swap_control_tear, and for some Windows drivers with
     * WGL_EXT_swap_control_tear.</p>
     *
     * <p>Read more on the Khronos wiki:
     * https://www.khronos.org/opengl/wiki/Swap_Interval#Adaptive_Vsync</p>
     *
     * @param interval 0 for immediate updates, 1 for updates synchronized with
     *                 the vertical retrace, -1 for adaptive vsync
     * @return 0 on success or -1 if setting the swap interval is not supported;
     * call SDL_GetError() for more information.
     * @see #SDL_GL_GetSwapInterval()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GL_SetSwapInterval(
            int interval);

    /**
     * Get the swap interval for the current OpenGL context.
     *
     * <p>If the system can't determine the swap interval, or there isn't a valid
     * current context, this function will return 0 as a safe default.</p>
     *
     * @return 0 if there is no vertical retrace synchronization, 1 if the buffer
     * swap is synchronized with the vertical retrace, and -1 if late
     * swaps happen immediately instead of waiting for the next retrace;
     * call SDL_GetError() for more information.
     * @see #SDL_GL_SetSwapInterval(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GL_GetSwapInterval();

    /**
     * Update a window with OpenGL rendering.
     *
     * <p>This is used with double-buffered OpenGL contexts, which are the default.</p>
     *
     * <p>On macOS, make sure you bind 0 to the draw framebuffer before swapping the
     * window, otherwise nothing will happen. If you aren't using
     * glBindFramebuffer(), this is the default and you won't have to do anything
     * extra.</p>
     *
     * @param window the window to change
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GL_SwapWindow(
            SDL_Window window);

    /**
     * Delete an OpenGL context.
     *
     * @param context the OpenGL context to be deleted
     * @see #SDL_GL_CreateContext(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GL_DeleteContext(
            SDL_GLContext context);

    private static final class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native Pointer SDL_GetWindowICCProfile(
                SDL_Window window,
                size_t.Ref size);
    }
}
