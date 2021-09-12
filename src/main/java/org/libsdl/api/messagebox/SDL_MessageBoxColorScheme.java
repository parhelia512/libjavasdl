package org.libsdl.api.messagebox;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_MAX;

@Structure.FieldOrder({
        "colors"
})
public class SDL_MessageBoxColorScheme extends Structure implements Structure.ByReference {

    public SDL_MessageBoxColor[] colors = new SDL_MessageBoxColor[SDL_MESSAGEBOX_COLOR_MAX];

    public SDL_MessageBoxColorScheme() {
    }

    public SDL_MessageBoxColorScheme(Pointer p) {
        super(p);
    }

    public void setColorFor(
            @MagicConstant(valuesFromClass = SDL_MessageBoxColorType.class) int key,
            SDL_MessageBoxColor value) {
        colors[key] = value;
    }

    public void setColorFor(
            @MagicConstant(valuesFromClass = SDL_MessageBoxColorType.class) int key,
            int red,
            int green,
            int blue) {
        colors[key] = new SDL_MessageBoxColor(red, green, blue);
    }
}
