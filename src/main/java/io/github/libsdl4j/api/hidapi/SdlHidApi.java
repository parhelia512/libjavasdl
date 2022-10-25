package io.github.libsdl4j.api.hidapi;

import java.util.ArrayList;
import java.util.List;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import io.github.libsdl4j.jna.JnaUtils;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import io.github.libsdl4j.jna.StringRef;
import io.github.libsdl4j.jna.size_t;

/**
 * Definitions from file SDL_hidapi.h
 *
 * <p>Header file for SDL HIDAPI functions.</p>
 *
 * <p>This is an adaptation of the original HIDAPI interface by Alan Ott,
 * and includes source code licensed under the following BSD license:</p>
 *
 * <p>Copyright (c) 2010, Alan Ott, Signal 11 Software
 * All rights reserved.</p>
 *
 * <p>Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:</p>
 *
 * <ul>
 *     <li>Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.</li>
 *     <li>Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.</li>
 *     <li>Neither the name of Signal 11 Software nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.</li>
 * </ul>
 *
 * <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.</p>
 *
 * <p>If you would like a version of SDL without this code, you can build SDL
 * with SDL_HIDAPI_DISABLED defined to 1. You might want to do this for example
 * on iOS or tvOS to avoid a dependency on the CoreBluetooth framework.</p>
 */
public final class SdlHidApi {

    /**
     * Initialize the HIDAPI library.
     *
     * <p>This function initializes the HIDAPI library. Calling it is not strictly
     * necessary, as it will be called automatically by SDL_hid_enumerate() and
     * any of the SDL_hid_open_*() functions if it is needed. This function should
     * be called at the beginning of execution however, if there is a chance of
     * HIDAPI handles being opened by different threads simultaneously.</p>
     *
     * <p>Each call to this function should have a matching call to SDL_hid_exit()</p>
     *
     * @return 0 on success and -1 on error.
     * @see #SDL_hid_exit()
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_hid_init();

    /**
     * Finalize the HIDAPI library.
     *
     * <p>This function frees all of the static data associated with HIDAPI. It
     * should be called at the end of execution to avoid memory leaks.</p>
     *
     * @return 0 on success and -1 on error.
     * @see #SDL_hid_init()
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_hid_exit();

    /**
     * Check to see if devices may have been added or removed.
     *
     * <p>Enumerating the HID devices is an expensive operation, so you can call this
     * to see if there have been any system device changes since the last call to
     * this function. A change in the counter returned doesn't necessarily mean
     * that anything has changed, but you can call SDL_hid_enumerate() to get an
     * updated device list.</p>
     *
     * <p>Calling this function for the first time may cause a thread or other system
     * resource to be allocated to track device change notifications.</p>
     *
     * @return a change counter that is incremented with each potential device
     * change, or 0 if device change detection isn't available.
     * @see #SDL_hid_enumerate(short, short)
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_hid_device_change_count();

    /**
     * Enumerate the HID Devices.
     *
     * <p>This function returns a list of all the HID devices attached to the
     * system which match vendorId and productId. If {@code vendorId} is set to 0
     * then any vendor matches. If {@code productId} is set to 0 then any product
     * matches. If {@code vendorId} and {@code productId} are both set to 0, then all HID
     * devices will be returned.</p>
     *
     * @param vendorId  The Vendor ID (VID) of the types of device to open.
     * @param productId The Product ID (PID) of the types of device to open.
     * @return a list of SDL_hid_device_info objects, containing
     * information about the HID devices attached to the system, or null
     * in the case of failure.
     * @see #SDL_hid_device_change_count()
     * @since This function is available since SDL 2.0.18.
     */
    public static List<SDL_hid_device_info> SDL_hid_enumerate(
            short vendorId,
            short productId) {
        SDL_hid_device_info_raw rawStruct = InternalNativeFunctions.SDL_hid_enumerate(vendorId, productId);
        List<SDL_hid_device_info> devInfoList = convert(rawStruct);
        InternalNativeFunctions.SDL_hid_free_enumeration(rawStruct.getPointer());
        return devInfoList;
    }

