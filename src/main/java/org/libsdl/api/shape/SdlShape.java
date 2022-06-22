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

    static {
        NativeLoader.registerNativeMethods(SdlShape.class);
    }


    private SdlShape() {
    }

    public static boolean SDL_SHAPEMODEALPHA(
            @MagicConstant(valuesFromClass = WindowShapeMode.class) int mode) {
        return mode == ShapeModeDefault || mode == ShapeModeBinarizeAlpha || mode == ShapeModeReverseBinarizeAlpha;
    }

    @MagicConstant(intValues = {0, SdlShapeConst.SDL_INVALID_SHAPE_ARGUMENT, SdlShapeConst.SDL_NONSHAPEABLE_WINDOW})
    public static native int SDL_SetWindowShape(
            SDL_Window window,
            SDL_Surface shape,
            SDL_WindowShapeMode shapeMode);


    @MagicConstant(intValues = {0, SdlShapeConst.SDL_NONSHAPEABLE_WINDOW, SdlShapeConst.SDL_WINDOW_LACKS_SHAPE})
    public static native int SDL_GetShapedWindowMode(
            SDL_Window window,
            SDL_WindowShapeMode shapeMode);

    public static native SDL_Window SDL_CreateShapedWindow(
            String title,
            int x,
            int y,
            int w,
            int h,
            @MagicConstant(flagsFromClass = SDL_WindowFlags.class) int flags);

    public static native boolean SDL_IsShapedWindow(
            SDL_Window window);
}
