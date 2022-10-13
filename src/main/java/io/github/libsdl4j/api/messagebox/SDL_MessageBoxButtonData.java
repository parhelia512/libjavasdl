package io.github.libsdl4j.api.messagebox;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Individual button data.
 */
@Structure.FieldOrder({
        "flags",
        "buttonid",
        "text"
})
public final class SDL_MessageBoxButtonData extends Structure {

    /** {@link SDL_MessageBoxButtonFlags} */
    @MagicConstant(flagsFromClass = SDL_MessageBoxButtonFlags.class)
    public int flags;

    /** User defined button id (value returned via SDL_ShowMessageBox) */
    public int buttonid;

    /** The UTF-8 button text */
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
