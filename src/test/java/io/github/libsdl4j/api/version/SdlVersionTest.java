package io.github.libsdl4j.api.version;

import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.version.SdlVersion.SDL_CheckNativeLibraryMatchesAtLeastJavaBindingsVersion;
import static io.github.libsdl4j.api.version.SdlVersion.SDL_GetJavaBindingsVersion;
import static io.github.libsdl4j.api.version.SdlVersion.SDL_GetNativeLibraryVersion;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class SdlVersionTest {

    @Test
    public void testCheckVersion() {
        SDL_version libVersion = SDL_GetNativeLibraryVersion();
        System.out.println("Dynamic C library SDL2 version: " + libVersion);

        SDL_version javaBindingsVersion = SDL_GetNativeLibraryVersion();
        System.out.println("Java SDL bindings version: " + javaBindingsVersion);

        boolean compatible = SDL_CheckNativeLibraryMatchesAtLeastJavaBindingsVersion();
        assertTrue(compatible, "Dynamic C library should be of the same or newer version than Java bindings ... ");
    }

    @Test
    public void versionsShouldMatchDuringDevelopment() {
        SDL_version libVersion = SDL_GetNativeLibraryVersion();
        System.out.println("Dynamic C library SDL2 version: " + libVersion);

        SDL_version javaBindingsVersion = SDL_GetJavaBindingsVersion();
        System.out.println("Java SDL bindings version: " + javaBindingsVersion);

        assertEquals(javaBindingsVersion, libVersion, "Dynamic C library must be of the same version as the Java bindings:");
    }
}
