package org.libsdl.api.messagebox;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

@Structure.FieldOrder({
        "flags",
        "buttonid",
        "text"
})
public final class SDL_MessageBoxButtonData extends Structure {

    @MagicConstant(flagsFromClass = SDL_MessageBoxButtonFlags.class)
    public int flags;
    public int buttonid;
    public String text;

    public SDL_MessageBoxButtonData() {
    }

    public SDL_MessageBoxButtonData(Pointer p) {
        super(p);
    }

    public SDL_MessageBoxButtonData(
            @MagicConstant(flagsFromClass = SDL_MessageBoxButtonFlags.class) int flags,
            int buttonid,
            String text) {
        this.flags = flags;
        this.buttonid = buttonid;
        this.text = text;
    }
}
