package net.mcclendo.libjavasdl.loader;

public class NativeLibraryException extends RuntimeException {

    public NativeLibraryException(
            final String msg) {
        super(msg);
    }

    public NativeLibraryException(
            final Throwable cause) {
        super(cause);
    }

    public NativeLibraryException(
            final String msg,
            final Throwable cause) {
        super(msg, cause);
    }
}
