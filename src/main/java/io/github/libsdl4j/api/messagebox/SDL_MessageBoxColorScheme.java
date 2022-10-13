package io.github.libsdl4j.api.messagebox;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * A set of colors to use for message box dialogs
 */
@Structure.FieldOrder({
        "colors"
})
public final class SDL_MessageBoxColorScheme extends Structure implements Structure.ByReference {

    public static final int SDL_MESSAGEBOX_COLOR_MAX = 5;

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
