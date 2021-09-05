package org.libsdl.api.stdinc;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "checkstyle:AbbreviationAsWordInName"
})
public final class SdlStdinc {

    private SdlStdinc() {
    }

    public static int SDL_FOURCC(
            int a,
            int b,
            int c,
            int d) {
        return a | (b << 8) | (c << 16) | (d << 24);
    }

    public static native String SDL_getenv(String name);

    public static native int SDL_setenv(String name, String value, int overwrite);

/*
    // TODO: Test but disable

    public static int sizeOfSizeT() {
        class SizeTRef extends Structure implements Structure.ByValue {
            public Pointer address;
        }
        SizeTRef sizeTRef = new SizeTRef();
        return sizeTRef.size();
    }

    public static class SizeT extends Structure implements Structure.ByValue {
        public byte[] data = new byte[sizeOfSizeT()];
        public void setValue(long newValue) {
            for (int i=0; i<data.length; i++) {
                byte lowestByte = (byte) newValue;
                data[i] = lowestByte;
                newValue = newValue >> 8;
            }
            if (newValue != 0) {
                throw new IllegalArgumentException("Size is too large to be allocated");
            }
        }
    }

    public static native Pointer SDL_malloc(SizeT size);
    public static native Pointer SDL_calloc(int nmemb, SizeT size);
    public static native Pointer SDL_realloc(Pointer mem, SizeT size);
    public static native void SDL_free(Pointer mem);
*/

    /**
     * Get the current set of SDL memory functions
     */
/*
    public static native void SDL_GetMemoryFunctions(PointerByReference malloc_func,
                                                     PointerByReference calloc_func,
                                                     PointerByReference realloc_func,
                                                     PointerByReference free_func);
*/
    /**
     * Replace SDL's memory allocation functions with a custom set
     */
/*
    public static native int SDL_SetMemoryFunctions(Pointer malloc_func,
                                                    Pointer calloc_func,
                                                    Pointer realloc_func,
                                                    Pointer free_func);
*/

    /**
     * Get the number of outstanding (unfreed) allocations
     */
    public static native int SDL_GetNumAllocations();
}
