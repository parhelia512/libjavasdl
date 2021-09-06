package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.error.SdlError;
import org.libsdl.api.stdinc.size_t;
import org.libsdl.jna.NativeLoader;

public final class SdlRWops {

    static {
        NativeLoader.registerNativeMethods(SdlRWops.class);
    }

    private SdlRWops() {
    }

    public static native SDL_RWops SDL_RWFromFile(
            String file,
            String mode);

    /**
     * Use this function to create an {@link SDL_RWops} structure from a standard I/O file pointer (stdio.h's {@code FILE*}).
     *
     * @param fp        the {@code FILE*} descriptor that feeds the {@link SDL_RWops} stream
     * @param autoclose {@code true} to close the {@code FILE*} when closing the {@link SDL_RWops},
     *                  {@code false} to leave the {@code FILE*} open when the RWops is closed
     * @return Returns a {@link SDL_RWops} structure that is created, or {@code null} on failure;
     * call {@link SdlError#SDL_GetError()} for more information.
     * @apiNote This function is not available on Windows,
     * since files opened in an application on that platform cannot be used by a dynamically linked library.
     */
    public static native SDL_RWops SDL_RWFromFP(
            Pointer fp,
            boolean autoclose);

    public static native SDL_RWops SDL_RWFromMem(
            Pointer mem,
            int size);

    public static native SDL_RWops SDL_RWFromConstMem(
            Pointer mem,
            int size);

    public static native SDL_RWops SDL_AllocRW();

    public static native void SDL_FreeRW(
            SDL_RWops area);

    public static native long SDL_RWsize(
            SDL_RWops context);

    public static native long SDL_RWseek(
            SDL_RWops context,
            long offset,
            @MagicConstant(valuesFromClass = SdlRWopsConst.class) int whence);

    public static native long SDL_RWtell(
            SDL_RWops context);

    public static native size_t SDL_RWread(
            SDL_RWops context,
            Pointer ptr,
            size_t itemSize,
            size_t maxnum);

    public static native size_t SDL_RWwrite(
            SDL_RWops context,
            Pointer ptr,
            size_t size,
            size_t num);

    public static native int SDL_RWclose(
            SDL_RWops context);

    public static native Pointer SDL_LoadFile_RW(
            SDL_RWops src,
            size_t.Ref datasize,
            int freesrc);

    public static native Pointer SDL_LoadFile(
            String file,
            size_t.Ref datasize);

    public static native byte SDL_ReadU8(
            SDL_RWops src);

    public static native short SDL_ReadLE16(
            SDL_RWops src);

    public static native short SDL_ReadBE16(
            SDL_RWops src);

    public static native int SDL_ReadLE32(
            SDL_RWops src);

    public static native int SDL_ReadBE32(
            SDL_RWops src);

    public static native long SDL_ReadLE64(
            SDL_RWops src);

    public static native long SDL_ReadBE64(
            SDL_RWops src);

    public static native size_t SDL_WriteU8(
            SDL_RWops dst,
            byte value);

    public static native size_t SDL_WriteLE16(
            SDL_RWops dst,
            short value);

    public static native size_t SDL_WriteBE16(
            SDL_RWops dst,
            short value);

    public static native size_t SDL_WriteLE32(
            SDL_RWops dst,
            int value);

    public static native size_t SDL_WriteBE32(
            SDL_RWops dst,
            int value);

    public static native size_t SDL_WriteLE64(
            SDL_RWops dst,
            long value);

    public static native size_t SDL_WriteBE64(
            SDL_RWops dst,
            long value);
}
