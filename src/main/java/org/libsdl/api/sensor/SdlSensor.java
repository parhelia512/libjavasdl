package org.libsdl.api.sensor;

import com.sun.jna.Pointer;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

/**
 *  <p>Adapted from SDL_sensor.h</p>
 *
 *  <p>In order to use these functions, SDL_Init() must have been called
 *  with the {@code SDL_INIT_SENSOR} flag. This causes SDL to scan the system
 *  for sensors, and load appropriate drivers.</p>
 */
public final class SdlSensor {

    /**
     * <p>Accelerometer sensor</p>
     *
     * <p>The accelerometer returns the current acceleration in SI meters per
     * second squared. This measurement includes the force of gravity, so
     * a device at rest will have an value of SDL_STANDARD_GRAVITY away
     * from the center of the earth.</p>
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
     * @see org.libsdl.api.video.SdlVideo#SDL_GetDisplayOrientation()
     */
    public static final float SDL_STANDARD_GRAVITY = 9.80665f;

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
    public static void SDL_LockSensors() {
        NativeFunctions.SDL_LockSensors();
    }

    public static void SDL_UnlockSensors() {
        NativeFunctions.SDL_UnlockSensors();
    }

    /**
     * <p>Count the number of sensors attached to the system right now.</p>
     *
     * @return the number of sensors detected.
     */
    public static int SDL_NumSensors() {
        return NativeFunctions.SDL_NumSensors();
    }

    /**
     * <p>Get the implementation dependent name of a sensor.</p>
     *
     * @param deviceIndex The sensor to obtain name from
     * @return the sensor name, or {@code null} if {@code deviceIndex} is out of range.
     */
    public static String SDL_SensorGetDeviceName(int deviceIndex) {
        return NativeFunctions.SDL_SensorGetDeviceName(deviceIndex);
    }

    /**
     * <p>Get the type of a sensor.</p>
     *
     * @param deviceIndex The sensor to get the type from
     * @return the SDL_SensorType, or {@code SDL_SENSOR_INVALID} if {@code deviceIndex} is
     * out of range.
     */
    @MagicConstant(valuesFromClass = SDL_SensorType.class)
    public static int SDL_SensorGetDeviceType(int deviceIndex) {
        return NativeFunctions.SDL_SensorGetDeviceType(deviceIndex);
    }

    /**
     * <p>Get the platform dependent type of a sensor.</p>
     *
     * @param deviceIndex The sensor to check
     * @return the sensor platform dependent type, or {@code -1} if {@code deviceIndex} is out
     * of range.
     */
    public static int SDL_SensorGetDeviceNonPortableType(int deviceIndex) {
        return NativeFunctions.SDL_SensorGetDeviceNonPortableType(deviceIndex);
    }

    /**
     * <p>Get the instance ID of a sensor.</p>
     *
     * @param deviceIndex The sensor to get instance ID from
     * @return the sensor instance ID, or {@code -1} if {@code deviceIndex} is out of range.
     */
    public static SDL_SensorID SDL_SensorGetDeviceInstanceID(int deviceIndex) {
        return NativeFunctions.SDL_SensorGetDeviceInstanceID(deviceIndex);
    }

    /**
     * <p>Open a sensor for use.</p>
     *
     * @param deviceIndex The sensor to open
     * @return an SDL_Sensor sensor object, or {@code null} if an error occurred.
     */
    public static SDL_Sensor SDL_SensorOpen(int deviceIndex) {
        return NativeFunctions.SDL_SensorOpen(deviceIndex);
    }

    /**
     * <p>Return the SDL_Sensor associated with an instance ID.</p>
     *
     * @param instanceId The sensor from instance ID
     * @return an SDL_Sensor object.
     */
    public static SDL_Sensor SDL_SensorFromInstanceID(SDL_SensorID instanceId) {
        return NativeFunctions.SDL_SensorFromInstanceID(instanceId);
    }

