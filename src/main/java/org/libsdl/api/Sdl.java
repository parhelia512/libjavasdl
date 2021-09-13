package org.libsdl.api;

import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

/**
 * @apiNote Native functions are always defined in a private static nested class
 * and public methods from the enclosing class delegate to them.
 * This is for a number of reasons:
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

    // TODO: Revise String freeing after use
    // TODO: Revise @MagicConstant in the delegating methods

    public static int SDL_Init(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeLoader.loadSdl2Library();
        return NativeFunctions.SDL_Init(flags);
    }

    public static int SDL_InitSubSystem(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeLoader.loadSdl2Library();
        return NativeFunctions.SDL_InitSubSystem(flags);
    }

    @MagicConstant(flagsFromClass = SDL_SubSystem.class)
    public static int SDL_WasInit(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeLoader.loadSdl2Library();
        return NativeFunctions.SDL_WasInit(flags);
    }

    public static void SDL_Quit() {
        NativeFunctions.SDL_Quit();
    }

    public static void SDL_QuitSubSystem(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeFunctions.SDL_QuitSubSystem(flags);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        static native int SDL_Init(
                @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags);

        static native int SDL_InitSubSystem(
                @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags);

        @MagicConstant(flagsFromClass = SDL_SubSystem.class)
        static native int SDL_WasInit(
                @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags);

        static native void SDL_Quit();

        static native void SDL_QuitSubSystem(
                @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags);
    }
}
