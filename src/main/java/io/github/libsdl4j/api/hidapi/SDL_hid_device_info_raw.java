package io.github.libsdl4j.api.hidapi;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * hidapi info structure
 *
 * <p>Information about a connected HID device.</p>
 *
 * <p>This is a private C-style raw type. Use {@link SDL_hid_device_info} instead.</p>
 */
@Structure.FieldOrder({
        "path",
        "vendorId",
        "productId",
        "serialNumber",
        "releaseNumber",
        "manufacturerString",
        "productString",
        "usagePage",
        "usage",
        "interfaceNumber",
        "interfaceClass",
        "interfaceSubclass",
        "interfaceProtocol",
        "next"
})
final class SDL_hid_device_info_raw extends Structure implements Structure.ByReference {

    /** Platform-specific device path */
    public Pointer path;

    /** Device Vendor ID */
    public short vendorId;

    /** Device Product ID */
    public short productId;

    /** Serial Number */
    public Pointer serialNumber;

    /** Device Release Number in binary-coded decimal, also known as Device Version Number */
    short releaseNumber;

    /** Manufacturer String */
    public Pointer manufacturerString;

    /** Product string */
    public Pointer productString;

    /** Usage Page for this Device/Interface (Windows/Mac only). */
    public short usagePage;

    /** Usage for this Device/Interface (Windows/Mac only). */
    public short usage;

    /**
     * The USB interface which this logical device
     * represents.
     *
     * <ul>
     *     <li>Valid on both Linux implementations in all cases.</li>
     *     <li>Valid on the Windows implementation only if the device
     *         contains more than one interface.</li>
     * </ul>
     */
    public int interfaceNumber;

    /** Additional information about the USB interface. Valid on libusb and Android implementations. */
    public int interfaceClass;

    /** Additional information about the USB interface. Valid on libusb and Android implementations. */
    public int interfaceSubclass;

    /** Additional information about the USB interface. Valid on libusb and Android implementations. */
    public int interfaceProtocol;

    /** Pointer to the next device */
    public SDL_hid_device_info_raw next;

    public SDL_hid_device_info_raw() {
    }

    public SDL_hid_device_info_raw(Pointer p) {
        super(p);
    }
}
