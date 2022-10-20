package io.github.libsdl4j.api.messagebox;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.jna.ContiguousArrayList;
import org.intellij.lang.annotations.MagicConstant;

/**
 * MessageBox structure containing title, text, window, etc.
 */
@Structure.FieldOrder({
        "flags",
        "window",
        "title",
        "message",
        "numbuttons",
        "buttons",
        "colorScheme"
})
public final class SDL_MessageBoxData extends Structure {

    /** {@link SDL_MessageBoxFlags} */
    @MagicConstant(flagsFromClass = SDL_MessageBoxFlags.class)
    public int flags;

    /** Parent window, can be null */
    public SDL_Window window;

    /** UTF-8 title */
    public String title;

    /** UTF-8 message text */
    public String message;

    public int numbuttons;

    public Pointer buttons;

    /** {@link SDL_MessageBoxColorScheme}, can be null to use system settings */
    public SDL_MessageBoxColorScheme colorScheme;

    public SDL_MessageBoxData() {
    }

    public SDL_MessageBoxData(Pointer p) {
        super(p);
    }

    public void setButtons(ContiguousArrayList<SDL_MessageBoxButtonData> buttonsArray) {
        numbuttons = buttonsArray.size();
        buttons = buttonsArray.autoWriteAndGetPointer();
    }
}
