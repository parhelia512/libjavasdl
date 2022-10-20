package io.github.libsdl4j.api.shape;

import io.github.libsdl4j.api.surface.SDL_Surface;
import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.api.video.SDL_WindowFlags;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.shape.WindowShapeMode.ShapeModeBinarizeAlpha;
import static io.github.libsdl4j.api.shape.WindowShapeMode.ShapeModeDefault;
import static io.github.libsdl4j.api.shape.WindowShapeMode.ShapeModeReverseBinarizeAlpha;

/**
 * Definitions from file SDL_shape.h
 *
 * <p>Header file for the shaped window API.</p>
 */
public final class SdlShape {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlShape.class);
    }

    private SdlShape() {
    }

    public static boolean SDL_SHAPEMODEALPHA(
            @MagicConstant(valuesFromClass = WindowShapeMode.class) int mode) {
        return mode == ShapeModeDefault || mode == ShapeModeBinarizeAlpha || mode == ShapeModeReverseBinarizeAlpha;
    }

    /**
     * Set the shape and parameters of a shaped window.
     *
     * @param window    The shaped window whose parameters should be set.
     * @param shape     A surface encoding the desired shape for the window.
     * @param shapeMode The parameters to set for the shaped window.
     * @return 0 on success, SDL_INVALID_SHAPE_ARGUMENT on an invalid shape
     * argument, or SDL_NONSHAPEABLE_WINDOW if the SDL_Window given does
     * not reference a valid shaped window.
     * @see SDL_WindowShapeMode
     * @see #SDL_GetShapedWindowMode(SDL_Window, SDL_WindowShapeMode)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(intValues = {0, SdlShapeConst.SDL_INVALID_SHAPE_ARGUMENT, SdlShapeConst.SDL_NONSHAPEABLE_WINDOW})
    public static native int SDL_SetWindowShape(
            SDL_Window window,
            SDL_Surface shape,
            SDL_WindowShapeMode shapeMode);


    /**
     * Get the shape parameters of a shaped window.
     *
     * @param window    The shaped window whose parameters should be retrieved.
     * @param shapeMode An empty shape-mode structure to fill, or null to check
     *                  whether the window has a shape.
     * @return 0 if the window has a shape and, provided shape_mode was not null,
     * shape_mode has been filled with the mode data,
     * SDL_NONSHAPEABLE_WINDOW if the SDL_Window given is not a shaped
     * window, or SDL_WINDOW_LACKS_SHAPE if the SDL_Window given is a
     * shapeable window currently lacking a shape.
     * @see SDL_WindowShapeMode
     * @see #SDL_SetWindowShape(SDL_Window, SDL_Surface, SDL_WindowShapeMode)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(intValues = {0, SdlShapeConst.SDL_NONSHAPEABLE_WINDOW, SdlShapeConst.SDL_WINDOW_LACKS_SHAPE})
    public static native int SDL_GetShapedWindowMode(
            SDL_Window window,
            SDL_WindowShapeMode shapeMode);

    /**
     * Create a window that can be shaped with the specified position, dimensions,
     * and flags.
     *
     * @param title The title of the window, in UTF-8 encoding.
     * @param x     The x position of the window,
     *              {@link io.github.libsdl4j.api.video.SdlVideoConst#SDL_WINDOWPOS_CENTERED SDL_WINDOWPOS_CENTERED}, or
     *              {@link io.github.libsdl4j.api.video.SdlVideoConst#SDL_WINDOWPOS_UNDEFINED SDL_WINDOWPOS_UNDEFINED}.
     * @param y     The y position of the window,
     *              {@link io.github.libsdl4j.api.video.SdlVideoConst#SDL_WINDOWPOS_CENTERED SDL_WINDOWPOS_CENTERED}, or
     *              {@link io.github.libsdl4j.api.video.SdlVideoConst#SDL_WINDOWPOS_UNDEFINED SDL_WINDOWPOS_UNDEFINED}.
     * @param w     The width of the window.
     * @param h     The height of the window.
     * @param flags The flags for the window, a mask of
     *              {@link SDL_WindowFlags#SDL_WINDOW_BORDERLESS SDL_WINDOW_BORDERLESS} with any of the following:
     *              {@link SDL_WindowFlags#SDL_WINDOW_OPENGL SDL_WINDOW_OPENGL},
     *              {@link SDL_WindowFlags#SDL_WINDOW_INPUT_GRABBED SDL_WINDOW_INPUT_GRABBED},
     *              {@link SDL_WindowFlags#SDL_WINDOW_HIDDEN SDL_WINDOW_HIDDEN},
     *              {@link SDL_WindowFlags#SDL_WINDOW_RESIZABLE SDL_WINDOW_RESIZABLE},
     *              {@link SDL_WindowFlags#SDL_WINDOW_MAXIMIZED SDL_WINDOW_MAXIMIZED},
     *              {@link SDL_WindowFlags#SDL_WINDOW_MINIMIZED SDL_WINDOW_MINIMIZED}.
     *              {@link SDL_WindowFlags#SDL_WINDOW_BORDERLESS SDL_WINDOW_BORDERLESS} is always set,
     *              and {@link SDL_WindowFlags#SDL_WINDOW_FULLSCREEN SDL_WINDOW_FULLSCREEN} is always unset.
     * @return the window created, or null if window creation failed.
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_DestroyWindow(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Window SDL_CreateShapedWindow(
            String title,
            int x,
            int y,
            int w,
            int h,
            @MagicConstant(flagsFromClass = SDL_WindowFlags.class) int flags);

    /**
     * Return whether the given window is a shaped window.
     *
     * @param window The window to query for being shaped.
     * @return true if the window is a window that can be shaped, false if
     * the window is unshaped or null.
     * @see #SDL_CreateShapedWindow(String, int, int, int, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_IsShapedWindow(
            SDL_Window window);
}
