package io.github.libsdl4j.api.sensor;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The different sensors defined by SDL
 *
 * Additional sensors may be available, using platform dependent semantics.
 *
 * Hare are the additional Android sensors:
 * https://developer.android.com/reference/android/hardware/SensorEvent.html#values
 */
public final class SDL_SensorType implements JnaEnum {

    /** Returned for an invalid sensor */
    public static final int SDL_SENSOR_INVALID = -1;

    /** Unknown sensor type */
    public static final int SDL_SENSOR_UNKNOWN = 0;

    /** Accelerometer */
    public static final int SDL_SENSOR_ACCEL = 1;

    /** Gyroscope */
    public static final int SDL_SENSOR_GYRO = 2;

    /** Accelerometer for left Joy-Con controller and Wii nunchuk */
    public static final int SDL_SENSOR_ACCEL_L = 3;

    /** Gyroscope for left Joy-Con controller */
    public static final int SDL_SENSOR_GYRO_L = 4;

    /** Accelerometer for right Joy-Con controller */
    public static final int SDL_SENSOR_ACCEL_R = 5;

    /** Gyroscope for right Joy-Con controller */
    public static final int SDL_SENSOR_GYRO_R = 6;

    // TODO: Generate public static String toString(int value)

    private SDL_SensorType() {
    }
}
