package io.github.libsdl4j.api.rwops;

import com.sun.jna.Pointer;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import io.github.libsdl4j.jna.size_t;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_rwops.h
 *
 * <p>This file provides a general interface for SDL to read and write
 * data streams.  It can easily be extended to files, memory, etc.</p>
 */
public final class SdlRWops {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlRWops.class);
    }

    private SdlRWops() {
    }

    /**
     * Use this function to create a new SDL_RWops structure for reading from
     * and/or writing to a named file.
     *
     * <p>The {@code mode} string is treated roughly the same as in a call to the C
     * library's fopen(), even if SDL doesn't happen to use fopen() behind the
     * scenes.</p>
     *
     * <p>Available {@code mode} strings:</p>
     *
     * <ul>
     *     <li>"r": Open a file for reading. The file must exist.</li>
     *     <li>"w": Create an empty file for writing. If a file with the same name
     *         already exists its content is erased and the file is treated as a new
     *         empty file.</li>
     *     <li>"a": Append to a file. Writing operations append data at the end of the
     *         file. The file is created if it does not exist.</li>
     *     <li>"r+": Open a file for update both reading and writing. The file must
     *         exist.</li>
     *     <li>"w+": Create an empty file for both reading and writing. If a file with
     *         the same name already exists its content is erased and the file is
     *         treated as a new empty file.</li>
     *     <li>"a+": Open a file for reading and appending. All writing operations are
     *         performed at the end of the file, protecting the previous content to be
     *         overwritten. You can reposition (fseek, rewind) the internal pointer to
     *         anywhere in the file for reading, but writing operations will move it
     *         back to the end of file. The file is created if it does not exist.</li>
     * </ul>
     *
     * <p><b>NOTE:</b> In order to open a file as a binary file, a "b" character has to
     * be included in the {@code mode} string. This additional "b" character can either
     * be appended at the end of the string (thus making the following compound
     * modes: "rb", "wb", "ab", "r+b", "w+b", "a+b") or be inserted between the
     * letter and the "+" sign for the mixed modes ("rb+", "wb+", "ab+").
     * Additional characters may follow the sequence, although they should have no
     * effect. For example, "t" is sometimes appended to make explicit the file is
     * a text file.</p>
     *
     * <p>This function supports Unicode filenames, but they must be encoded in UTF-8
     * format, regardless of the underlying operating system.</p>
     *
     * <p>As a fallback, SDL_RWFromFile() will transparently open a matching filename
     * in an Android app's {@code assets}.</p>
     *
     * <p>Closing the SDL_RWops will close the file handle SDL is holding internally.</p>
     *
     * @param file a UTF-8 string representing the filename to open
     * @param mode an ASCII string representing the mode to be used for opening
     *             the file.
     * @return a pointer to the SDL_RWops structure that is created, or null on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_RWclose(SDL_RWops)
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFP(Pointer, boolean)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWread(SDL_RWops, Pointer, size_t, size_t)
     * @see #SDL_RWseek(SDL_RWops, long, int)
     * @see #SDL_RWtell(SDL_RWops)
     * @see #SDL_RWwrite(SDL_RWops, Pointer, size_t, size_t)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_RWops SDL_RWFromFile(
            String file,
            String mode);

    /**
     * Use this function to create an SDL_RWops structure from a standard I/O file
     * pointer (stdio.h's {@code FILE*}).
     *
     * <p><b>Note:</b> This function is not available on Windows, since files opened in an
     * application on that platform cannot be used by a dynamically linked
     * library.</p>
     *
     * <p>On some platforms, the first parameter is a {@code void*}, on others, it's a
     * {@code FILE*}, depending on what system headers are available to SDL. It is
     * always intended to be the {@code FILE*} type from the C runtime's stdio.h.</p>
     *
     * @param fp        the {@code FILE*} that feeds the SDL_RWops stream
     * @param autoclose true to close the {@code FILE*} when closing the SDL_RWops,
     *                  false to leave the {@code FILE*} open when the RWops is
     *                  closed
     * @return an {@link SDL_RWops} structure that is created, or null on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_RWclose(SDL_RWops)
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFile(String, String)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWread(SDL_RWops, Pointer, size_t, size_t)
     * @see #SDL_RWseek(SDL_RWops, long, int)
     * @see #SDL_RWtell(SDL_RWops)
     * @see #SDL_RWwrite(SDL_RWops, Pointer, size_t, size_t)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_RWops SDL_RWFromFP(
            Pointer fp,
            boolean autoclose);

    /**
     * Use this function to prepare a read-write memory buffer for use with
     * SDL_RWops.
     *
     * <p>This function sets up an SDL_RWops struct based on a memory area of a
     * certain size, for both read and write access.</p>
     *
     * <p>This memory buffer is not copied by the RWops; the pointer you provide must
     * remain valid until you close the stream. Closing the stream will not free
     * the original buffer.</p>
     *
     * <p>If you need to make sure the RWops never writes to the memory buffer, you
     * should use SDL_RWFromConstMem() with a read-only buffer of memory instead.</p>
     *
     * @param mem  a pointer to a buffer to feed an SDL_RWops stream
     * @param size the buffer size, in bytes
     * @return an {@link SDL_RWops} structure, or null if it fails; call
     * SDL_GetError() for more information.
     * @see #SDL_RWclose(SDL_RWops)
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFile(String, String)
     * @see #SDL_RWFromFP(Pointer, boolean)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWread(SDL_RWops, Pointer, size_t, size_t)
     * @see #SDL_RWseek(SDL_RWops, long, int)
     * @see #SDL_RWtell(SDL_RWops)
     * @see #SDL_RWwrite(SDL_RWops, Pointer, size_t, size_t)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_RWops SDL_RWFromMem(
            Pointer mem,
            int size);

    /**
     * Use this function to prepare a read-only memory buffer for use with RWops.
     *
     * <p>This function sets up an SDL_RWops struct based on a memory area of a
     * certain size. It assumes the memory area is not writable.</p>
     *
     * <p>Attempting to write to this RWops stream will report an error without
     * writing to the memory buffer.</p>
     *
     * <p>This memory buffer is not copied by the RWops; the pointer you provide must
     * remain valid until you close the stream. Closing the stream will not free
     * the original buffer.</p>
     *
     * <p>If you need to write to a memory buffer, you should use SDL_RWFromMem()
     * with a writable buffer of memory instead.</p>
     *
     * @param mem  a pointer to a read-only buffer to feed an SDL_RWops stream
     * @param size the buffer size, in bytes
     * @return an {@link SDL_RWops} structure, or null if it fails; call
     * SDL_GetError() for more information.
     * @see #SDL_RWclose(SDL_RWops)
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFile(String, String)
     * @see #SDL_RWFromFP(Pointer, boolean)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWread(SDL_RWops, Pointer, size_t, size_t)
     * @see #SDL_RWseek(SDL_RWops, long, int)
     * @see #SDL_RWtell(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_RWops SDL_RWFromConstMem(
            Pointer mem,
            int size);

    /**
     * Use this function to allocate an empty, unpopulated SDL_RWops structure.
     *
     * <p>Applications do not need to use this function unless they are providing
     * their own SDL_RWops implementation. If you just need a SDL_RWops to
     * read/write a common data source, you should use the built-in
     * implementations in SDL, like SDL_RWFromFile() or SDL_RWFromMem(), etc.</p>
     *
     * <p>You must free the returned pointer with SDL_FreeRW(). Depending on your
     * operating system and compiler, there may be a difference between the
     * malloc() and free() your program uses and the versions SDL calls
     * internally. Trying to mix the two can cause crashing such as segmentation
     * faults. Since all SDL_RWops must free themselves when their **close**
     * method is called, all SDL_RWops must be allocated through this function, so
     * they can all be freed correctly with SDL_FreeRW().</p>
     *
     * @return a pointer to the allocated memory on success, or null on failure;
     * call SDL_GetError() for more information.
     * @see #SDL_FreeRW(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_RWops SDL_AllocRW();

    /**
     * Use this function to free an SDL_RWops structure allocated by
     * SDL_AllocRW().
     *
     * <p>Applications do not need to use this function unless they are providing
     * their own SDL_RWops implementation. If you just need a SDL_RWops to
     * read/write a common data source, you should use the built-in
     * implementations in SDL, like SDL_RWFromFile() or SDL_RWFromMem(), etc, and
     * call the {@code close} method on those SDL_RWops pointers when you are done
     * with them.</p>
     *
     * <p>Only use SDL_FreeRW() on pointers returned by SDL_AllocRW(). The pointer is
     * invalid as soon as this function returns. Any extra memory allocated during
     * creation of the SDL_RWops is not freed by SDL_FreeRW(); the programmer must
     * be responsible for managing that memory in their {@code close} method.</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param area the SDL_RWops structure to be freed
     * @see #SDL_AllocRW()
     * @since This function is available since SDL 2.0.0.
     */
    public static void SDL_FreeRW(
            SDL_RWops area) {
        // Actual deallocation must always be called on a pointer,
        // If it was called on a com.sun.jna.Structure (SDL_RWops), JNA would, after the native method call,
        // read from the memory to update the SDL_RWops object and it would fail.
        // Therefore, extract the pointer and re-call the raw native method.
        Pointer mem = area.getPointer();
        SDL_FreeRW(mem);
    }

    /**
     * Use this function to free an SDL_RWops structure allocated by
     * SDL_AllocRW().
     *
     * <p>Applications do not need to use this function unless they are providing
     * their own SDL_RWops implementation. If you just need a SDL_RWops to
     * read/write a common data source, you should use the built-in
     * implementations in SDL, like SDL_RWFromFile() or SDL_RWFromMem(), etc, and
     * call the {@code close} method on those SDL_RWops pointers when you are done
     * with them.</p>
     *
     * <p>Only use SDL_FreeRW() on pointers returned by SDL_AllocRW(). The pointer is
     * invalid as soon as this function returns. Any extra memory allocated during
     * creation of the SDL_RWops is not freed by SDL_FreeRW(); the programmer must
     * be responsible for managing that memory in their {@code close} method.</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_FreeRW(SDL_RWops)}.</p>
     *
     * @param area the SDL_RWops structure to be freed
     * @see #SDL_AllocRW()
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_FreeRW(
            Pointer area);

    /**
     * Use this function to get the size of the data stream in an SDL_RWops.
     *
     * @param context the SDL_RWops to get the size of the data stream from
     * @return the size of the data stream in the SDL_RWops on success, -1 if
     * unknown or a negative error code on failure; call SDL_GetError()
     * for more information.
     * @since This function is available since SDL 2.0.10.
     */
    public static native long SDL_RWsize(
            SDL_RWops context);

    /**
     * Seek within an SDL_RWops data stream.
     *
     * <p>This function seeks to byte {@code offset}, relative to {@code whence}.</p>
     *
     * <p>{@code whence} may be any of the following values:</p>
     *
     * <ul>
     *     <li>{@code RW_SEEK_SET}: seek from the beginning of data</li>
     *     <li>{@code RW_SEEK_CUR}: seek relative to current read point</li>
     *     <li>{@code RW_SEEK_END}: seek relative to the end of data</li>
     * </ul>
     *
     * <p>If this stream can not seek, it will return -1.</p>
     *
     * <p>SDL_RWseek() is actually a wrapper function that calls the SDL_RWops's
     * {@code seek} method appropriately, to simplify application development.</p>
     *
     * @param context a pointer to an SDL_RWops structure
     * @param offset  an offset in bytes, relative to **whence** location; can be
     *                negative
     * @param whence  any of {@code RW_SEEK_SET}, {@code RW_SEEK_CUR}, {@code RW_SEEK_END}
     * @return the final offset in the data stream after the seek or -1 on error.
     * @see #SDL_RWclose(SDL_RWops)
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFile(String, String)
     * @see #SDL_RWFromFP(Pointer, boolean)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWread(SDL_RWops, Pointer, size_t, size_t)
     * @see #SDL_RWtell(SDL_RWops)
     * @see #SDL_RWwrite(SDL_RWops, Pointer, size_t, size_t)
     * @since This function is available since SDL 2.0.10.
     */
    public static native long SDL_RWseek(
            SDL_RWops context,
            long offset,
            @MagicConstant(valuesFromClass = SdlRWopsSeekType.class) int whence);

    /**
     * Determine the current read/write offset in an SDL_RWops data stream.
     *
     * <p>SDL_RWtell is actually a wrapper function that calls the SDL_RWops's {@code seek}
     * method, with an offset of 0 bytes from {@code RW_SEEK_CUR}, to simplify
     * application development.</p>
     *
     * @param context a SDL_RWops data stream object from which to get the current
     *                offset
     * @return the current offset in the stream, or -1 if the information can not
     * be determined.
     * @see #SDL_RWclose(SDL_RWops)
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFile(String, String)
     * @see #SDL_RWFromFP(Pointer, boolean)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWread(SDL_RWops, Pointer, size_t, size_t)
     * @see #SDL_RWseek(SDL_RWops, long, int)
     * @see #SDL_RWwrite(SDL_RWops, Pointer, size_t, size_t)
     * @since This function is available since SDL 2.0.10.
     */
    public static native long SDL_RWtell(
            SDL_RWops context);

    /**
     * Read from a data source.
     *
     * <p>This function reads up to {@code maxnum} objects each of size {@code size} from the
     * data source to the area pointed at by {@code ptr}. This function may read less
     * objects than requested. It will return zero when there has been an error or
     * the data stream is completely read.</p>
     *
     * <p>SDL_RWread() is actually a function wrapper that calls the SDL_RWops's
     * {@code read} method appropriately, to simplify application development.</p>
     *
     * @param context  a pointer to an SDL_RWops structure
     * @param ptr      a pointer to a buffer to read data into
     * @param itemSize the size of each object to read, in bytes
     * @param maxnum   the maximum number of objects to be read
     * @return the number of objects read, or 0 at error or end of file; call
     * SDL_GetError() for more information.
     * @see #SDL_RWclose(SDL_RWops)
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFile(String, String)
     * @see #SDL_RWFromFP(Pointer, boolean)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWseek(SDL_RWops, long, int)
     * @see #SDL_RWwrite(SDL_RWops, Pointer, size_t, size_t)
     * @since This function is available since SDL 2.0.10.
     */
    public static native size_t SDL_RWread(
            SDL_RWops context,
            Pointer ptr,
            size_t itemSize,
            size_t maxnum);

    /**
     * Write to an SDL_RWops data stream.
     *
     * <p>This function writes exactly {@code num} objects each of size {@code size} from the
     * area pointed at by {@code ptr} to the stream. If this fails for any reason, it'll
     * return less than {@code num} to demonstrate how far the write progressed. On
     * success, it returns {@code num}.</p>
     *
     * <p>SDL_RWwrite is actually a function wrapper that calls the SDL_RWops's
     * {@code write} method appropriately, to simplify application development.</p>
     *
     * @param context  a pointer to an SDL_RWops structure
     * @param ptr      a pointer to a buffer containing data to write
     * @param itemSize the size of an object to write, in bytes
     * @param num      the number of objects to write
     * @return the number of objects written, which will be less than **num** on
     * error; call SDL_GetError() for more information.
     * @see #SDL_RWclose(SDL_RWops)
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFile(String, String)
     * @see #SDL_RWFromFP(Pointer, boolean)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWread(SDL_RWops, Pointer, size_t, size_t)
     * @see #SDL_RWseek(SDL_RWops, long, int)
     * @since This function is available since SDL 2.0.10.
     */
    public static native size_t SDL_RWwrite(
            SDL_RWops context,
            Pointer ptr,
            size_t itemSize,
            size_t num);

    /**
     * Close and free an allocated SDL_RWops structure.
     *
     * <p>SDL_RWclose() closes and cleans up the SDL_RWops stream. It releases any
     * resources used by the stream and frees the SDL_RWops itself with
     * SDL_FreeRW(). This returns 0 on success, or -1 if the stream failed to
     * flush to its output (e.g. to disk).</p>
     *
     * <p>Note that if this fails to flush the stream to disk, this function reports
     * an error, but the SDL_RWops is still invalid once this function returns.</p>
     *
     * @param context SDL_RWops structure to close
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFile(String, String)
     * @see #SDL_RWFromFP(Pointer, boolean)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWread(SDL_RWops, Pointer, size_t, size_t)
     * @see #SDL_RWseek(SDL_RWops, long, int)
     * @see #SDL_RWwrite(SDL_RWops, Pointer, size_t, size_t)
     * @since This function is available since SDL 2.0.10.
     */
    public static int SDL_RWclose(
            SDL_RWops context) {
        // Actual deallocation must always be called on a pointer,
        // If it was called on a com.sun.jna.Structure (SDL_RWops), JNA would, after the native method call,
        // read from the memory to update the SDL_RWops object and it would fail.
        // Therefore, extract the pointer and re-call the raw native method.
        Pointer mem = context.getPointer();
        return SDL_RWclose(mem);
    }

    /**
     * Close and free an allocated SDL_RWops structure.
     *
     * <p>SDL_RWclose() closes and cleans up the SDL_RWops stream. It releases any
     * resources used by the stream and frees the SDL_RWops itself with
     * SDL_FreeRW(). This returns 0 on success, or -1 if the stream failed to
     * flush to its output (e.g. to disk).</p>
     *
     * <p>Note that if this fails to flush the stream to disk, this function reports
     * an error, but the SDL_RWops is still invalid once this function returns.</p>
     *
     * @param context SDL_RWops structure to close
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RWFromConstMem(Pointer, int)
     * @see #SDL_RWFromFile(String, String)
     * @see #SDL_RWFromFP(Pointer, boolean)
     * @see #SDL_RWFromMem(Pointer, int)
     * @see #SDL_RWread(SDL_RWops, Pointer, size_t, size_t)
     * @see #SDL_RWseek(SDL_RWops, long, int)
     * @see #SDL_RWwrite(SDL_RWops, Pointer, size_t, size_t)
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RWclose(
            Pointer context);

    /**
     * Load all the data from an SDL data stream.
     *
     * <p>The data is allocated with a zero byte at the end (null terminated) for
     * convenience. This extra byte is not included in the value reported via
     * {@code datasize}.</p>
     *
     * <p>The data should be freed with SDL_free().</p>
     *
     * @param src      the SDL_RWops to read all available data from
     * @param datasize if not null, will store the number of bytes read
     * @param freesrc  if non-zero, calls SDL_RWclose() on {@code src} before returning
     * @return the data, or null if there was an error.
     * @since This function is available since SDL 2.0.6.
     */
    public static native Pointer SDL_LoadFile_RW(
            SDL_RWops src,
            size_t.Ref datasize,
            int freesrc);

    /**
     * Load all the data from a file path.
     *
     * <p>The data is allocated with a zero byte at the end (null terminated) for
     * convenience. This extra byte is not included in the value reported via
     * {@code datasize}.</p>
     *
     * <p>The data should be freed with SDL_free().</p>
     *
     * @param file     the path to read all available data from
     * @param datasize if not null, will store the number of bytes read
     * @return the data, or null if there was an error.
     * @since This function is available since SDL 2.0.10.
     */
    public static native Pointer SDL_LoadFile(
            String file,
            size_t.Ref datasize);

    /**
     * Use this function to read a byte from an SDL_RWops.
     *
     * @param src the SDL_RWops to read from
     * @return the read byte on success or 0 on failure; call SDL_GetError() for
     * more information.
     * @see #SDL_WriteU8(SDL_RWops, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native byte SDL_ReadU8(
            SDL_RWops src);

    /**
     * Use this function to read 16 bits of little-endian data from an SDL_RWops
     * and return in native format.
     *
     * <p>SDL byteswaps the data only if necessary, so the data returned will be in
     * the native byte order.</p>
     *
     * @param src the stream from which to read data
     * @return 16 bits of data in the native byte order of the platform.
     * @see #SDL_ReadBE16(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native short SDL_ReadLE16(
            SDL_RWops src);

    /**
     * Use this function to read 16 bits of big-endian data from an SDL_RWops and
     * return in native format.
     *
     * <p>SDL byteswaps the data only if necessary, so the data returned will be in
     * the native byte order.</p>
     *
     * @param src the stream from which to read data
     * @return 16 bits of data in the native byte order of the platform.
     * @see #SDL_ReadLE16(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native short SDL_ReadBE16(
            SDL_RWops src);

    /**
     * Use this function to read 32 bits of little-endian data from an SDL_RWops
     * and return in native format.
     *
     * <p>SDL byteswaps the data only if necessary, so the data returned will be in
     * the native byte order.</p>
     *
     * @param src the stream from which to read data
     * @return 32 bits of data in the native byte order of the platform.
     * @see #SDL_ReadBE32(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_ReadLE32(
            SDL_RWops src);

    /**
     * Use this function to read 32 bits of big-endian data from an SDL_RWops and
     * return in native format.
     *
     * <p>SDL byteswaps the data only if necessary, so the data returned will be in
     * the native byte order.</p>
     *
     * @param src the stream from which to read data
     * @return 32 bits of data in the native byte order of the platform.
     * @see #SDL_ReadLE32(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_ReadBE32(
            SDL_RWops src);

    /**
     * Use this function to read 64 bits of little-endian data from an SDL_RWops
     * and return in native format.
     *
     * <p>SDL byteswaps the data only if necessary, so the data returned will be in
     * the native byte order.</p>
     *
     * @param src the stream from which to read data
     * @return 64 bits of data in the native byte order of the platform.
     * @see #SDL_ReadBE64(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native long SDL_ReadLE64(
            SDL_RWops src);

    /**
     * Use this function to read 64 bits of big-endian data from an SDL_RWops and
     * return in native format.
     *
     * <p>SDL byteswaps the data only if necessary, so the data returned will be in
     * the native byte order.</p>
     *
     * @param src the stream from which to read data
     * @return 64 bits of data in the native byte order of the platform.
     * @see #SDL_ReadLE64(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native long SDL_ReadBE64(
            SDL_RWops src);

    /**
     * Use this function to write a byte to an SDL_RWops.
     *
     * @param dst   the SDL_RWops to write to
     * @param value the byte value to write
     * @return 1 on success or 0 on failure; call SDL_GetError() for more
     * information.
     * @see #SDL_ReadU8(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native size_t SDL_WriteU8(
            SDL_RWops dst,
            byte value);

    /**
     * Use this function to write 16 bits in native format to a SDL_RWops as
     * little-endian data.
     *
     * <p>SDL byteswaps the data only if necessary, so the application always
     * specifies native format, and the data written will be in little-endian
     * format.</p>
     *
     * @param dst   the stream to which data will be written
     * @param value the data to be written, in native format
     * @return 1 on successful write, 0 on error.
     * @see #SDL_WriteBE16(SDL_RWops, short)
     * @since This function is available since SDL 2.0.0.
     */
    public static native size_t SDL_WriteLE16(
            SDL_RWops dst,
            short value);

    /**
     * Use this function to write 16 bits in native format to a SDL_RWops as
     * big-endian data.
     *
     * <p>SDL byteswaps the data only if necessary, so the application always
     * specifies native format, and the data written will be in big-endian format.</p>
     *
     * @param dst   the stream to which data will be written
     * @param value the data to be written, in native format
     * @return 1 on successful write, 0 on error.
     * @see #SDL_WriteLE16(SDL_RWops, short)
     * @since This function is available since SDL 2.0.0.
     */
    public static native size_t SDL_WriteBE16(
            SDL_RWops dst,
            short value);

    /**
     * Use this function to write 32 bits in native format to a SDL_RWops as
     * little-endian data.
     *
     * <p>SDL byteswaps the data only if necessary, so the application always
     * specifies native format, and the data written will be in little-endian
     * format.</p>
     *
     * @param dst   the stream to which data will be written
     * @param value the data to be written, in native format
     * @return 1 on successful write, 0 on error.
     * @see #SDL_WriteBE32(SDL_RWops, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native size_t SDL_WriteLE32(
            SDL_RWops dst,
            int value);

    /**
     * Use this function to write 32 bits in native format to a SDL_RWops as
     * big-endian data.
     *
     * <p>SDL byteswaps the data only if necessary, so the application always
     * specifies native format, and the data written will be in big-endian format.</p>
     *
     * @param dst   the stream to which data will be written
     * @param value the data to be written, in native format
     * @return 1 on successful write, 0 on error.
     * @see #SDL_WriteLE32(SDL_RWops, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native size_t SDL_WriteBE32(
            SDL_RWops dst,
            int value);

    /**
     * Use this function to write 64 bits in native format to a SDL_RWops as
     * little-endian data.
     *
     * <p>SDL byteswaps the data only if necessary, so the application always
     * specifies native format, and the data written will be in little-endian
     * format.</p>
     *
     * @param dst   the stream to which data will be written
     * @param value the data to be written, in native format
     * @return 1 on successful write, 0 on error.
     * @see #SDL_WriteBE64(SDL_RWops, long)
     * @since This function is available since SDL 2.0.0.
     */
    public static native size_t SDL_WriteLE64(
            SDL_RWops dst,
            long value);

    /**
     * Use this function to write 64 bits in native format to a SDL_RWops as
     * big-endian data.
     *
     * <p>SDL byteswaps the data only if necessary, so the application always
     * specifies native format, and the data written will be in big-endian format.</p>
     *
     * @param dst   the stream to which data will be written
     * @param value the data to be written, in native format
     * @return 1 on successful write, 0 on error.
     * @see #SDL_WriteLE64(SDL_RWops, long)
     * @since This function is available since SDL 2.0.0.
     */
    public static native size_t SDL_WriteBE64(
            SDL_RWops dst,
            long value);
}
