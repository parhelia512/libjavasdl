package io.github.libsdl4j.api.hidapi;

/**
 * hidapi info structure
 *
 * <p>Information about a connected HID device.</p>
 */
public final class SDL_hid_device_info {

    /** Platform-specific device path */
    public String path;

    /** Device Vendor ID */
    public short vendorId;

    /** Device Product ID */
    public short productId;

    /** Serial Number */
    public String serialNumber;

    /** Device Release Number in binary-coded decimal, also known as Device Version Number */
    public short releaseNumber;

    /** Manufacturer String */
    public String manufacturerString;

    /** Product string */
    public String productString;

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
}
