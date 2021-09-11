package org.libsdl.api.video;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.jna.NativeLoader;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "checkstyle:AbbreviationAsWordInName"
})
public final class SdlVideo {

    public static final int SDL_WINDOWPOS_UNDEFINED_MASK = 0x1FFF0000;
    public static final int SDL_WINDOWPOS_CENTERED_MASK = 0x2FFF0000;

    public static int SDL_WINDOWPOS_UNDEFINED_DISPLAY(
            int x) {
        return SDL_WINDOWPOS_UNDEFINED_MASK | x;
    }

    public static int SDL_WINDOWPOS_UNDEFINED() {
        return SDL_WINDOWPOS_UNDEFINED_DISPLAY(0);
    }

    public static boolean SDL_WINDOWPOS_ISUNDEFINED(
            int x) {
        return (x & 0xFFFF0000) == SDL_WINDOWPOS_UNDEFINED_MASK;
    }

    public static int SDL_WINDOWPOS_CENTERED_DISPLAY(
            int x) {
        return SDL_WINDOWPOS_CENTERED_MASK | x;
    }

    public static int SDL_WINDOWPOS_CENTERED() {
        return SDL_WINDOWPOS_CENTERED_DISPLAY(0);
    }

    public static boolean SDL_WINDOWPOS_ISCENTERED(
            int x) {
        return (((x) & 0xFFFF0000) == SDL_WINDOWPOS_CENTERED_MASK);
    }

    public static int SDL_GetNumVideoDrivers() {
        return NativeFunctions.SDL_GetNumVideoDrivers();
    }

    public static String SDL_GetVideoDriver(int index) {
        return NativeFunctions.SDL_GetVideoDriver(index);
    }

    public static int SDL_VideoInit(String driverName) {
        return NativeFunctions.SDL_VideoInit(driverName);
    }

    public static void SDL_VideoQuit() {
        NativeFunctions.SDL_VideoQuit();
    }

    public static String SDL_GetCurrentVideoDriver() {
        return NativeFunctions.SDL_GetCurrentVideoDriver();
    }

    public static int SDL_GetNumVideoDisplays() {
        return NativeFunctions.SDL_GetNumVideoDisplays();
    }

    public static String SDL_GetDisplayName(int displayIndex) {
        return NativeFunctions.SDL_GetDisplayName(displayIndex);
    }

    public static int SDL_GetDisplayBounds(int displayIndex, SDL_Rect rect) {
        return NativeFunctions.SDL_GetDisplayBounds(displayIndex, rect);
    }

    public static int SDL_GetDisplayUsableBounds(int displayIndex, SDL_Rect rect) {
        return NativeFunctions.SDL_GetDisplayUsableBounds(displayIndex, rect);
    }

    public static int SDL_GetDisplayDPI(int displayIndex, FloatByReference ddpi, FloatByReference hdpi, FloatByReference vdpi) {
        return NativeFunctions.SDL_GetDisplayDPI(displayIndex, ddpi, hdpi, vdpi);
    }

    @MagicConstant(valuesFromClass = SDL_DisplayOrientation.class)
    public static int SDL_GetDisplayOrientation(int displayIndex) {
        return NativeFunctions.SDL_GetDisplayOrientation(displayIndex);
    }

    public static int SDL_GetNumDisplayModes(int displayIndex) {
        return NativeFunctions.SDL_GetNumDisplayModes(displayIndex);
    }

    public static int SDL_GetDisplayMode(int displayIndex, int modeIndex, SDL_DisplayMode mode) {
        return NativeFunctions.SDL_GetDisplayMode(displayIndex, modeIndex, mode);
    }

    public static int SDL_GetDesktopDisplayMode(int displayIndex, SDL_DisplayMode mode) {
        return NativeFunctions.SDL_GetDesktopDisplayMode(displayIndex, mode);
    }

    public static int SDL_GetCurrentDisplayMode(int displayIndex, SDL_DisplayMode mode) {
        return NativeFunctions.SDL_GetCurrentDisplayMode(displayIndex, mode);
    }

