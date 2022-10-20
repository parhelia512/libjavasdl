package io.github.libsdl4j.api.shape;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.pixels.SDL_Color;
import org.intellij.lang.annotations.MagicConstant;

/**
 * A struct that tags the SDL_WindowShapeParams union with an enum describing the type of its contents.
 */
@Structure.FieldOrder({
        "mode",
        "binarizationCutoffOrRed",
        "g",
        "b",
        "a"
})
public final class SDL_WindowShapeMode extends Structure {

    public SDL_WindowShapeMode() {
    }

    public SDL_WindowShapeMode(Pointer p) {
        super(p);
    }

    /** The mode of these window-shape parameters. */
    @MagicConstant(valuesFromClass = WindowShapeMode.class)
    public int mode;

    /** A cutoff alpha value for binarization of the window shape's alpha channel. */
    public byte binarizationCutoffOrRed;
    public byte g;
    public byte b;
    public byte a;

    public int getMode() {
        return mode;
    }

    public void setMode(
            @MagicConstant(valuesFromClass = WindowShapeMode.class) int mode) {
        this.mode = mode;
    }

    public byte getBinarizationCutoff() {
        return binarizationCutoffOrRed;
    }

    public void setBinarizationCutoff(
            byte newValue) {
        this.binarizationCutoffOrRed = newValue;
    }

    public SDL_Color getColorKey() {
        return new SDL_Color(binarizationCutoffOrRed, g, b, a);
    }

    public void setColorKey(
            SDL_Color newValue) {
        this.binarizationCutoffOrRed = newValue.r;
        this.g = newValue.g;
        this.b = newValue.b;
        this.a = newValue.a;
    }
}
