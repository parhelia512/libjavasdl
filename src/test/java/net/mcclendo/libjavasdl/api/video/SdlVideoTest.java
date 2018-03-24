package net.mcclendo.libjavasdl.api.video;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;
import net.mcclendo.libjavasdl.api.rect.SDL_Rect;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;

@SuppressWarnings("checkstyle:MagicNumber")
public final class SdlVideoTest {

    @Test
    public void getNumVideoDrivers() {
        Sdl.SDL_Init(0);

        Assert.assertTrue(SdlVideo.SDL_GetNumVideoDrivers() > 0);

        Sdl.SDL_Quit();
    }

    @Test
    public void getVideoDriver() {
        Sdl.SDL_Init(0);

        Assert.assertNotNull(SdlVideo.SDL_GetVideoDriver(0));

        Sdl.SDL_Quit();
    }

    @Test
    public void videoInit() {
        Sdl.SDL_Init(0);

        Assert.assertEquals(0, SdlVideo.SDL_VideoInit(SdlVideo.SDL_GetVideoDriver(0)));
        SdlVideo.SDL_VideoQuit();

        Sdl.SDL_Quit();
    }

    @Test
    public void getCurrentVideoDriver() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        Assert.assertNotNull(SdlVideo.SDL_GetCurrentVideoDriver());

