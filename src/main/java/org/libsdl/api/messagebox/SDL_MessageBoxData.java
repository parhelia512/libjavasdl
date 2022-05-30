package org.libsdl.api.messagebox;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.JnaStructure;
import org.libsdl.jna.JnaUtils;

@Structure.FieldOrder({
        "flags",
        "window",
        "title",
        "message",
        "numbuttons",
        "buttons",
        "colorScheme"
})
public class SDL_MessageBoxData extends JnaStructure {

    @MagicConstant(flagsFromClass = SDL_MessageBoxFlags.class)
    public int flags;
    public SDL_Window window;
    public String title;
    public String message;
    public int numbuttons;
    public Pointer buttons;
    public SDL_MessageBoxColorScheme colorScheme;

    public SDL_MessageBoxData() {
    }

    public SDL_MessageBoxData(Pointer p) {
        super(p);
    }

    public void setButtons(SDL_MessageBoxButtonData[] buttonsArray) {
        buttons = JnaUtils.writeArrayToNativeMemory(buttonsArray);
        numbuttons = buttonsArray.length;
    }
}
