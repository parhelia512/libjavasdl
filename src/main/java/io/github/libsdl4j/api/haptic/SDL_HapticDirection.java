package io.github.libsdl4j.api.haptic;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * <p>Structure that represents a haptic direction.</p>
 *
 * <p>This is the direction where the force comes from,
 * instead of the direction in which the force is exerted.</p>
 *
 * <p>Directions can be specified by:</p>
 * <ul>
 *     <li>{@code SDL_HAPTIC_POLAR} : Specified by polar coordinates.</li>
 *     <li>{@code SDL_HAPTIC_CARTESIAN} : Specified by cartesian coordinates.</li>
 *     <li>{@code SDL_HAPTIC_SPHERICAL} : Specified by spherical coordinates.</li>
 * </ul>
 *
 * <p>Cardinal directions of the haptic device are relative to the positioning
 *  of the device. North is considered to be away from the user.</p>
 *
 * <p>The following diagram represents the cardinal directions:</p>
 * <pre>
 *               .--.
 *               |__| .-------.
 *               |=.| |.-----.|
 *               |--| ||     ||
 *               |  | |'-----'|
 *               |__|~')_____('
 *                 [ COMPUTER ]
 *
 *
 *                   North (0,-1)
 *                       ^
 *                       |
 *                       |
 * (-1,0)  West &lt;----[ HAPTIC ]----&gt; East (1,0)
 *                       |
 *                       |
 *                       v
 *                    South (0,1)
 *
 *
 *                    [ USER ]
 *                      \|||/
 *                      (o o)
 *                ---ooO-(_)-Ooo---
 * </pre>
 *
 * <p>If type is {@code SDL_HAPTIC_POLAR}, direction is encoded by hundredths of a
 *  degree starting north and turning clockwise.  {@code SDL_HAPTIC_POLAR} only uses
 *  the first {@code dir} parameter.  The cardinal directions would be:</p>
 * <ul>
 *     <li>North: 0 (0 degrees)</li>
 *     <li>East: 9000 (90 degrees)</li>
 *     <li>South: 18000 (180 degrees)</li>
 *     <li>West: 27000 (270 degrees)</li>
 * </ul>
 *
 * <p>If type is {@code SDL_HAPTIC_CARTESIAN}, direction is encoded by three positions
 *  (X axis, Y axis and Z axis (with 3 axes)).  {@code SDL_HAPTIC_CARTESIAN} uses
 *  the first three {@code dir} parameters.  The cardinal directions would be:</p>
 * <ul>
 *     <li>North:  0,-1, 0</li>
 *     <li>East:   1, 0, 0</li>
 *     <li>South:  0, 1, 0</li>
 *     <li>West:  -1, 0, 0</li>
 * </ul>
 *
 * <p>The Z axis represents the height of the effect if supported, otherwise
 *  it's unused.  In cartesian encoding (1, 2) would be the same as (2, 4), you
 *  can use any multiple you want, only the direction matters.</p>
 *
 * <p>If type is {@code SDL_HAPTIC_SPHERICAL}, direction is encoded by two rotations.
 *  The first two {@code dir} parameters are used.  The {@code dir} parameters are as
 *  follows (all values are in hundredths of degrees):</p>
 * <ul>
 *     <li>Degrees from (1, 0) rotated towards (0, 1).</li>
 *     <li>Degrees towards (0, 0, 1) (device needs at least 3 axes).</li>
 * </ul>
 *
 * <p>Example of force coming from the south with all encodings (force coming
 *  from the south means the user will have to pull the stick to counteract):</p>
 * <pre>
 * SDL_HapticDirection direction = new SDL_HapticDirection();
 *
 * // Cartesian directions
 * direction.type = SDL_HAPTIC_CARTESIAN;   // Using cartesian direction encoding.
 * direction.dir[0] = 0;                    // X position
 * direction.dir[1] = 1;                    // Y position
 * // Assuming the device has 2 axes, we don't need to specify third parameter.
 *
 * // Polar directions
 * direction.type = SDL_HAPTIC_POLAR;       // We'll be using polar direction encoding.
 * direction.dir[0] = 18000;                // Polar only uses first parameter
 *
 * // Spherical coordinates
 * direction.type = SDL_HAPTIC_SPHERICAL;   // Spherical encoding
 * direction.dir[0] = 9000;                 // Since we only have two axes we don't need more parameters.
 * </pre>
 *
 * @see SDL_HapticDirectionEncoding#SDL_HAPTIC_POLAR
 * @see SDL_HapticDirectionEncoding#SDL_HAPTIC_CARTESIAN
 * @see SDL_HapticDirectionEncoding#SDL_HAPTIC_SPHERICAL
 * @see SDL_HapticDirectionEncoding#SDL_HAPTIC_STEERING_AXIS
 * @see SDL_HapticEffect
 * @see SdlHaptic#SDL_HapticNumAxes(SDL_Haptic)
 */
@Structure.FieldOrder({
        "type",
        "dir"
})
public final class SDL_HapticDirection extends Structure {

    /** The type of encoding. */
    @MagicConstant(valuesFromClass = SDL_HapticDirectionEncoding.class)
    public byte type;

    /** The encoded direction. */
    public int[] dir = new int[3];

    public SDL_HapticDirection() {
    }

    public SDL_HapticDirection(Pointer p) {
        super(p);
    }
}
