package io.github.libjsdl.loader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.sun.jna.Library;
import com.sun.jna.Native;

public final class NativeLoader {

    private static final int BUFFER_SIZE = 4096;

    private static final Path PATH_TO_NATIVES = Paths.get("natives");
    private static final Set<NativeLibrary> LOADED_LIBRARIES = new HashSet<>();

    private NativeLoader() {
    }

    public static void loadLibrary(
            final Class<?> nativeClass,
            final NativeLibrary library) {
        if (!LOADED_LIBRARIES.contains(library)) {
            LOADED_LIBRARIES.add(library);

            Arrays.stream(library.getLibFiles()).forEach(l -> {
                NativeLoader.Win64NativeLoader.load(
                        library.getLibraryName(),
                        l);
            });
        }

        Native.register(nativeClass, library.getLibraryName());
    }

    public static <T extends Library> T loadLibrary(
            final Class<?> nativeClass,
            final NativeLibrary library,
            final Class<T> clazz) {
        loadLibrary(nativeClass, library);
        return Native.load(library.getLibraryName(), clazz);
    }

    private static class Win64NativeLoader {

        private static final String WIN64 = "win64";

        @SuppressWarnings("checkstyle:NestedTryDepth")
        private static void load(
                final String libName,
                final String libFile) {
            try {
                final Path libDirPath = Paths.get(
                        PATH_TO_NATIVES.toString(),
                        WIN64,
                        libName);
                Files.createDirectories(libDirPath);
                final Path libFilePath = Paths.get(
                        libDirPath.toString(),
                        libFile);
                try (InputStream in = Win64NativeLoader.class.getResourceAsStream("/natives/win64/" + libName + "/" + libFile)) {
                    try (OutputStream out = new FileOutputStream(libFilePath.toString())) {
                        final byte[] buffer = new byte[BUFFER_SIZE];

                        int bytesRead;
                        while ((bytesRead = in.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                    }
                }

                System.load(libFilePath.toAbsolutePath().toString());
            } catch (final IOException e) {
                throw new NativeLibraryException(e);
            }
        }
    }

    public enum NativeLibrary {
        SDL2("sdl2", new String[]{"SDL2.dll"});

        private final String libraryName;
        private final String[] libFiles;

        NativeLibrary(
                final String libraryName,
                final String[] libFiles) {
            this.libraryName = libraryName;
            this.libFiles = libFiles;
        }

        public String getLibraryName() {
            return this.libraryName;
        }

        public String[] getLibFiles() {
            return this.libFiles;
        }
    }
}
