package org.libsdl.api.version;

import org.junit.jupiter.api.Test;

import static org.libsdl.api.version.SdlVersion.SDL_CheckNativeLibraryMatchesAtLeastJavaBindingsVersion;
import static org.libsdl.api.version.SdlVersion.SDL_GetNativeLibraryVersion;

public final class SdlVersionTest {

    @Test
    public void control() {
        SDL_version libVersion = SDL_GetNativeLibraryVersion();
        System.out.println("Dynamic C library SDL2 version: " + libVersion);

        SDL_version javaBindingsVersion = SDL_GetNativeLibraryVersion();
        System.out.println("Java SDL bindings version: " + javaBindingsVersion);

        System.out.print("Dynamic C library should be of the same or newer version than Java bindings ... ");
        boolean compatible = SDL_CheckNativeLibraryMatchesAtLeastJavaBindingsVersion();
        if (compatible) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }
}
