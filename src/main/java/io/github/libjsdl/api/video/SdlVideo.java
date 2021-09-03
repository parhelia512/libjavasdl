package io.github.libjsdl.api.video;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;

import io.github.libjsdl.api.rect.SDL_Rect;
import io.github.libjsdl.api.surface.SDL_Surface;
import io.github.libjsdl.loader.NativeLoader;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "checkstyle:AbbreviationAsWordInName"})
public final class SdlVideo {

    public static final int SDL_WINDOW_FULLSCREEN = 0x00000001;
    public static final int SDL_WINDOW_OPENGL = 0x00000002;
    public static final int SDL_WINDOW_SHOWN = 0x00000004;
    public static final int SDL_WINDOW_HIDDEN = 0x00000008;
    public static final int SDL_WINDOW_BORDERLESS = 0x00000010;
    public static final int SDL_WINDOW_RESIZABLE = 0x00000020;
    public static final int SDL_WINDOW_MINIMIZED = 0x00000040;
    public static final int SDL_WINDOW_MAXIMIZED = 0x00000080;
    public static final int SDL_WINDOW_INPUT_GRABBED = 0x00000100;
    public static final int SDL_WINDOW_INPUT_FOCUS = 0x00000200;
    public static final int SDL_WINDOW_MOUSE_FOCUS = 0x00000400;
    public static final int SDL_WINDOW_FULLSCREEN_DESKTOP = SDL_WINDOW_FULLSCREEN + 0x00001000;
    public static final int SDL_WINDOW_FOREIGN = 0x00000800;
    public static final int SDL_WINDOW_ALLOW_HIGHDPI = 0x00002000;
    public static final int SDL_WINDOW_MOUSE_CAPTURE = 0x00004000;
    public static final int SDL_WINDOW_ALWAYS_ON_TOP = 0x00008000;
    public static final int SDL_WINDOW_SKIP_TASKBAR = 0x00010000;
    public static final int SDL_WINDOW_UTILITY = 0x00020000;
    public static final int SDL_WINDOW_TOOLTIP = 0x00040000;
    public static final int SDL_WINDOW_POPUP_MENU = 0x00080000;
    public static final int SDL_WINDOW_VULKAN = 0x10000000;

    public static final int SDL_WINDOWPOS_UNDEFINED_MASK = 0x1FFF0000;
    public static final int SDL_WINDOWPOS_CENTERED_MASK = 0x2FFF0000;

    public static final int SDL_WINDOWEVENT_NONE = 1;
    public static final int SDL_WINDOWEVENT_SHOWN = 2;
    public static final int SDL_WINDOWEVENT_HIDDEN = 3;
    public static final int SDL_WINDOWEVENT_EXPOSED = 4;
    public static final int SDL_WINDOWEVENT_MOVED = 5;
    public static final int SDL_WINDOWEVENT_RESIZED = 6;
    public static final int SDL_WINDOWEVENT_SIZE_CHANGED = 7;
    public static final int SDL_WINDOWEVENT_MINIMIZED = 8;
    public static final int SDL_WINDOWEVENT_MAXIMIZED = 9;
    public static final int SDL_WINDOWEVENT_RESTORED = 10;
    public static final int SDL_WINDOWEVENT_ENTER = 11;
    public static final int SDL_WINDOWEVENT_LEAVE = 12;
    public static final int SDL_WINDOWEVENT_FOCUS_GAINED = 13;
    public static final int SDL_WINDOWEVENT_FOCUS_LOST = 14;
    public static final int SDL_WINDOWEVENT_CLOSE = 15;
    public static final int SDL_WINDOWEVENT_TAKE_FOCUS = 16;
    public static final int SDL_WINDOWEVENT_HIT_TEST = 17;

    public static final int SDL_GL_RED_SIZE = 1;
    public static final int SDL_GL_GREEN_SIZE = 2;
    public static final int SDL_GL_BLUE_SIZE = 3;
    public static final int SDL_GL_ALPHA_SIZE = 4;
    public static final int SDL_GL_BUFFER_SIZE = 5;
    public static final int SDL_GL_DOUBLEBUFFER = 6;
    public static final int SDL_GL_DEPTH_SIZE = 7;
    public static final int SDL_GL_STENCIL_SIZE = 8;
    public static final int SDL_GL_ACCUM_RED_SIZE = 9;
    public static final int SDL_GL_ACCUM_GREEN_SIZE = 10;
    public static final int SDL_GL_ACCUM_BLUE_SIZE = 11;
    public static final int SDL_GL_ACCUM_ALPHA_SIZE = 12;
    public static final int SDL_GL_STEREO = 13;
    public static final int SDL_GL_MULTISAMPLEBUFFERS = 14;
    public static final int SDL_GL_MULTISAMPLESAMPLES = 15;
    public static final int SDL_GL_ACCELERATED_VISUAL = 16;
    public static final int SDL_GL_RETAINED_BACKING = 17;
    public static final int SDL_GL_CONTEXT_MAJOR_VERSION = 18;
    public static final int SDL_GL_CONTEXT_MINOR_VERSION = 19;
    public static final int SDL_GL_CONTEXT_EGL = 20;
    public static final int SDL_GL_CONTEXT_FLAGS = 21;
    public static final int SDL_GL_CONTEXT_PROFILE_MASK = 22;
    public static final int SDL_GL_SHARE_WITH_CURRENT_CONTEXT = 23;
    public static final int SDL_GL_FRAMEBUFFER_SRGB_CAPABLE = 24;
    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR = 25;
    public static final int SDL_GL_CONTEXT_RESET_NOTIFICATION = 26;
    public static final int SDL_GL_CONTEXT_NO_ERROR = 27;

