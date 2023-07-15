package io.github.libsdl4j.api.sensor;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_sensor.h
 *
 * <p>Include file for SDL sensor event handling.</p>
 *
 * <p>In order to use these functions, SDL_Init() must have been called
 * with the {@code SDL_INIT_SENSOR} flag. This causes SDL to scan the system
 * for sensors, and load appropriate drivers.</p>
 *
 *
 *
 * <h2>Accelerometer sensor</h2>
 *
 * <p>The accelerometer returns the current acceleration in SI meters per
 * second squared. This measurement includes the force of gravity, so
 * a device at rest will have an value of {@link SdlSensorConst#SDL_STANDARD_GRAVITY SDL_STANDARD_GRAVITY} away
 * from the center of the earth, which is a positive Y value.</p>
 *
 * <ul>
 *     <li>values[0]: Acceleration on the x axis</li>
 *     <li>values[1]: Acceleration on the y axis</li>
 *     <li>values[2]: Acceleration on the z axis</li>
 * </ul>
 *
 * <p>For phones held in portrait mode and game controllers held in front of you,
 * the axes are defined as follows:</p>
 *
 * <ul>
 *     <li>-X ... +X : left ... right</li>
 *     <li>-Y ... +Y : bottom ... top</li>
 *     <li>-Z ... +Z : farther ... closer</li>
 * </ul>
 *
 * <p>The axis data is not changed when the phone is rotated.</p>
 *
 *
 *
 * <h3>Gyroscope sensor</h3>
 *
 * <p>The gyroscope returns the current rate of rotation in radians per second.
 * The rotation is positive in the counter-clockwise direction. That is,
 * an observer looking from a positive location on one of the axes would
 * see positive rotation on that axis when it appeared to be rotating
 * counter-clockwise.</p>
 *
 * <ul>
 *     <li>values[0]: Angular speed around the x axis (pitch)</li>
 *     <li>values[1]: Angular speed around the y axis (yaw)</li>
 *     <li>values[2]: Angular speed around the z axis (roll)</li>
 * </ul>
 *
 * <p>For phones held in portrait mode and game controllers held in front of you,
 * the axes are defined as follows:</p>
 *
 * <ul>
 *     <li>-X ... +X : left ... right</li>
 *     <li>-Y ... +Y : bottom ... top</li>
 *     <li>-Z ... +Z : farther ... closer</li>
 * </ul>
 *
 * <p>The axis data is not changed when the phone or controller is rotated.</p>
 *
 * @see io.github.libsdl4j.api.video.SdlVideo#SDL_GetDisplayOrientation(int)
 */
public final class SdlSensor {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlSensor.class);
    }

    private SdlSensor() {
    }

    /**
     * <p>Locking for multi-threaded access to the sensor API</p>
     *
     * <p>If you are using the sensor API or handling events from multiple threads
     * you should use these locking functions to protect access to the sensors.</p>
     *
     * <p>In particular, you are guaranteed that the sensor list won't change, so the
     * API functions that take a sensor index will be valid, and sensor events
     * will not be delivered.</p>
     */
    public static native void SDL_LockSensors();

    public static native void SDL_UnlockSensors();

    /**
     * Count the number of sensors attached to the system right now.
     *
     * @return the number of sensors detected.
     */
    public static native int SDL_NumSensors();

    /**
     * Get the implementation dependent name of a sensor.
     *
     * @param deviceIndex The sensor to obtain name from
     * @return the sensor name, or {@code null} if {@code deviceIndex} is out of range.
     */
    public static native String SDL_SensorGetDeviceName(
            int deviceIndex);

    /**
     * Get the type of a sensor.
     *
     * @param deviceIndex The sensor to get the type from
     * @return the SDL_SensorType, or {@code SDL_SENSOR_INVALID} if {@code deviceIndex} is
     * out of range.
     */
    @MagicConstant(valuesFromClass = SDL_SensorType.class)
    public static native int SDL_SensorGetDeviceType(
            int deviceIndex);

    /**
     * Get the platform dependent type of a sensor.
     *
     * @param deviceIndex The sensor to check
     * @return the sensor platform dependent type, or {@code -1} if {@code deviceIndex} is out
     * of range.
     */
    public static native int SDL_SensorGetDeviceNonPortableType(
            int deviceIndex);

    /**
     * Get the instance ID of a sensor.
     *
     * @param deviceIndex The sensor to get instance ID from
     * @return the sensor instance ID, or {@code -1} if {@code deviceIndex} is out of range.
     */
    public static native SDL_SensorID SDL_SensorGetDeviceInstanceID(
            int deviceIndex);

    /**
     * Open a sensor for use.
     *
     * @param deviceIndex The sensor to open
     * @return an SDL_Sensor sensor object, or {@code null} if an error occurred.
     */
    public static native SDL_Sensor SDL_SensorOpen(
            int deviceIndex);

    /**
     * Return the SDL_Sensor associated with an instance ID.
     *
     * @param instanceId The sensor from instance ID
     * @return an SDL_Sensor object.
     */
    public static native SDL_Sensor SDL_SensorFromInstanceID(
            SDL_SensorID instanceId);

    /**
     * Get the implementation dependent name of a sensor.
     *
     * @param sensor The SDL_Sensor object
     * @return the sensor name, or {@code null} if {@code sensor} is {@code null}.
     */
    public static native String SDL_SensorGetName(
            SDL_Sensor sensor);

    /**
     * Get the type of a sensor.
     *
     * @param sensor The SDL_Sensor object to inspect
     * @return the SDL_SensorType type, or {@code SDL_SENSOR_INVALID} if {@code sensor} is
     * {@code null}.
     */
    @MagicConstant(valuesFromClass = SDL_SensorType.class)
    public static native int SDL_SensorGetType(
            SDL_Sensor sensor);

    /**
     * Get the platform dependent type of a sensor.
     *
     * @param sensor The SDL_Sensor object to inspect
     * @return the sensor platform dependent type, or {@code -1} if {@code sensor} is {@code null}.
     */
    public static native int SDL_SensorGetNonPortableType(
            SDL_Sensor sensor);

    /**
     * Get the instance ID of a sensor.
     *
     * @param sensor The SDL_Sensor object to inspect
     * @return the sensor instance ID, or {@code -1} if {@code sensor} is {@code null}.
     */
    public static native SDL_SensorID SDL_SensorGetInstanceID(
            SDL_Sensor sensor);

    /**
     * Get the current state of an opened sensor.
     *
     * <p>The number of values and interpretation of the data is sensor dependent.</p>
     *
     * @param sensor    The SDL_Sensor object to query
     * @param data      A pointer filled with the current sensor state
     * @param numValues The number of values to write to data
     * @return 0 or -1 if an error occurred.
     */
    public static native int SDL_SensorGetData(
            SDL_Sensor sensor,
            Pointer data,
            int numValues);

    /**
     * Get the current state of an opened sensor with the timestamp of the last
     * update.
     *
     * <p>The number of values and interpretation of the data is sensor dependent.</p>
     *
     * @param sensor    The SDL_Sensor object to query
     * @param timestamp A pointer filled with the timestamp in microseconds of the
     *                  current sensor reading if available, or 0 if not
     * @param data      A pointer filled with the current sensor state
     * @param numValues The number of values to write to data
     * @return 0 or -1 if an error occurred.
     * @since This function is available since SDL 2.26.0.
     */
    public static native int SDL_SensorGetDataWithTimestamp(
            SDL_Sensor sensor,
            LongByReference timestamp,
            Pointer data,
            int numValues);

    /**
     * Close a sensor previously opened with SDL_SensorOpen().
     *
     * @param sensor The SDL_Sensor object to close
     */
    public static native void SDL_SensorClose(
            SDL_Sensor sensor);

    /**
     * Update the current state of the open sensors.
     *
     * <p>This is called automatically by the event loop if sensor events are
     * enabled.</p>
     *
     * <p>This needs to be called from the thread that initialized the sensor
     * subsystem.</p>
     */
    public static native void SDL_SensorUpdate();
}
