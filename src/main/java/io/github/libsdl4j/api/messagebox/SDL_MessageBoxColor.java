package io.github.libsdl4j.api.messagebox;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * RGB value used in a message box color scheme
 */
@Structure.FieldOrder({
        "r",
        "g",
        "b"
})
public final class SDL_MessageBoxColor extends Structure implements Structure.ByValue {

    public byte r;
    public byte g;
    public byte b;

    public SDL_MessageBoxColor() {
    }

    public SDL_MessageBoxColor(Pointer p) {
        super(p);
    }

    public SDL_MessageBoxColor(int r, int g, int b) {
        this.r = (byte) r;
        this.g = (byte) g;
        this.b = (byte) b;
    }

    public SDL_MessageBoxColor(byte r, byte g, byte b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
