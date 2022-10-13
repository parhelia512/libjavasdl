package io.github.libsdl4j.api.sensor;

public final class SdlSensorConst {

    /**
     * The force of gravity in an accelerometer sensor.
     * A device at rest will have this value away from the center of the earth.
     *
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_GetDisplayOrientation(int)
     */
    public static final float SDL_STANDARD_GRAVITY = 9.80665f;

    private SdlSensorConst() {
    }
}