    public static final int SDL_GL_CONTEXT_PROFILE_CORE = 0x0001;
    public static final int SDL_GL_CONTEXT_PROFILE_COMPATIBILITY = 0x0002;
    public static final int SDL_GL_CONTEXT_PROFILE_ES = 0x0004;

    public static final int SDL_GL_CONTEXT_DEBUG_FLAG = 0x0001;
    public static final int SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG = 0x0002;
    public static final int SDL_GL_CONTEXT_ROBUST_ACCESS_FLAG = 0x0004;
    public static final int SDL_GL_CONTEXT_RESET_ISOLATION_FLAG = 0x0008;

    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR_NONE = 0x0000;
    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 0x0001;

    public static final int SDL_GL_CONTEXT_RESET_NO_NOTIFICATION = 0x0000;
    public static final int SDL_GL_CONTEXT_RESET_LOSE_CONTEXT = 0x0001;

    public static final int SDL_HITTEST_NORMAL = 0;
    public static final int SDL_HITTEST_DRAGGABLE = 1;
    public static final int SDL_HITTEST_RESIZE_TOPLEFT = 2;
    public static final int SDL_HITTEST_RESIZE_TOP = 3;
    public static final int SDL_HITTEST_RESIZE_TOPRIGHT = 4;
    public static final int SDL_HITTEST_RESIZE_RIGHT = 5;
    public static final int SDL_HITTEST_RESIZE_BOTTOMRIGHT = 6;
    public static final int SDL_HITTEST_RESIZE_BOTTOM = 7;
    public static final int SDL_HITTEST_RESIZE_BOTTOMLEFT = 8;
    public static final int SDL_HITTEST_RESIZE_LEFT = 9;

    static {
        NativeLoader.registerNativeMethods(SdlVideo.class);
    }

    private SdlVideo() {
    }

    public static int SDL_WINDOWPOS_UNDEFINED_DISPLAY(
            final int x) {
        return SDL_WINDOWPOS_UNDEFINED_MASK | x;
    }

    public static int SDL_WINDOWPOS_UNDEFINED() {
        return SDL_WINDOWPOS_UNDEFINED_DISPLAY(0);
    }

    public static boolean SDL_WINDOWPOS_ISUNDEFINED(
            final int x) {
        return (((x) & 0xFFFF0000) == SDL_WINDOWPOS_UNDEFINED_MASK);
    }

    public static int SDL_WINDOWPOS_CENTERED_DISPLAY(
            final int x) {
        return SDL_WINDOWPOS_CENTERED_MASK | x;
    }

    public static int SDL_WINDOWPOS_CENTERED() {
        return SDL_WINDOWPOS_CENTERED_DISPLAY(0);
    }

    public static boolean SDL_WINDOWPOS_ISCENTERED(
            final int x) {
        return (((x) & 0xFFFF0000) == SDL_WINDOWPOS_CENTERED_MASK);
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

    public static native int SDL_GetDisplayDPI(
            int displayIndex,
            FloatByReference ddpi,
            FloatByReference hdpi,
            FloatByReference vdpi);

    public static native int SDL_GetDisplayUsableBounds(
            int displayIndex,
            SDL_Rect rect);

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
            int flags);

    public static native SDL_Window SDL_CreateWindowFrom(
            Pointer data);

    public static native int SDL_GetWindowID(
            SDL_Window window);

    public static native SDL_Window SDL_GetWindowFromID(
            int id);

    public static native int SDL_GetWindowFlags(
            SDL_Window window);

    public static native void SDL_SetWindowTitle(
            SDL_Window window,
            String title);

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

    public static native int SDL_UpdateWindowSurfaceRects(
            SDL_Window window,
            Pointer rects,
            int numrects);

    public static native int SDL_SetWindowGrab(
            SDL_Window window,
            boolean grabbed);

    public static native boolean SDL_GetWindowGrab(
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

    public static native int SDL_SetWindowGammaRamp(
            SDL_Window window,
            Pointer red,
            Pointer green,
            Pointer blue);

    public static native int SDL_GetWindowGammaRamp(
            SDL_Window window,
            Pointer red,
            Pointer green,
            Pointer blue);

    public static native int SDL_SetWindowHitTest(
            SDL_Window window,
            SDL_HitTest callback,
            Pointer callbackData);

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
            int attr,
            int value);

    public static native int SDL_GL_GetAttribute(
            int attr,
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
