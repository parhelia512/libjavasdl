package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "x",
        "y",
        "w",
        "h"
})
public final class SDL_Rect extends Structure {

    public int x;
    public int y;
    public int w;
    public int h;

    public SDL_Rect() {
    }

    public SDL_Rect(Pointer p) {
        super(p);
    }

    /**
     * Set the memory used by this structure.  This method is used to
     * indicate the given structure is based on natively-allocated data,
     * nested within another, or otherwise overlaid on existing memory and
     * thus does not own its own memory allocation.
     *
     * @param m      Base memory to use to back this structure.
     * @param offset offset into provided memory where structure mapping
     */
    @Override
    public void useMemory(Pointer m, int offset) {
        super.useMemory(m, offset);
    }
}