    private static List<SDL_hid_device_info> convert(
            SDL_hid_device_info_raw rawStruct) {
        List<SDL_hid_device_info> devInfoList = new ArrayList<>();
        while (rawStruct != null) {
            SDL_hid_device_info devInfo = new SDL_hid_device_info();
            devInfo.path = rawStruct.path.getString(0L);
            devInfo.vendorId = rawStruct.vendorId;
            devInfo.productId = rawStruct.productId;
            devInfo.serialNumber = rawStruct.serialNumber.getWideString(0L);
            devInfo.releaseNumber = rawStruct.releaseNumber;
            devInfo.manufacturerString = rawStruct.manufacturerString.getWideString(0L);
            devInfo.productString = rawStruct.productString.getWideString(0L);
            devInfo.usagePage = rawStruct.usagePage;
            devInfo.usage = rawStruct.usage;
            devInfo.interfaceNumber = rawStruct.interfaceNumber;
            devInfo.interfaceClass = rawStruct.interfaceClass;
            devInfo.interfaceSubclass = rawStruct.interfaceSubclass;
            devInfo.interfaceProtocol = rawStruct.interfaceProtocol;
            rawStruct = rawStruct.next;
            devInfoList.add(devInfo);
        }
        return devInfoList;
    }

    /**
     * Open a HID device using a Vendor ID (VID), Product ID (PID) and optionally
     * a serial number.
     *
     * <p>If {@code serialNumber} is null, the first device with the specified VID and PID
     * is opened.</p>
     *
     * @param vendorId     The Vendor ID (VID) of the device to open.
     * @param productId    The Product ID (PID) of the device to open.
     * @param serialNumber The Serial Number of the device to open (Optionally
     *                     null).
     * @return a pointer to a SDL_hid_device object on success or null on
     * failure.
     * @since This function is available since SDL 2.0.18.
     */
    public static SDL_hid_device SDL_hid_open(
            short vendorId,
            short productId,
            String serialNumber) {
        return InternalNativeFunctions.SDL_hid_open(
                vendorId, productId, serialNumber != null ? new WString(serialNumber) : null);
    }

    /**
     * Open a HID device by its path name.
     *
     * <p>The path name be determined by calling SDL_hid_enumerate(), or a
     * platform-specific path name can be used (eg: /dev/hidraw0 on Linux).</p>
     *
     * @param path The path name of the device to open
     * @return a pointer to a SDL_hid_device object on success or null on
     * failure.
     * @since This function is available since SDL 2.0.18.
     */
    public static native SDL_hid_device SDL_hid_open_path(
            String path,
            int bExclusive);

