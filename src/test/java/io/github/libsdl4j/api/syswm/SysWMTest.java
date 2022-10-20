package io.github.libsdl4j.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.api.render.SDL_Renderer;
import io.github.libsdl4j.api.version.SDL_version;
import io.github.libsdl4j.api.video.SDL_Window;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.Sdl.SDL_InitSubSystem;
import static io.github.libsdl4j.api.Sdl.SDL_QuitSubSystem;
import static io.github.libsdl4j.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static io.github.libsdl4j.api.error.SdlError.SDL_GetError;
import static io.github.libsdl4j.api.render.SDL_RendererFlags.SDL_RENDERER_ACCELERATED;
import static io.github.libsdl4j.api.render.SdlRender.SDL_CreateRenderer;
import static io.github.libsdl4j.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_WINDOWS;
import static io.github.libsdl4j.api.syswm.SdlSysWM.SDL_GetWindowWMInfo;
import static io.github.libsdl4j.api.version.SdlVersion.SDL_GetJavaBindingsVersion;
import static io.github.libsdl4j.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_CreateWindow;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_DestroyWindow;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_GetWindowPosition;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_GetWindowSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        SDL_version version = SDL_GetJavaBindingsVersion();
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