    /**
     * <p>Get the implementation dependent name of a sensor</p>
     *
     * @param sensor The SDL_Sensor object
     * @return the sensor name, or {@code null} if {@code sensor} is {@code null}.
     */
    public static String SDL_SensorGetName(SDL_Sensor sensor) {
        return NativeFunctions.SDL_SensorGetName(sensor);
    }

    /**
     * <p>Get the type of a sensor.</p>
     *
     * @param sensor The SDL_Sensor object to inspect
     * @return the SDL_SensorType type, or {@code SDL_SENSOR_INVALID} if {@code sensor} is
     * {@code null}.
     */
    @MagicConstant(valuesFromClass = SDL_SensorType.class)
    public static int SDL_SensorGetType(SDL_Sensor sensor) {
        return NativeFunctions.SDL_SensorGetType(sensor);
    }

    /**
     * <p>Get the platform dependent type of a sensor.</p>
     *
     * @param sensor The SDL_Sensor object to inspect
     * @return the sensor platform dependent type, or {@code -1} if {@code sensor} is {@code null}.
     */
    public static int SDL_SensorGetNonPortableType(SDL_Sensor sensor) {
        return NativeFunctions.SDL_SensorGetNonPortableType(sensor);
    }

    /**
     * <p>Get the instance ID of a sensor.</p>
     *
     * @param sensor The SDL_Sensor object to inspect
     * @return the sensor instance ID, or {@code -1} if {@code sensor} is {@code null}.
     */
    public static SDL_SensorID SDL_SensorGetInstanceID(SDL_Sensor sensor) {
        return NativeFunctions.SDL_SensorGetInstanceID(sensor);
    }

    /**
     * <p>Get the current state of an opened sensor.</p>
     *
     * <p>The number of values and interpretation of the data is sensor dependent.</p>
     *
     * @param sensor    The SDL_Sensor object to query
     * @param data      A pointer filled with the current sensor state
     * @param numValues The number of values to write to data
     * @return 0 or -1 if an error occurred.
     */
    public static int SDL_SensorGetData(SDL_Sensor sensor, Pointer data, int numValues) {
        return NativeFunctions.SDL_SensorGetData(sensor, data, numValues);
    }

    /**
     * <p>Close a sensor previously opened with SDL_SensorOpen().</p>
     *
     * @param sensor The SDL_Sensor object to close
     */
    public static void SDL_SensorClose(SDL_Sensor sensor) {
        NativeFunctions.SDL_SensorClose(sensor);
    }

    /**
     * <p>Update the current state of the open sensors.</p>
     *
     * <p>This is called automatically by the event loop if sensor events are
     * enabled.</p>
     *
     * <p>This needs to be called from the thread that initialized the sensor
     * subsystem.</p>
     */
    public static void SDL_SensorUpdate() {
        NativeFunctions.SDL_SensorUpdate();
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        public static native void SDL_LockSensors();

        public static native void SDL_UnlockSensors();

        public static native int SDL_NumSensors();

        public static native String SDL_SensorGetDeviceName(int deviceIndex);

        public static native int SDL_SensorGetDeviceType(int deviceIndex);

        public static native int SDL_SensorGetDeviceNonPortableType(int deviceIndex);

        public static native SDL_SensorID SDL_SensorGetDeviceInstanceID(int deviceIndex);

        public static native SDL_Sensor SDL_SensorOpen(int deviceIndex);

        public static native SDL_Sensor SDL_SensorFromInstanceID(SDL_SensorID instanceId);

        public static native String SDL_SensorGetName(SDL_Sensor sensor);

        public static native int SDL_SensorGetType(SDL_Sensor sensor);

        public static native int SDL_SensorGetNonPortableType(SDL_Sensor sensor);

        public static native SDL_SensorID SDL_SensorGetInstanceID(SDL_Sensor sensor);

        public static native int SDL_SensorGetData(SDL_Sensor sensor, Pointer data, int numValues);

        public static native void SDL_SensorClose(SDL_Sensor sensor);

        public static native void SDL_SensorUpdate();
    }
}
