package io.github.libsdl4j.api.metal;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * A handle to a CAMetalLayer-backed NSView (macOS) or UIView (iOS/tvOS).
 *
 * <p><b>Note:</b> This can be cast directly to an NSView or UIView.</p>
 */
public final class SDL_MetalView extends PointerType {

    /**
     * The default constructor wraps a null pointer.
     */
    public SDL_MetalView() {
    }

    /**
     * This constructor is typically used by {@link #fromNative} if generating
     * a new object instance.
     */
    public SDL_MetalView(Pointer p) {
        super(p);
    }
}