    /**
     * Write an Output report to a HID device.
     *
     * <p>The first byte of {@code data} must contain the Report ID. For devices which only
     * support a single report, this must be set to 0x0. The remaining bytes
     * contain the report data. Since the Report ID is mandatory, calls to
     * SDL_hid_write() will always contain one more byte than the report contains.
     * For example, if a hid report is 16 bytes long, 17 bytes must be passed to
     * SDL_hid_write(), the Report ID (or 0x0, for devices with a single report),
     * followed by the report data (16 bytes). In this example, the length passed
     * in would be 17.</p>
     *
     * <p>SDL_hid_write() will send the data on the first OUT endpoint, if one
     * exists. If it does not, it will send the data through the Control Endpoint
     * (Endpoint 0).</p>
     *
     * <p>This is a Java-style version of the raw function {@link #SDL_hid_write(SDL_hid_device, Pointer, size_t)}.</p>
     *
     * @param dev  A device handle returned from SDL_hid_open().
     * @param data The data to send, including the report number as the first
     *             byte.
     * @return the actual number of bytes written and -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_hid_write(
            SDL_hid_device dev,
            byte[] data) {
        try (Memory buffer = JnaUtils.writeArrayToNativeMemory(data)) {
            return SDL_hid_write(dev, buffer, new size_t(buffer.size()));
        }
    }

    /**
     * Write an Output report to a HID device.
     *
     * <p>The first byte of {@code data} must contain the Report ID. For devices which only
     * support a single report, this must be set to 0x0. The remaining bytes
     * contain the report data. Since the Report ID is mandatory, calls to
     * SDL_hid_write() will always contain one more byte than the report contains.
     * For example, if a hid report is 16 bytes long, 17 bytes must be passed to
     * SDL_hid_write(), the Report ID (or 0x0, for devices with a single report),
     * followed by the report data (16 bytes). In this example, the length passed
     * in would be 17.</p>
     *
     * <p>SDL_hid_write() will send the data on the first OUT endpoint, if one
     * exists. If it does not, it will send the data through the Control Endpoint
     * (Endpoint 0).</p>
     *
     * <p>This is a raw C-style function. Prefer {@link #SDL_hid_write(SDL_hid_device, byte[])}.</p>
     *
     * @param dev    A device handle returned from SDL_hid_open().
     * @param data   The data to send, including the report number as the first
     *               byte.
     * @param length The length in bytes of the data to send.
     * @return the actual number of bytes written and -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_hid_write(
            SDL_hid_device dev,
            Pointer data,
            size_t length);

    /**
     * Read an Input report from a HID device with timeout.
     *
     * <p>Input reports are returned to the host through the INTERRUPT IN endpoint.
     * The first byte will contain the Report number if the device uses numbered
     * reports.</p>
     *
     * <p>This is a Java-style version of the raw function {@link #SDL_hid_read_timeout(SDL_hid_device, Pointer, size_t, int)}.</p>
     *
     * @param dev          A device handle returned from SDL_hid_open().
     * @param data         A buffer to put the read data into.
     *                     It must be allocated to the expected number of bytes to read.
     *                     For devices with multiple
     *                     reports, make sure to read an extra byte for the report
     *                     number.
     * @param milliseconds timeout in milliseconds or -1 for blocking wait.
     * @return the actual number of bytes read and -1 on error. If no packet was
     * available to be read within the timeout period, this function
     * returns 0.
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_hid_read_timeout(
            SDL_hid_device dev,
            byte[] data,
            int milliseconds) {
        try (Memory buffer = new Memory(data.length)) {
            int result = SDL_hid_read_timeout(dev, buffer, new size_t(buffer.size()), milliseconds);
            buffer.read(0L, data, 0, data.length);
            return result;
        }
    }

    /**
     * Read an Input report from a HID device with timeout.
     *
     * <p>Input reports are returned to the host through the INTERRUPT IN endpoint.
     * The first byte will contain the Report number if the device uses numbered
     * reports.</p>
     *
     * <p>This is a raw C-style function. Prefer {@link #SDL_hid_read_timeout(SDL_hid_device, byte[], int)}.</p>
     *
     * @param dev          A device handle returned from SDL_hid_open().
     * @param data         A buffer to put the read data into.
     * @param length       The number of bytes to read. For devices with multiple
     *                     reports, make sure to read an extra byte for the report
     *                     number.
     * @param milliseconds timeout in milliseconds or -1 for blocking wait.
     * @return the actual number of bytes read and -1 on error. If no packet was
     * available to be read within the timeout period, this function
     * returns 0.
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_hid_read_timeout(
            SDL_hid_device dev,
            Pointer data,
            size_t length,
            int milliseconds);

    /**
     * Read an Input report from a HID device.
     *
     * <p>Input reports are returned to the host through the INTERRUPT IN endpoint.
     * The first byte will contain the Report number if the device uses numbered
     * reports.</p>
     *
     * <p>This is a Java-style version of the raw function {@link #SDL_hid_read(SDL_hid_device, Pointer, size_t)}.</p>
     *
     * @param dev  A device handle returned from SDL_hid_open().
     * @param data A buffer to put the read data into. It must be pre-allocated to
     *             the number of bytes to read. For devices with multiple
     *             reports, make sure to read an extra byte for the report
     *             number.
     * @return the actual number of bytes read and -1 on error. If no packet was
     * available to be read and the handle is in non-blocking mode, this
     * function returns 0.
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_hid_read(
            SDL_hid_device dev,
            byte[] data) {
        try (Memory buffer = new Memory(data.length)) {
            int result = SDL_hid_read(dev, buffer, new size_t(buffer.size()));
            buffer.read(0L, data, 0, data.length);
            return result;
        }
    }

    /**
     * Read an Input report from a HID device.
     *
     * <p>Input reports are returned to the host through the INTERRUPT IN endpoint.
     * The first byte will contain the Report number if the device uses numbered
     * reports.</p>
     *
     * <p>This is a raw C-style function. Prefer {@link #SDL_hid_read(SDL_hid_device, byte[])}.</p>
     *
     * @param dev    A device handle returned from SDL_hid_open().
     * @param data   A buffer to put the read data into.
     * @param length The number of bytes to read. For devices with multiple
     *               reports, make sure to read an extra byte for the report
     *               number.
     * @return the actual number of bytes read and -1 on error. If no packet was
     * available to be read and the handle is in non-blocking mode, this
     * function returns 0.
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_hid_read(
            SDL_hid_device dev,
            Pointer data,
            size_t length);

    /**
     * Set the device handle to be non-blocking.
     *
     * <p>In non-blocking mode calls to SDL_hid_read() will return immediately with a
     * value of 0 if there is no data to be read. In blocking mode, SDL_hid_read()
     * will wait (block) until there is data to read before returning.</p>
     *
     * <p>Nonblocking can be turned on and off at any time.</p>
     *
     * @param dev      A device handle returned from SDL_hid_open().
     * @param nonblock enable or not the nonblocking reads - 1 to enable
     *                 nonblocking - 0 to disable nonblocking.
     * @return 0 on success and -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_hid_set_nonblocking(
            SDL_hid_device dev,
            int nonblock);

    /**
     * Send a Feature report to the device.
     *
     * <p>Feature reports are sent over the Control endpoint as a Set_Report
     * transfer. The first byte of {@code data} must contain the Report ID. For devices
     * which only support a single report, this must be set to 0x0. The remaining
     * bytes contain the report data. Since the Report ID is mandatory, calls to
     * SDL_hid_send_feature_report() will always contain one more byte than the
     * report contains. For example, if a hid report is 16 bytes long, 17 bytes
     * must be passed to SDL_hid_send_feature_report(): the Report ID (or 0x0, for
     * devices which do not use numbered reports), followed by the report data (16
     * bytes). In this example, the length passed in would be 17.</p>
     *
     * <p>This is a Java-style version of the raw function {@link #SDL_hid_send_feature_report(SDL_hid_device, Pointer, size_t)}.</p>
     *
     * @param dev  A device handle returned from SDL_hid_open().
     * @param data The data to send, including the report number as the first
     *             byte.
     * @return the actual number of bytes written and -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_hid_send_feature_report(
            SDL_hid_device dev,
            byte[] data) {
        try (Memory buffer = JnaUtils.writeArrayToNativeMemory(data)) {
            return SDL_hid_send_feature_report(dev, buffer, new size_t(buffer.size()));
        }
    }

    /**
     * Send a Feature report to the device.
     *
     * <p>Feature reports are sent over the Control endpoint as a Set_Report
     * transfer. The first byte of {@code data} must contain the Report ID. For devices
     * which only support a single report, this must be set to 0x0. The remaining
     * bytes contain the report data. Since the Report ID is mandatory, calls to
     * SDL_hid_send_feature_report() will always contain one more byte than the
     * report contains. For example, if a hid report is 16 bytes long, 17 bytes
     * must be passed to SDL_hid_send_feature_report(): the Report ID (or 0x0, for
     * devices which do not use numbered reports), followed by the report data (16
     * bytes). In this example, the length passed in would be 17.</p>
     *
     * <p>This is a raw C-style function. Prefer {@link #SDL_hid_send_feature_report(SDL_hid_device, byte[])}.</p>
     *
     * @param dev    A device handle returned from SDL_hid_open().
     * @param data   The data to send, including the report number as the first
     *               byte.
     * @param length The length in bytes of the data to send, including the report
     *               number.
     * @return the actual number of bytes written and -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_hid_send_feature_report(
            SDL_hid_device dev,
            Pointer data,
            size_t length);

    /**
     * Get a feature report from a HID device.
     *
     * <p>Set the first byte of {@code data} to the Report ID of the report to be read.
     * Make sure to allow space for this extra byte in {@code data}. Upon return, the
     * first byte will still contain the Report ID, and the report data will start
     * in data[1].</p>
     *
     * <p>This is a Java-style version of the raw function {@link #SDL_hid_get_feature_report(SDL_hid_device, Pointer, size_t)}.</p>
     *
     * @param dev  A device handle returned from SDL_hid_open().
     * @param data A buffer to put the read data into, including the Report ID.
     *             Set the first byte of {@code data} to the Report ID of the report to
     *             be read, or set it to zero if your device does not use numbered
     *             reports.
     *             It must be pre-allocated to the expected
     *             number of bytes to read, including an extra byte for the
     *             report ID. The buffer can be longer than the actual report.
     * @return the number of bytes read plus one for the report ID (which is
     * still in the first byte), or -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_hid_get_feature_report(
            SDL_hid_device dev,
            byte[] data) {
        int result;
        try (Memory buffer = new Memory(data.length)) {
            result = SDL_hid_get_feature_report(dev, buffer, new size_t(buffer.size()));
            buffer.read(0L, data, 0, data.length);
            return result;
        }
    }

    /**
     * Get a feature report from a HID device.
     *
     * <p>Set the first byte of {@code data} to the Report ID of the report to be read.
     * Make sure to allow space for this extra byte in {@code data}. Upon return, the
     * first byte will still contain the Report ID, and the report data will start
     * in data[1].</p>
     *
     * <p>This is a raw C-style function. Prefer {@link #SDL_hid_get_feature_report(SDL_hid_device, byte[])}.</p>
     *
     * @param dev    A device handle returned from SDL_hid_open().
     * @param data   A buffer to put the read data into, including the Report ID.
     *               Set the first byte of {@code data} to the Report ID of the report to
     *               be read, or set it to zero if your device does not use numbered
     *               reports.
     * @param length The number of bytes to read, including an extra byte for the
     *               report ID. The buffer can be longer than the actual report.
     * @return the number of bytes read plus one for the report ID (which is
     * still in the first byte), or -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_hid_get_feature_report(
            SDL_hid_device dev,
            Pointer data,
            size_t length);

    /**
     * Close a HID device.
     *
     * @param dev A device handle returned from SDL_hid_open().
     * @since This function is available since SDL 2.0.18.
     */
    public static native void SDL_hid_close(
            SDL_hid_device dev);

