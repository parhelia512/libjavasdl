package org.libsdl.api.shape;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.shape.WindowShapeMode.ShapeModeBinarizeAlpha;
import static org.libsdl.api.shape.WindowShapeMode.ShapeModeColorKey;
import static org.libsdl.api.shape.WindowShapeMode.ShapeModeDefault;
import static org.libsdl.api.shape.WindowShapeMode.ShapeModeReverseBinarizeAlpha;

@Structure.FieldOrder({
        "mode",
        "parameters"
})
public final class SDL_WindowShapeMode extends Structure {

    @MagicConstant(valuesFromClass = WindowShapeMode.class)
    public int mode;
    public SDL_WindowShapeParams parameters;

    public SDL_WindowShapeMode() {
    }

    public SDL_WindowShapeMode(Pointer p) {
        super(p);
    }

    /**
     * Reads the fields of the struct from native memory
     */
    @Override
    public void read() {
        readField("mode");
        switch (mode) {
            case ShapeModeDefault:
            case ShapeModeBinarizeAlpha:
            case ShapeModeReverseBinarizeAlpha:
                parameters.setType("binarizationCutoff");
                break;
            case ShapeModeColorKey:
                parameters.setType("colorKey");
                break;
            default:
                throw new IllegalStateException("Unknown mode " + mode);
        }
        super.read();
    }
}