        Sdl.SDL_Quit();
    }

    @Test
    public void getNumVideoDisplays() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);
        Assert.assertTrue(SdlVideo.SDL_GetNumVideoDisplays() > 0);
        Sdl.SDL_Quit();
    }

    @Test
    public void getDisplayName() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);
        Assert.assertNotNull(SdlVideo.SDL_GetDisplayName(0));
        Sdl.SDL_Quit();
    }

    @Test
    public void getDisplayBounds() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Rect rect = new SDL_Rect();
        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetDisplayBounds(
                        0,
                        rect));
        Assert.assertTrue(rect.w != 0);
        Assert.assertTrue(rect.h != 0);

        Sdl.SDL_Quit();
    }

    @Test
    public void getDisplayDPI() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final FloatByReference ddpi = new FloatByReference();
        final FloatByReference hdpi = new FloatByReference();
        final FloatByReference vdpi = new FloatByReference();

        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetDisplayDPI(
                        0,
                        ddpi,
                        hdpi,
                        vdpi));
        Assert.assertTrue(ddpi.getValue() != 0);
        Assert.assertTrue(hdpi.getValue() != 0);
        Assert.assertTrue(vdpi.getValue() != 0);

        Sdl.SDL_Quit();
    }

    @Test
    public void getDisplayUsableBounds() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Rect rect = new SDL_Rect();
        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetDisplayUsableBounds(
                        0,
                        rect));
        Assert.assertTrue(rect.w != 0);
        Assert.assertTrue(rect.h != 0);

        Sdl.SDL_Quit();
    }

    @Test
    public void getNumDisplayModes() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        Assert.assertNotEquals(
                0,
                SdlVideo.SDL_GetNumDisplayModes(0));

        Sdl.SDL_Quit();
    }

    @Test
    public void getDisplayMode() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_DisplayMode displayMode = new SDL_DisplayMode();
        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetDisplayMode(
                        0,
                        0,
                        displayMode));
        Assert.assertTrue(displayMode.w != 0);
        Assert.assertTrue(displayMode.h != 0);

        Sdl.SDL_Quit();
    }

    @Test
    public void getDesktopDisplayMode() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_DisplayMode displayMode = new SDL_DisplayMode();
        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetDesktopDisplayMode(
                        0,
                        displayMode));
        Assert.assertTrue(displayMode.w != 0);
        Assert.assertTrue(displayMode.h != 0);

        Sdl.SDL_Quit();
    }

    @Test
    public void getCurrentDisplayMode() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_DisplayMode displayMode = new SDL_DisplayMode();
        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetCurrentDisplayMode(
                        0,
                        displayMode));
        Assert.assertTrue(displayMode.w != 0);
        Assert.assertTrue(displayMode.h != 0);

        Sdl.SDL_Quit();
    }

    @Test
    public void getClosestDisplayMode() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_DisplayMode displayMode = new SDL_DisplayMode();
        displayMode.w = 640;
        displayMode.h = 480;
        final SDL_DisplayMode closest = new SDL_DisplayMode();
        Assert.assertNotNull(
                SdlVideo.SDL_GetClosestDisplayMode(
                        0,
                        displayMode,
                        closest));

        Sdl.SDL_Quit();
    }

    @Test
    public void getWindowDisplayIndex() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);
        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetWindowDisplayIndex(
                        window));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void setWindowDisplayMode() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);

        final SDL_DisplayMode displayMode = new SDL_DisplayMode();
        displayMode.w = 800;
        displayMode.h = 600;
        final SDL_DisplayMode closest = new SDL_DisplayMode();
        Assert.assertNotNull(
                SdlVideo.SDL_GetClosestDisplayMode(
                        0,
                        displayMode,
                        closest));

        Assert.assertNotNull(window);
        Assert.assertEquals(
                0,
                SdlVideo.SDL_SetWindowDisplayMode(
                        window,
                        closest));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void getWindowDisplayMode() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);

        final SDL_DisplayMode mode = new SDL_DisplayMode();

        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetWindowDisplayMode(
                        window,
                        mode));
        Assert.assertTrue(mode.w != 0);
        Assert.assertTrue(mode.h != 0);

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void getWindowPixelFormat() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);
        Assert.assertNotEquals(
                0,
                SdlVideo.SDL_GetWindowPixelFormat(
                        window));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void getWindowID() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);
        Assert.assertNotEquals(
                0,
                SdlVideo.SDL_GetWindowID(
                        window));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void getWindowFromID() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);
        Assert.assertEquals(
                window.getPointer().share(0),
                SdlVideo.SDL_GetWindowFromID(
                        SdlVideo.SDL_GetWindowID(
                                window)).getPointer().share(0));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }


    @Test
    public void getWindowFlags() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);
        Assert.assertTrue(
                SdlVideo.SDL_GetWindowFlags(window) >= 0);

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void setWindowTitle() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);
        SdlVideo.SDL_SetWindowTitle(
                window,
                UUID.randomUUID().toString());

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void getWindowTitle() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);
        Assert.assertEquals(
                windowTitle,
                SdlVideo.SDL_GetWindowTitle(
                        window));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void windowData() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);

        Assert.assertEquals(Pointer.NULL, SdlVideo.SDL_GetWindowData(window, windowTitle));
        SdlVideo.SDL_SetWindowData(
                window,
                windowTitle,
                window.getPointer());
        Assert.assertEquals(window.getPointer(), SdlVideo.SDL_GetWindowData(window, windowTitle));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void windowPosition() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);

        final IntByReference x = new IntByReference();
        final IntByReference y = new IntByReference();
        SdlVideo.SDL_GetWindowPosition(
                window,
                x,
                y);
        Assert.assertEquals(0, x.getValue());
        Assert.assertEquals(0, y.getValue());

        SdlVideo.SDL_SetWindowPosition(
                window,
                16,
                16);

        SdlVideo.SDL_GetWindowPosition(
                window,
                x,
                y);
        Assert.assertEquals(16, x.getValue());
        Assert.assertEquals(16, y.getValue());

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void windowSize() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);

        final IntByReference x = new IntByReference();
        final IntByReference y = new IntByReference();
        SdlVideo.SDL_GetWindowSize(
                window,
                x,
                y);
        Assert.assertEquals(640, x.getValue());
        Assert.assertEquals(480, y.getValue());

        SdlVideo.SDL_SetWindowSize(
                window,
                16,
                16);

        SdlVideo.SDL_GetWindowSize(
                window,
                x,
                y);
        Assert.assertEquals(16, x.getValue());
        Assert.assertEquals(16, y.getValue());

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void boarders() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);

        final IntByReference top = new IntByReference();
        final IntByReference left = new IntByReference();
        final IntByReference bottom = new IntByReference();
        final IntByReference right = new IntByReference();
        SdlVideo.SDL_GetWindowBordersSize(
                window,
                top,
                left,
                bottom,
                right);
        Assert.assertNotEquals(0, top.getValue());
        Assert.assertNotEquals(0, left.getValue());
        Assert.assertNotEquals(0, bottom.getValue());
        Assert.assertNotEquals(0, right.getValue());

        SdlVideo.SDL_SetWindowBordered(window, false);
        SdlVideo.SDL_GetWindowBordersSize(
                window,
                top,
                left,
                bottom,
                right);
        Assert.assertEquals(0, top.getValue());
        Assert.assertEquals(0, left.getValue());
        Assert.assertEquals(0, bottom.getValue());
        Assert.assertEquals(0, right.getValue());

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void minimumWindowSize() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);

        final IntByReference x = new IntByReference();
        final IntByReference y = new IntByReference();
        SdlVideo.SDL_GetWindowMinimumSize(
                window,
                x,
                y);
        Assert.assertEquals(0, x.getValue());
        Assert.assertEquals(0, y.getValue());

        SdlVideo.SDL_SetWindowMinimumSize(
                window,
                16,
                16);

        SdlVideo.SDL_GetWindowMinimumSize(
                window,
                x,
                y);
        Assert.assertEquals(16, x.getValue());
        Assert.assertEquals(16, y.getValue());

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void maximumWindowSize() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);

        final IntByReference x = new IntByReference();
        final IntByReference y = new IntByReference();
        SdlVideo.SDL_GetWindowMaximumSize(
                window,
                x,
                y);
        Assert.assertEquals(0, x.getValue());
        Assert.assertEquals(0, y.getValue());

        SdlVideo.SDL_SetWindowMaximumSize(
                window,
                1024,
                1024);

        SdlVideo.SDL_GetWindowMaximumSize(
                window,
                x,
                y);
        Assert.assertEquals(1024, x.getValue());
        Assert.assertEquals(1024, y.getValue());

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void resize() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);

        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_RESIZABLE) == 0);
        SdlVideo.SDL_SetWindowResizable(
                window,
                true);
        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_RESIZABLE) != 0);

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void hidingWindows() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                SdlVideo.SDL_WINDOW_HIDDEN);

        Assert.assertNotNull(window);

        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_HIDDEN) != 0);
        SdlVideo.SDL_ShowWindow(
                window);
        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_HIDDEN) == 0);
        SdlVideo.SDL_HideWindow(
                window);
        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_HIDDEN) != 0);

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void minMaxWindows() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                SdlVideo.SDL_WINDOW_MAXIMIZED);

        Assert.assertNotNull(window);

        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_MAXIMIZED) != 0);
        SdlVideo.SDL_MinimizeWindow(
                window);
        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_MAXIMIZED) == 0);
        SdlVideo.SDL_MaximizeWindow(
                window);
        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_MAXIMIZED) != 0);
        SdlVideo.SDL_RaiseWindow(
                window);
        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_INPUT_FOCUS) != 0);
        SdlVideo.SDL_SetWindowInputFocus(window);

        SdlVideo.SDL_RestoreWindow(
                window);

        Assert.assertEquals(
                0,
                SdlVideo.SDL_SetWindowFullscreen(
                        window,
                        SdlVideo.SDL_WINDOW_FULLSCREEN));
        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_FULLSCREEN) != 0);
        Assert.assertEquals(
                0,
                SdlVideo.SDL_SetWindowFullscreen(
                        window,
                        0));
        Assert.assertTrue((SdlVideo.SDL_GetWindowFlags(window) & SdlVideo.SDL_WINDOW_FULLSCREEN) == 0);

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void windowSurface() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);

        Assert.assertNotNull(window);
        Assert.assertNotNull(SdlVideo.SDL_GetWindowSurface(window));
        Assert.assertEquals(0, SdlVideo.SDL_UpdateWindowSurface(window));

        final SDL_Rect[] rects = (SDL_Rect[]) new SDL_Rect().toArray(2);
        rects[0].w = 1;
        rects[0].h = 1;
        rects[0].x = 0;
        rects[0].y = 0;

        rects[1].w = 1;
        rects[1].h = 1;
        rects[1].x = 4;
        rects[1].y = 4;

        Assert.assertEquals(
                0,
                SdlVideo.SDL_UpdateWindowSurfaceRects(
                        window,
                        rects[0].getPointer(),
                        2));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void windowGrab() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                SdlVideo.SDL_WINDOW_INPUT_GRABBED);

        Assert.assertNotNull(window);
        Assert.assertTrue(SdlVideo.SDL_GetWindowGrab(window));
        Assert.assertEquals(
                window.getPointer(),
                SdlVideo.SDL_GetGrabbedWindow().getPointer());
        SdlVideo.SDL_SetWindowGrab(
                window,
                false);
        Assert.assertFalse(SdlVideo.SDL_GetWindowGrab(window));
        Assert.assertNull(
                SdlVideo.SDL_GetGrabbedWindow());

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void windowBrightness() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);
        Assert.assertNotNull(window);
        Assert.assertTrue(SdlVideo.SDL_GetWindowBrightness(window) == 1f);
        Assert.assertEquals(
                0,
                SdlVideo.SDL_SetWindowBrightness(
                        window,
                        0.5f));
        Assert.assertTrue(SdlVideo.SDL_GetWindowBrightness(window) == 0.5f);

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void windowOpacity() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final String windowTitle = UUID.randomUUID().toString();

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                windowTitle,
                0,
                0,
                640,
                480,
                0);
        Assert.assertNotNull(window);

        final FloatByReference opacity = new FloatByReference();
        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetWindowOpacity(
                        window,
                        opacity));
        Assert.assertEquals(1, opacity.getValue(), .01f);
        Assert.assertEquals(
                0,
                SdlVideo.SDL_SetWindowOpacity(
                        window,
                        0.5f));
        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetWindowOpacity(
                        window,
                        opacity));
        Assert.assertEquals(0.5f, opacity.getValue(), .01f);

        Assert.assertEquals(
                0,
                SdlVideo.SDL_SetWindowBrightness(
                        window,
                        0.5f));
        Assert.assertTrue(SdlVideo.SDL_GetWindowBrightness(window) == 0.5f);

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void windowModal() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window parentWindow = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);
        Assert.assertNotNull(parentWindow);

        final SDL_Window modalWindow = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);
        Assert.assertNotNull(modalWindow);

        SdlVideo.SDL_SetWindowModalFor(modalWindow, parentWindow);

        SdlVideo.SDL_DestroyWindow(modalWindow);
        SdlVideo.SDL_DestroyWindow(parentWindow);

        Sdl.SDL_Quit();
    }

    @Test
    public void gammaRamp() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);
        Assert.assertNotNull(window);

        final Pointer r = new Memory(2 * 256);
        final Pointer g = new Memory(2 * 256);
        final Pointer b = new Memory(2 * 256);

        Assert.assertEquals(
                0,
                SdlVideo.SDL_GetWindowGammaRamp(
                        window,
                        r,
                        g,
                        b));

        Assert.assertEquals(
                0,
                SdlVideo.SDL_SetWindowGammaRamp(
                        window,
                        r,
                        g,
                        b));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void hitTest() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);
        Assert.assertNotNull(window);

        Assert.assertEquals(
                0,
                SdlVideo.SDL_SetWindowHitTest(
                        window,
                        (w, a, d) -> SdlVideo.SDL_HITTEST_NORMAL,
                        Pointer.NULL));

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }

    @Test
    public void screensaver() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);

        final SDL_Window window = SdlVideo.SDL_CreateWindow(
                UUID.randomUUID().toString(),
                0,
                0,
                640,
                480,
                0);
        Assert.assertNotNull(window);

        SdlVideo.SDL_DisableScreenSaver();
        Assert.assertFalse(SdlVideo.SDL_IsScreenSaverEnabled());
        SdlVideo.SDL_EnableScreenSaver();
        Assert.assertTrue(SdlVideo.SDL_IsScreenSaverEnabled());

        SdlVideo.SDL_DestroyWindow(window);

        Sdl.SDL_Quit();
    }
}
