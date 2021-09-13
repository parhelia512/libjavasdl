package org.libsdl.api.shape;

import org.intellij.lang.annotations.MagicConstant;

import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.api.video.SDL_WindowFlags;
import org.libsdl.jna.NativeLoader;

import static org.libsdl.api.shape.WindowShapeMode.ShapeModeBinarizeAlpha;
import static org.libsdl.api.shape.WindowShapeMode.ShapeModeDefault;
import static org.libsdl.api.shape.WindowShapeMode.ShapeModeReverseBinarizeAlpha;

public final class SdlShape {

    public static final int SDL_NONSHAPEABLE_WINDOW = -1;
    public static final int SDL_INVALID_SHAPE_ARGUMENT = -2;
    public static final int SDL_WINDOW_LACKS_SHAPE = -3;

    public static boolean SDL_SHAPEMODEALPHA(
            @MagicConstant(valuesFromClass = WindowShapeMode.class) int mode) {
        return mode == ShapeModeDefault || mode == ShapeModeBinarizeAlpha || mode == ShapeModeReverseBinarizeAlpha;
    }

    @MagicConstant(intValues = {0, SDL_INVALID_SHAPE_ARGUMENT, SDL_NONSHAPEABLE_WINDOW})
    public static int SDL_SetWindowShape(
            SDL_Window window,
            SDL_Surface shape,
            SDL_WindowShapeMode shapeMode) {
        return NativeFunctions.SDL_SetWindowShape(window, shape, shapeMode);
    }

    @MagicConstant(intValues = {0, SDL_NONSHAPEABLE_WINDOW, SDL_WINDOW_LACKS_SHAPE})
    public static int SDL_GetShapedWindowMode(
            SDL_Window window,
            SDL_WindowShapeMode shapeMode) {
        return NativeFunctions.SDL_GetShapedWindowMode(window, shapeMode);
    }

    public static SDL_Window SDL_CreateShapedWindow(
            String title,
            int x,
            int y,
            int w,
            int h,
            @MagicConstant(flagsFromClass = SDL_WindowFlags.class) int flags) {
        return NativeFunctions.SDL_CreateShapedWindow(title, x, y, w, h, flags);
    }

    public static boolean SDL_IsShapedWindow(
            SDL_Window window) {
        return NativeFunctions.SDL_IsShapedWindow(window);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        private NativeFunctions() {
        }

        public static native SDL_Window SDL_CreateShapedWindow(
                String title,
                int x,
                int y,
                int w,
                int h,
                @MagicConstant(flagsFromClass = SDL_WindowFlags.class) int flags);

        public static native boolean SDL_IsShapedWindow(
                SDL_Window window);

        @MagicConstant(intValues = {0, SDL_INVALID_SHAPE_ARGUMENT, SDL_NONSHAPEABLE_WINDOW})
        public static native int SDL_SetWindowShape(
                SDL_Window window,
                SDL_Surface shape,
                SDL_WindowShapeMode shapeMode);

        @MagicConstant(intValues = {0, SDL_NONSHAPEABLE_WINDOW, SDL_WINDOW_LACKS_SHAPE})
        public static native int SDL_GetShapedWindowMode(
                SDL_Window window,
                SDL_WindowShapeMode shapeMode);
    }
}