    public static SDL_DisplayMode SDL_GetClosestDisplayMode(int displayIndex, SDL_DisplayMode mode, SDL_DisplayMode closest) {
        return NativeFunctions.SDL_GetClosestDisplayMode(displayIndex, mode, closest);
    }

    public static int SDL_GetWindowDisplayIndex(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowDisplayIndex(window);
    }

    public static int SDL_SetWindowDisplayMode(SDL_Window window, SDL_DisplayMode mode) {
        return NativeFunctions.SDL_SetWindowDisplayMode(window, mode);
    }

    public static int SDL_GetWindowDisplayMode(SDL_Window window, SDL_DisplayMode mode) {
        return NativeFunctions.SDL_GetWindowDisplayMode(window, mode);
    }

    public static int SDL_GetWindowPixelFormat(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowPixelFormat(window);
    }

    public static SDL_Window SDL_CreateWindow(String title, int x, int y, int w, int h, int flags) {
        return NativeFunctions.SDL_CreateWindow(title, x, y, w, h, flags);
    }

    public static SDL_Window SDL_CreateWindowFrom(Pointer data) {
        return NativeFunctions.SDL_CreateWindowFrom(data);
    }

    public static int SDL_GetWindowID(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowID(window);
    }

    public static SDL_Window SDL_GetWindowFromID(int id) {
        return NativeFunctions.SDL_GetWindowFromID(id);
    }

    @MagicConstant(flagsFromClass = SDL_WindowFlags.class)
    public static int SDL_GetWindowFlags(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowFlags(window);
    }

    public static void SDL_SetWindowTitle(SDL_Window window, String title) {
        NativeFunctions.SDL_SetWindowTitle(window, title);
    }

    public static String SDL_GetWindowTitle(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowTitle(window);
    }

    public static void SDL_SetWindowIcon(SDL_Window window, SDL_Surface icon) {
        NativeFunctions.SDL_SetWindowIcon(window, icon);
    }

    public static Pointer SDL_SetWindowData(SDL_Window window, String name, Pointer userdata) {
        return NativeFunctions.SDL_SetWindowData(window, name, userdata);
    }

    public static Pointer SDL_GetWindowData(SDL_Window window, String name) {
        return NativeFunctions.SDL_GetWindowData(window, name);
    }

    public static void SDL_SetWindowPosition(SDL_Window window, int x, int y) {
        NativeFunctions.SDL_SetWindowPosition(window, x, y);
    }

    public static void SDL_GetWindowPosition(SDL_Window window, IntByReference x, IntByReference y) {
        NativeFunctions.SDL_GetWindowPosition(window, x, y);
    }

    public static void SDL_SetWindowSize(SDL_Window window, int w, int h) {
        NativeFunctions.SDL_SetWindowSize(window, w, h);
    }

    public static void SDL_GetWindowSize(SDL_Window window, IntByReference w, IntByReference h) {
        NativeFunctions.SDL_GetWindowSize(window, w, h);
    }

    public static int SDL_GetWindowBordersSize(SDL_Window window, IntByReference top, IntByReference left, IntByReference bottom, IntByReference right) {
        return NativeFunctions.SDL_GetWindowBordersSize(window, top, left, bottom, right);
    }

    public static void SDL_SetWindowMinimumSize(SDL_Window window, int minW, int minH) {
        NativeFunctions.SDL_SetWindowMinimumSize(window, minW, minH);
    }

    public static void SDL_GetWindowMinimumSize(SDL_Window window, IntByReference w, IntByReference h) {
        NativeFunctions.SDL_GetWindowMinimumSize(window, w, h);
    }

    public static void SDL_SetWindowMaximumSize(SDL_Window window, int maxW, int maxH) {
        NativeFunctions.SDL_SetWindowMaximumSize(window, maxW, maxH);
    }

    public static void SDL_GetWindowMaximumSize(SDL_Window window, IntByReference w, IntByReference h) {
        NativeFunctions.SDL_GetWindowMaximumSize(window, w, h);
    }

    public static void SDL_SetWindowBordered(SDL_Window window, boolean bordered) {
        NativeFunctions.SDL_SetWindowBordered(window, bordered);
    }

