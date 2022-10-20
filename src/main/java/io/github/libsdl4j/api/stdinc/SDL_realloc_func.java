package io.github.libsdl4j.api.stdinc;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import io.github.libsdl4j.jna.size_t;

/**
 * <p><b>Warning:</b> It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.</p>
 *
 * <p>In case you did not keep the reference you would encounter an error like this:</p>
 * <p><code>JNA: callback object has been garbage collected</code></p>
 */
@FunctionalInterface
public interface SDL_realloc_func extends Callback {

    Pointer SDL_realloc(
            Pointer mem,
            size_t size);
}