    /**
     * Get The Manufacturer String from a HID device.
     *
     * @param dev    A device handle returned from SDL_hid_open().
     * @param text   A string buffer to put the data into.
     * @param maxlen The length of the buffer in multiples of wchar_t.
     * @return 0 on success and -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_hid_get_manufacturer_string(
            SDL_hid_device dev,
            StringRef text,
            int maxlen) {
        try (Memory buffer = new Memory(maxlen * 2L)) {
            int result = InternalNativeFunctions.SDL_hid_get_manufacturer_string(dev, buffer, new size_t(maxlen));
            text.setValue(buffer.getWideString(0L));
            return result;
        }
    }

    /**
     * Get The Product String from a HID device.
     *
     * @param dev    A device handle returned from SDL_hid_open().
     * @param text   A wide string buffer to put the data into.
     * @param maxlen The length of the buffer in multiples of wchar_t.
     * @return 0 on success and -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_hid_get_product_string(
            SDL_hid_device dev,
            StringRef text,
            int maxlen) {
        try (Memory buffer = new Memory(maxlen * 2L)) {
            int result = InternalNativeFunctions.SDL_hid_get_product_string(dev, buffer, new size_t(maxlen));
            text.setValue(buffer.getWideString(0L));
            return result;
        }
    }

    /**
     * Get The Serial Number String from a HID device.
     *
     * @param dev    A device handle returned from SDL_hid_open().
     * @param text   A wide string buffer to put the data into.
     * @param maxlen The length of the buffer in multiples of wchar_t.
     * @return 0 on success and -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_hid_get_serial_number_string(
            SDL_hid_device dev,
            StringRef text,
            int maxlen) {
        try (Memory buffer = new Memory(maxlen * 2L)) {
            int result = InternalNativeFunctions.SDL_hid_get_serial_number_string(dev, buffer, new size_t(maxlen));
            text.setValue(buffer.getWideString(0L));
            return result;
        }
    }

    /**
     * Get a string from a HID device, based on its string index.
     *
     * @param dev         A device handle returned from SDL_hid_open().
     * @param stringIndex The index of the string to get.
     * @param text        A wide string buffer to put the data into.
     * @param maxlen      The length of the buffer in multiples of wchar_t.
     * @return 0 on success and -1 on error.
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_hid_get_indexed_string(
            SDL_hid_device dev,
            int stringIndex,
            StringRef text,
            int maxlen) {
        try (Memory buffer = new Memory(maxlen * 2L)) {
            int result = InternalNativeFunctions.SDL_hid_get_indexed_string(dev, stringIndex, buffer, new size_t(maxlen));
            text.setValue(buffer.getWideString(0L));
            return result;
        }
    }

    /**
     * Start or stop a BLE scan on iOS and tvOS to pair Steam Controllers
     *
     * @param active true to start the scan, false to stop the scan
     * @since This function is available since SDL 2.0.18.
     */
    public static native void SDL_hid_ble_scan(
            boolean active);

    private static final class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native SDL_hid_device_info_raw SDL_hid_enumerate(
                short vendorId,
                short productId);

        /**
         * Free an enumeration linked list
         *
         * <p>This function frees a linked list created by SDL_hid_enumerate().</p>
         *
         * @param devs Pointer to a list of struct_device returned from
         *             SDL_hid_enumerate().
         * @since This function is available since SDL 2.0.18.
         */
        public static native void SDL_hid_free_enumeration(
                Pointer devs);

        public static native SDL_hid_device SDL_hid_open(
                short vendorId,
                short productId,
                WString serialNumber);

        public static native int SDL_hid_get_manufacturer_string(
                SDL_hid_device dev,
                Pointer text,
                size_t maxlen);

        public static native int SDL_hid_get_product_string(
                SDL_hid_device dev,
                Pointer text,
                size_t maxlen);

        public static native int SDL_hid_get_serial_number_string(
                SDL_hid_device dev,
                Pointer text,
                size_t maxlen);

        public static native int SDL_hid_get_indexed_string(
                SDL_hid_device dev,
                int stringIndex,
                Pointer text,
                size_t maxlen);
    }
}
