package io.github.libsdl4j.api.timer;

import java.util.concurrent.atomic.AtomicInteger;
import com.sun.jna.Pointer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static io.github.libsdl4j.api.Sdl.SDL_InitSubSystem;
import static io.github.libsdl4j.api.Sdl.SDL_QuitSubSystem;
import static io.github.libsdl4j.api.SdlSubSystemConst.SDL_INIT_TIMER;
import static io.github.libsdl4j.api.SdlTest.assertNoMemoryLeak;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static io.github.libsdl4j.api.timer.SdlTimer.SDL_AddTimer;
import static io.github.libsdl4j.api.timer.SdlTimer.SDL_GetTicks;
import static io.github.libsdl4j.api.timer.SdlTimer.SDL_RemoveTimer;

public class TimerTest {

    private int numOfAllocationsBefore;

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_TIMER);
        numOfAllocationsBefore = SDL_GetNumAllocations();
    }

    @Test
    public void getTicksShouldReportTimeInMilliseconds() throws InterruptedException {
        int time1 = SDL_GetTicks();
        Thread.sleep(2500L);
        int time2 = SDL_GetTicks();
        assertTrue(time2 - 2500L >= time1);
        assertTrue(time2 - 4500L < time1);
        assertNoMemoryLeak(numOfAllocationsBefore);
    }

    @Test
    public void timerShouldTriggerCallback() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        SDL_TimerCallback callbackHolder = (interval, param) -> {
            counter.incrementAndGet();
            return interval;
        };
        SDL_TimerID timerID = SDL_AddTimer(1000, callbackHolder, Pointer.NULL);
        SDL_TimerID timerID2 = SDL_AddTimer(1000, callbackHolder, Pointer.NULL);
        Thread.sleep(3500L);

        boolean result = SDL_RemoveTimer(timerID);
        assertTrue(result);
        boolean result2 = SDL_RemoveTimer(timerID2);
        assertTrue(result2);
        Thread.sleep(2000L);

        assertEquals(6, counter.get());
        // TODO: Report the leak to SDL authors and enable the assert after it is fix in the native library
        // assertNoMemoryLeak(numOfAllocationsBefore);
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_TIMER);
    }
}
