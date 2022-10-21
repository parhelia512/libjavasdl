package io.github.libsdl4j.api.video;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import io.github.libsdl4j.api.rect.SDL_Point;
import org.intellij.lang.annotations.MagicConstant;

/**
 * <p><b>Warning:</b> It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.</p>
 *
 * <p>In case you did not keep the reference you would encounter an error like this:</p>
 * <p><code>JNA: callback object has been garbage collected</code></p>
 */
@FunctionalInterface
public interface SDL_HitTest extends Callback {

    /**
     * Callback used for hit-testing.
     *
     * @param win  the SDL_Window where hit-testing was set on.
     * @param area a Pointer to an SDL_Point which should be hit-tested. Use {@code new }{@link SDL_Point#SDL_Point(Pointer) SDL_Point(Pointer)} to get the actual SDL_Point.
     * @param data what was passed as {@code callbackData} to SDL_SetWindowHitTest().
     * @return an SDL_HitTestResult value.
     * @see SdlVideo#SDL_SetWindowHitTest(SDL_Window, SDL_HitTest, Pointer)
     */
    @MagicConstant(valuesFromClass = SDL_HitTestResult.class)
    int testHit(
            SDL_Window win,
            Pointer area,
            Pointer data);
}
