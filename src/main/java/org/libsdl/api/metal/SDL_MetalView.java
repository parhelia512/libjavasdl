package org.libsdl.api.metal;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * A handle to a CAMetalLayer-backed NSView (macOS) or UIView (iOS/tvOS).
 *
 * @apiNote This can be cast directly to an NSView or UIView.
 */
public final class SDL_MetalView extends PointerType {

    /**
     * The default constructor wraps a NULL pointer.
     */
    public SDL_MetalView() {
    }

    /**
     * This constructor is typically used by {@link #fromNative} if generating
     * a new object instance.
     *
     * @param p
     */
    public SDL_MetalView(Pointer p) {
        super(p);
    }
}