    public static void SDL_SetWindowResizable(SDL_Window window, boolean resizable) {
        NativeFunctions.SDL_SetWindowResizable(window, resizable);
    }

    public static void SDL_SetWindowAlwaysOnTop(SDL_Window window, boolean on_top) {
        NativeFunctions.SDL_SetWindowAlwaysOnTop(window, on_top);
    }

    public static void SDL_ShowWindow(SDL_Window window) {
        NativeFunctions.SDL_ShowWindow(window);
    }

    public static void SDL_HideWindow(SDL_Window window) {
        NativeFunctions.SDL_HideWindow(window);
    }

    public static void SDL_RaiseWindow(SDL_Window window) {
        NativeFunctions.SDL_RaiseWindow(window);
    }

    public static void SDL_MaximizeWindow(SDL_Window window) {
        NativeFunctions.SDL_MaximizeWindow(window);
    }

    public static void SDL_MinimizeWindow(SDL_Window window) {
        NativeFunctions.SDL_MinimizeWindow(window);
    }

    public static void SDL_RestoreWindow(SDL_Window window) {
        NativeFunctions.SDL_RestoreWindow(window);
    }

    public static int SDL_SetWindowFullscreen(SDL_Window window, int flags) {
        return NativeFunctions.SDL_SetWindowFullscreen(window, flags);
    }

    public static SDL_Surface SDL_GetWindowSurface(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowSurface(window);
    }

    public static int SDL_UpdateWindowSurface(SDL_Window window) {
        return NativeFunctions.SDL_UpdateWindowSurface(window);
    }

    public static int SDL_UpdateWindowSurfaceRects(SDL_Window window, Pointer rects, int numrects) {
        return NativeFunctions.SDL_UpdateWindowSurfaceRects(window, rects, numrects);
    }

    public static int SDL_SetWindowGrab(SDL_Window window, boolean grabbed) {
        return NativeFunctions.SDL_SetWindowGrab(window, grabbed);
    }

    public static void SDL_SetWindowKeyboardGrab(SDL_Window window, boolean grabbed) {
        NativeFunctions.SDL_SetWindowKeyboardGrab(window, grabbed);
    }

    public static void SDL_SetWindowMouseGrab(SDL_Window window, boolean grabbed) {
        NativeFunctions.SDL_SetWindowMouseGrab(window, grabbed);
    }

    public static boolean SDL_GetWindowGrab(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowGrab(window);
    }

    public static boolean SDL_GetWindowKeyboardGrab(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowKeyboardGrab(window);
    }

    public static boolean SDL_GetWindowMouseGrab(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowMouseGrab(window);
    }

    public static SDL_Window SDL_GetGrabbedWindow() {
        return NativeFunctions.SDL_GetGrabbedWindow();
    }

    public static int SDL_SetWindowBrightness(SDL_Window window, float brightness) {
        return NativeFunctions.SDL_SetWindowBrightness(window, brightness);
    }

    public static float SDL_GetWindowBrightness(SDL_Window window) {
        return NativeFunctions.SDL_GetWindowBrightness(window);
    }

    public static int SDL_SetWindowOpacity(SDL_Window window, float opacity) {
        return NativeFunctions.SDL_SetWindowOpacity(window, opacity);
    }

    public static int SDL_GetWindowOpacity(SDL_Window window, FloatByReference outOpacity) {
        return NativeFunctions.SDL_GetWindowOpacity(window, outOpacity);
    }

    public static int SDL_SetWindowModalFor(SDL_Window modalWindow, SDL_Window parentWindow) {
        return NativeFunctions.SDL_SetWindowModalFor(modalWindow, parentWindow);
    }

    public static int SDL_SetWindowInputFocus(SDL_Window window) {
        return NativeFunctions.SDL_SetWindowInputFocus(window);
    }

    public static int SDL_SetWindowGammaRamp(SDL_Window window, Pointer red, Pointer green, Pointer blue) {
        return NativeFunctions.SDL_SetWindowGammaRamp(window, red, green, blue);
    }

