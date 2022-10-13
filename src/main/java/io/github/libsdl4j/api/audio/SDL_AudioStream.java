package io.github.libsdl4j.api.audio;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * <p>SDL_AudioStream is a new audio conversion interface.</p>
 *
 * <p>The benefits vs SDL_AudioCVT:</p>
 * <ul>
 *     <li>it can handle resampling data in chunks without generating
 *         artifacts, when it doesn't have the complete buffer available.</li>
 *     <li>it can handle incoming data in any variable size.</li>
 *     <li>You push data as you have it, and pull it when you need it</li>
 * </ul>
 *
 * <p>This is opaque to the outside world.</p>
 */
public final class SDL_AudioStream extends PointerType {

    /**
     * The default constructor wraps a NULL pointer.
     */
    public SDL_AudioStream() {
        super();
    }

    /**
     * This constructor is typically used by {@link #fromNative} if generating
     * a new object instance.
     *
     * @param p Native pointer to be wrapped
     */
    public SDL_AudioStream(Pointer p) {
        super(p);
    }
}
