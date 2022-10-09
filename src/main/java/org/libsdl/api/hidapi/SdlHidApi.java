package org.libsdl.api.hidapi;

import java.util.ArrayList;
import java.util.List;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import org.libsdl.jna.SdlNativeLibraryLoader;
import org.libsdl.jna.StringRef;
import org.libsdl.jna.size_t;

public final class SdlHidApi {

    public static native int SDL_hid_init();

    public static native int SDL_hid_exit();

    public static native int SDL_hid_device_change_count();

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

    public static SDL_hid_device SDL_hid_open(
            short vendorId,
            short productId,
            String serialNumber) {
        return InternalNativeFunctions.SDL_hid_open(vendorId, productId, serialNumber != null ? new WString(serialNumber) : null);
    }

    public static native SDL_hid_device SDL_hid_open_path(
            String path,
            int bExclusive);

    public static int SDL_hid_write(
            SDL_hid_device dev,
            byte[] data) {
        Memory buffer = new Memory(data.length);
        buffer.write(0L, data, 0, data.length);
        return SDL_hid_write(dev, buffer, new size_t(buffer.size()));
    }

    public static native int SDL_hid_write(
            SDL_hid_device dev,
            Pointer data,
            size_t length);

    public static int SDL_hid_read_timeout(
            SDL_hid_device dev,
            byte[] data,
            int milliseconds) {
        Memory buffer = new Memory(data.length);
        int result = SDL_hid_read_timeout(dev, buffer, new size_t(buffer.size()), milliseconds);
        buffer.read(0L, data, 0, data.length);
        return result;
    }

    public static native int SDL_hid_read_timeout(
            SDL_hid_device dev,
            Pointer data,
            size_t length,
            int milliseconds);

    public static int SDL_hid_read(
            SDL_hid_device dev,
            byte[] data) {
        Memory buffer = new Memory(data.length);
        int result = SDL_hid_read(dev, buffer, new size_t(buffer.size()));
        buffer.read(0L, data, 0, data.length);
        return result;
    }

    public static native int SDL_hid_read(
            SDL_hid_device dev,
            Pointer data,
            size_t length);

    public static native int SDL_hid_set_nonblocking(
            SDL_hid_device dev,
            int nonblock);

    public static int SDL_hid_send_feature_report(
            SDL_hid_device dev,
            byte[] data) {
        Memory buffer = new Memory(data.length);
        buffer.write(0L, data, 0, data.length);
        return SDL_hid_send_feature_report(dev, buffer, new size_t(buffer.size()));
    }

    public static native int SDL_hid_send_feature_report(
            SDL_hid_device dev,
            Pointer data,
            size_t length);

    public static int SDL_hid_get_feature_report(
            SDL_hid_device dev,
            byte[] data) {
        Memory buffer = new Memory(data.length);
        int result = SDL_hid_get_feature_report(dev, buffer, new size_t(buffer.size()));
        buffer.read(0L, data, 0, data.length);
        return result;
    }

    public static native int SDL_hid_get_feature_report(
            SDL_hid_device dev,
            Pointer data,
            size_t length);

    public static native void SDL_hid_close(
            SDL_hid_device dev);

    public static int SDL_hid_get_manufacturer_string(
            SDL_hid_device dev,
            StringRef text,
            int maxlen) {
        Memory buffer = new Memory(maxlen * 2L);
        int result = InternalNativeFunctions.SDL_hid_get_manufacturer_string(dev, buffer, new size_t(maxlen));
        text.setValue(buffer.getWideString(0L));
        return result;
    }

    public static int SDL_hid_get_product_string(
            SDL_hid_device dev,
            StringRef text,
            int maxlen) {
        Memory buffer = new Memory(maxlen * 2L);
        int result = InternalNativeFunctions.SDL_hid_get_product_string(dev, buffer, new size_t(maxlen));
        text.setValue(buffer.getWideString(0L));
        return result;
    }

    public static int SDL_hid_get_serial_number_string(
            SDL_hid_device dev,
            StringRef text,
            int maxlen) {
        Memory buffer = new Memory(maxlen * 2L);
        int result = InternalNativeFunctions.SDL_hid_get_serial_number_string(dev, buffer, new size_t(maxlen));
        text.setValue(buffer.getWideString(0L));
        return result;
    }

    public static int SDL_hid_get_indexed_string(
            SDL_hid_device dev,
            int stringIndex,
            StringRef text,
            int maxlen) {
        Memory buffer = new Memory(maxlen * 2L);
        int result = InternalNativeFunctions.SDL_hid_get_indexed_string(dev, stringIndex, buffer, new size_t(maxlen));
        text.setValue(buffer.getWideString(0L));
        return result;
    }

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