    public static int SDL_GetWindowGammaRamp(SDL_Window window, Pointer red, Pointer green, Pointer blue) {
        return NativeFunctions.SDL_GetWindowGammaRamp(window, red, green, blue);
    }

    public static int SDL_SetWindowHitTest(SDL_Window window, SDL_HitTest callback, Pointer callbackData) {
        return NativeFunctions.SDL_SetWindowHitTest(window, callback, callbackData);
    }

    public static int SDL_FlashWindow(SDL_Window window, int operation) {
        return NativeFunctions.SDL_FlashWindow(window, operation);
    }

    public static void SDL_DestroyWindow(SDL_Window window) {
        NativeFunctions.SDL_DestroyWindow(window);
    }

    public static boolean SDL_IsScreenSaverEnabled() {
        return NativeFunctions.SDL_IsScreenSaverEnabled();
    }

    public static void SDL_EnableScreenSaver() {
        NativeFunctions.SDL_EnableScreenSaver();
    }

    public static void SDL_DisableScreenSaver() {
        NativeFunctions.SDL_DisableScreenSaver();
    }

    public static int SDL_GL_LoadLibrary(String path) {
        return NativeFunctions.SDL_GL_LoadLibrary(path);
    }

    public static Pointer SDL_GL_GetProcAddress(String proc) {
        return NativeFunctions.SDL_GL_GetProcAddress(proc);
    }

    public static void SDL_GL_UnloadLibrary() {
        NativeFunctions.SDL_GL_UnloadLibrary();
    }

    public static boolean SDL_GL_ExtensionSupported(String extension) {
        return NativeFunctions.SDL_GL_ExtensionSupported(extension);
    }

    public static void SDL_GL_ResetAttributes() {
        NativeFunctions.SDL_GL_ResetAttributes();
    }

    public static int SDL_GL_SetAttribute(int attr, int value) {
        return NativeFunctions.SDL_GL_SetAttribute(attr, value);
    }

    public static int SDL_GL_GetAttribute(int attr, IntByReference value) {
        return NativeFunctions.SDL_GL_GetAttribute(attr, value);
    }

    public static SDL_GLContext SDL_GL_CreateContext(SDL_Window window) {
        return NativeFunctions.SDL_GL_CreateContext(window);
    }

    public static int SDL_GL_MakeCurrent(SDL_Window window, SDL_GLContext context) {
        return NativeFunctions.SDL_GL_MakeCurrent(window, context);
    }

    public static SDL_Window SDL_GL_GetCurrentWindow() {
        return NativeFunctions.SDL_GL_GetCurrentWindow();
    }

    public static SDL_GLContext SDL_GL_GetCurrentContext() {
        return NativeFunctions.SDL_GL_GetCurrentContext();
    }

    public static void SDL_GL_GetDrawableSize(SDL_Window window, IntByReference w, IntByReference h) {
        NativeFunctions.SDL_GL_GetDrawableSize(window, w, h);
    }

    public static int SDL_GL_SetSwapInterval(int interval) {
        return NativeFunctions.SDL_GL_SetSwapInterval(interval);
    }

    public static int SDL_GL_GetSwapInterval() {
        return NativeFunctions.SDL_GL_GetSwapInterval();
    }

    public static void SDL_GL_SwapWindow(SDL_Window window) {
        NativeFunctions.SDL_GL_SwapWindow(window);
    }

