package io.github.libsdl4j.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * A structure that contains pixel format information.
 *
 * <p>A pixel format has either a palette or masks. If a palette is used,
 * then rMask, gMask, bMask, and aMask will be 0.</p>
 *
 * The data types used to represent pixels are as follows:
 *
 * <table>
 *     <caption>Pixel datatypes</caption>
 *     <tr>
 *         <th>Bytes Per Pixel</th>
 *         <th>Related Data Types</th>
 *     </tr>
 *     <tr>
 *         <td>1</td>
 *         <td>byte (Uint8)</td>
 *     </tr>
 *     <tr>
 *         <td>2</td>
 *         <td>short (Unit16)</td>
 *     </tr>
 *     <tr>
 *         <td>3</td>
 *         <td>3×byte (3×Uint8)</td>
 *     </tr>
 *     <tr>
 *         <td>4</td>
 *         <td>int (Uint32)</td>
 *     </tr>
 * </table>
 *
 * <p>An {@code SDL_PixelFormat} describes the format of the pixel data stored
 * at the {@code pixels} property of an {@link io.github.libsdl4j.api.surface.SDL_Surface SDL_Surface}.
 * Every surface stores an {@code SDL_PixelFormat} in the {@code format} property.</p>
 *
 * <p>If you wish to do pixel level modifications on a surface,
 * then understanding how SDL stores its color information is essential.</p>
 *
 * <p><b>Note:</b> Everything in the pixel format structure is read-only.</p>
 *
 * <p><b>Implementation note:</b> {@code SDL_SDL_PixelFormat} would normally be implemented as a JNA {@link Structure}
 * but the SDL internals keep references to all allocated {@code SDL_PixelFormat}s
 * and change their internal fields via various functions. Thus it is implemented as
 * an opaque Pointer and there is a co-located {@link SDL_PixelFormat_internal}
 * which allows a read-only access to the fields.</p>
 */
public final class SDL_PixelFormat extends PointerType {

    private SDL_PixelFormat_internal semanticStruct;

    public SDL_PixelFormat() {
    }

    public SDL_PixelFormat(Pointer p) {
        super(p);
    }

    @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class)
    public int getFormat() {
        return (Integer) readField("format");
    }

    public SDL_Palette getPalette() {
        return (SDL_Palette) readField("palette");
    }

    public byte getBitsPerPixel() {
        return (Byte) readField("bitsPerPixel");
    }

    public byte getBytesPerPixel() {
        return (Byte) readField("bytesPerPixel");
    }

    public int getRMask() {
        return (Integer) readField("rMask");
    }

    public int getGMask() {
        return (Integer) readField("gMask");
    }

    public int getBMask() {
        return (Integer) readField("bMask");
    }

    public int getAMask() {
        return (Integer) readField("aMask");
    }

    public byte getRLoss() {
        return (Byte) readField("rLoss");
    }

    public byte getGLoss() {
        return (Byte) readField("gLoss");
    }

    public byte getBLoss() {
        return (Byte) readField("bLoss");
    }

    public byte getALoss() {
        return (Byte) readField("aLoss");
    }

    public byte getRShift() {
        return (Byte) readField("rShift");
    }

    public byte getGShift() {
        return (Byte) readField("gShift");
    }

    public byte getBShift() {
        return (Byte) readField("bShift");
    }

    public byte getAShift() {
        return (Byte) readField("aShift");
    }

    private Object readField(String name) {
        if (semanticStruct == null) {
            semanticStruct = new SDL_PixelFormat_internal(getPointer());
        }
        return semanticStruct.readField(name);
    }
}
