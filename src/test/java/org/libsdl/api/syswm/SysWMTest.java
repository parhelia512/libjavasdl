package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.libsdl.api.render.SDL_Renderer;
import org.libsdl.api.version.SDL_version;
import org.libsdl.api.video.SDL_Window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.libsdl.api.Sdl.SDL_InitSubSystem;
import static org.libsdl.api.Sdl.SDL_QuitSubSystem;
import static org.libsdl.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static org.libsdl.api.error.SdlError.SDL_GetError;
import static org.libsdl.api.render.SDL_RendererFlags.SDL_RENDERER_ACCELERATED;
import static org.libsdl.api.render.SdlRender.SDL_CreateRenderer;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_WINDOWS;
import static org.libsdl.api.syswm.SdlSysWM.SDL_GetWindowWMInfo;
import static org.libsdl.api.version.SdlVersion.SDL_GetVersion;
import static org.libsdl.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static org.libsdl.api.video.SdlVideo.SDL_CreateWindow;
import static org.libsdl.api.video.SdlVideo.SDL_DestroyWindow;
import static org.libsdl.api.video.SdlVideo.SDL_GetWindowPosition;
import static org.libsdl.api.video.SdlVideo.SDL_GetWindowSize;

public class SysWMTest {

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_VIDEO);
    }

    @Test
    public void getWindowInfo() throws InterruptedException {
        SDL_Window window = SDL_CreateWindow("Test window", 200, 250, 400, 300, SDL_WINDOW_SHOWN);
        if (window == null) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }
        IntByReference widthHolder = new IntByReference();
        IntByReference heightHolder = new IntByReference();
        SDL_GetWindowSize(window, widthHolder, heightHolder);
        SDL_Renderer renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
        if (renderer == null) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }

        Thread.sleep(1000L);
        System.out.println("Window " + widthHolder.getValue() + " x " + heightHolder.getValue());
        assertEquals(400, widthHolder.getValue());
        assertEquals(300, heightHolder.getValue());

        SDL_version version = new SDL_version();
        SDL_GetVersion(version);
        SDL_SysWMInfo wmInfo = new SDL_SysWMInfo(version);
        boolean result = SDL_GetWindowWMInfo(window, wmInfo);
        if (!result) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }
        System.out.println("Subsystem: " + SDL_SYSWM_TYPE.toString(wmInfo.subsystem));
        if (wmInfo.subsystem == SDL_SYSWM_WINDOWS) {
            testGetWindowInfoOnWindows(window, wmInfo);
        }
        // TODO: Test other platforms as well
        SDL_DestroyWindow(window);
    }

    private void testGetWindowInfoOnWindows(SDL_Window window, SDL_SysWMInfo wmInfo) {
        System.out.printf("Windows HWND: %1$s%n", wmInfo.info.win.window);

        Pointer hwnd = wmInfo.info.win.window;
        WinDef.HWND hwnd2 = new WinDef.HWND(hwnd);
        WinDef.HWND HWND_TOP = new WinDef.HWND(new Pointer(0L));
        User32.INSTANCE.SetWindowPos(hwnd2, HWND_TOP, 10, 20, 50, 60, 0);

        IntByReference leftHolder = new IntByReference();
        IntByReference topHolder = new IntByReference();
        SDL_GetWindowPosition(window, leftHolder, topHolder);
        assertTrue(leftHolder.getValue() < 100 && leftHolder.getValue() > 5);
        assertTrue(topHolder.getValue() < 100 && topHolder.getValue() > 5);
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_VIDEO);
    }
}