    public static void SDL_GL_DeleteContext(SDL_GLContext context) {
        NativeFunctions.SDL_GL_DeleteContext(context);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        private NativeFunctions() {
        }

        public static native int SDL_GetNumVideoDrivers();

        public static native String SDL_GetVideoDriver(
                int index);

        public static native int SDL_VideoInit(
                String driverName);

        public static native void SDL_VideoQuit();

        public static native String SDL_GetCurrentVideoDriver();

        public static native int SDL_GetNumVideoDisplays();

        public static native String SDL_GetDisplayName(
                int displayIndex);

        public static native int SDL_GetDisplayBounds(
                int displayIndex,
                SDL_Rect rect);

        public static native int SDL_GetDisplayUsableBounds(
                int displayIndex,
                SDL_Rect rect);

        public static native int SDL_GetDisplayDPI(
                int displayIndex,
                FloatByReference ddpi,
                FloatByReference hdpi,
                FloatByReference vdpi);

        @MagicConstant(valuesFromClass = SDL_DisplayOrientation.class)
        public static native int SDL_GetDisplayOrientation(
                int displayIndex);

        public static native int SDL_GetNumDisplayModes(
                int displayIndex);

        public static native int SDL_GetDisplayMode(
                int displayIndex,
                int modeIndex,
                SDL_DisplayMode mode);

        public static native int SDL_GetDesktopDisplayMode(
                int displayIndex,
                SDL_DisplayMode mode);

        public static native int SDL_GetCurrentDisplayMode(
                int displayIndex,
                SDL_DisplayMode mode);

        public static native SDL_DisplayMode SDL_GetClosestDisplayMode(
                int displayIndex,
                SDL_DisplayMode mode,
                SDL_DisplayMode closest);

        public static native int SDL_GetWindowDisplayIndex(
                SDL_Window window);

        public static native int SDL_SetWindowDisplayMode(
                SDL_Window window,
                SDL_DisplayMode mode);

        public static native int SDL_GetWindowDisplayMode(
                SDL_Window window,
                SDL_DisplayMode mode);

        public static native int SDL_GetWindowPixelFormat(
                SDL_Window window);

        public static native SDL_Window SDL_CreateWindow(
                String title,
                int x,
                int y,
                int w,
                int h,
                @MagicConstant(flagsFromClass = SDL_WindowFlags.class) int flags);

        public static native SDL_Window SDL_CreateWindowFrom(
                Pointer data);

        public static native int SDL_GetWindowID(
                SDL_Window window);

        public static native SDL_Window SDL_GetWindowFromID(
                int id);

        @MagicConstant(flagsFromClass = SDL_WindowFlags.class)
        public static native int SDL_GetWindowFlags(
                SDL_Window window);

        // TODO: Charset UTF-8
        public static native void SDL_SetWindowTitle(
                SDL_Window window,
                String title);

        // TODO: Charset UTF-8
        public static native String SDL_GetWindowTitle(
                SDL_Window window);

        public static native void SDL_SetWindowIcon(
                SDL_Window window,
                SDL_Surface icon);

        public static native Pointer SDL_SetWindowData(
                SDL_Window window,
                String name,
                Pointer userdata);

        public static native Pointer SDL_GetWindowData(
                SDL_Window window,
                String name);

        public static native void SDL_SetWindowPosition(
                SDL_Window window,
                int x,
                int y);

        public static native void SDL_GetWindowPosition(
                SDL_Window window,
                IntByReference x,
                IntByReference y);

        public static native void SDL_SetWindowSize(
                SDL_Window window,
                int w,
                int h);

        public static native void SDL_GetWindowSize(
                SDL_Window window,
                IntByReference w,
                IntByReference h);

        public static native int SDL_GetWindowBordersSize(
                SDL_Window window,
                IntByReference top,
                IntByReference left,
                IntByReference bottom,
                IntByReference right);

        public static native void SDL_SetWindowMinimumSize(
                SDL_Window window,
                int minW,
                int minH);

        public static native void SDL_GetWindowMinimumSize(
                SDL_Window window,
                IntByReference w,
                IntByReference h);


        public static native void SDL_SetWindowMaximumSize(
                SDL_Window window,
                int maxW,
                int maxH);

        public static native void SDL_GetWindowMaximumSize(
                SDL_Window window,
                IntByReference w,
                IntByReference h);

        public static native void SDL_SetWindowBordered(
                SDL_Window window,
                boolean bordered);

        public static native void SDL_SetWindowResizable(
                SDL_Window window,
                boolean resizable);

        public static native void SDL_SetWindowAlwaysOnTop(
                SDL_Window window,
                boolean on_top);

        public static native void SDL_ShowWindow(
                SDL_Window window);

        public static native void SDL_HideWindow(
                SDL_Window window);

        public static native void SDL_RaiseWindow(
                SDL_Window window);

        public static native void SDL_MaximizeWindow(
                SDL_Window window);

        public static native void SDL_MinimizeWindow(
                SDL_Window window);

        public static native void SDL_RestoreWindow(
                SDL_Window window);

        public static native int SDL_SetWindowFullscreen(
                SDL_Window window,
                int flags);

        public static native SDL_Surface SDL_GetWindowSurface(
                SDL_Window window);

        public static native int SDL_UpdateWindowSurface(
                SDL_Window window);

        // TODO: Wrap in Java array
        public static native int SDL_UpdateWindowSurfaceRects(
                SDL_Window window,
                Pointer rects,
                int numrects);

        public static native int SDL_SetWindowGrab(
                SDL_Window window,
                boolean grabbed);

        public static native void SDL_SetWindowKeyboardGrab(
                SDL_Window window,
                boolean grabbed);

        public static native void SDL_SetWindowMouseGrab(
                SDL_Window window,
                boolean grabbed);

        public static native boolean SDL_GetWindowGrab(
                SDL_Window window);

        public static native boolean SDL_GetWindowKeyboardGrab(
                SDL_Window window);

        public static native boolean SDL_GetWindowMouseGrab(
                SDL_Window window);

        public static native SDL_Window SDL_GetGrabbedWindow();

        public static native int SDL_SetWindowBrightness(
                SDL_Window window,
                float brightness);

        public static native float SDL_GetWindowBrightness(
                SDL_Window window);

        public static native int SDL_SetWindowOpacity(
                SDL_Window window,
                float opacity);

        public static native int SDL_GetWindowOpacity(
                SDL_Window window,
                FloatByReference outOpacity);

        public static native int SDL_SetWindowModalFor(
                SDL_Window modalWindow,
                SDL_Window parentWindow);

        public static native int SDL_SetWindowInputFocus(
                SDL_Window window);

        // TODO: Wrap it in Java array
        public static native int SDL_SetWindowGammaRamp(
                SDL_Window window,
                Pointer red,
                Pointer green,
                Pointer blue);

        // TODO: Wrap it in Java array
        public static native int SDL_GetWindowGammaRamp(
                SDL_Window window,
                Pointer red,
                Pointer green,
                Pointer blue);

        public static native int SDL_SetWindowHitTest(
                SDL_Window window,
                SDL_HitTest callback,
                Pointer callbackData);

        public static native int SDL_FlashWindow(
                SDL_Window window,
                @MagicConstant(valuesFromClass = SDL_FlashOperation.class) int operation);

        public static native void SDL_DestroyWindow(
                SDL_Window window);

        public static native boolean SDL_IsScreenSaverEnabled();

        public static native void SDL_EnableScreenSaver();

        public static native void SDL_DisableScreenSaver();

        public static native int SDL_GL_LoadLibrary(
                String path);

        public static native Pointer SDL_GL_GetProcAddress(
                String proc);

        public static native void SDL_GL_UnloadLibrary();

        public static native boolean SDL_GL_ExtensionSupported(
                String extension);

        public static native void SDL_GL_ResetAttributes();

        public static native int SDL_GL_SetAttribute(
                @MagicConstant(valuesFromClass = SDL_GLattr.class) int attr,
                int value);

        public static native int SDL_GL_GetAttribute(
                @MagicConstant(valuesFromClass = SDL_GLattr.class) int attr,
                IntByReference value);

        public static native SDL_GLContext SDL_GL_CreateContext(
                SDL_Window window);

        public static native int SDL_GL_MakeCurrent(
                SDL_Window window,
                SDL_GLContext context);

        public static native SDL_Window SDL_GL_GetCurrentWindow();

        public static native SDL_GLContext SDL_GL_GetCurrentContext();

        public static native void SDL_GL_GetDrawableSize(
                SDL_Window window,
                IntByReference w,
                IntByReference h);

        public static native int SDL_GL_SetSwapInterval(
                int interval);

        public static native int SDL_GL_GetSwapInterval();

        public static native void SDL_GL_SwapWindow(
                SDL_Window window);

        public static native void SDL_GL_DeleteContext(
                SDL_GLContext context);
    }
}
