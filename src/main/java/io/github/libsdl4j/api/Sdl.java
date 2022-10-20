package io.github.libsdl4j.api;

import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

/**
 * <p><b>Implementation note:</b> Native functions in this class are defined in a private static nested class
 * and public methods from the enclosing class delegate to them.</p>
 *
 * <p>This is for a number of reasons:</p>
 * <ul>
 *     <li>Function signatures are not very Java idiomatic and public methods can do a basic translation
 *         (enums, pointers to Strings, etc.)</li>
 *     <li>A class with native static functions need to register itself to the JNA
 *         in its static initialization block. Execution of the block is triggered
 *         the first time any symbol is requested from the class.
 *         Including referencing a constant. That wouldn't matter too much
 *         if the very first registration also didn't trigger loading of the DLL library to memory
 *         - which can fail for various reasons. Therefore, separating the native functions
 *         to an internal class allows SDL_Init() to trigger the DLL loading explicitly and report any errors.</li>
 * </ul>
 */
public final class Sdl {

    private Sdl() {
    }

    public static int SDL_Init(
            @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags) {
        return InternalNativeFunctions.SDL_Init(flags);
    }

    public static int SDL_InitSubSystem(
            @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags) {
        return InternalNativeFunctions.SDL_InitSubSystem(flags);
    }

    @MagicConstant(flagsFromClass = SdlSubSystemConst.class)
    public static int SDL_WasInit(
            @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags) {
        return InternalNativeFunctions.SDL_WasInit(flags);
    }

    public static void SDL_Quit() {
        InternalNativeFunctions.SDL_Quit();
    }

    public static void SDL_QuitSubSystem(
            @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags) {
        InternalNativeFunctions.SDL_QuitSubSystem(flags);
    }

    private static final class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native int SDL_Init(
                @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

        public static native int SDL_InitSubSystem(
                @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

        @MagicConstant(flagsFromClass = SdlSubSystemConst.class)
        public static native int SDL_WasInit(
                @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

        public static native void SDL_Quit();

        public static native void SDL_QuitSubSystem(
                @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);
    }
}
