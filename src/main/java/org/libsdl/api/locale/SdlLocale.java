package org.libsdl.api.locale;

import java.util.ArrayList;
import java.util.List;
import com.sun.jna.Pointer;
import org.libsdl.jna.SdlNativeLibraryLoader;

public final class SdlLocale {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlLocale.class);
    }

    private SdlLocale() {
    }

    public static List<SDL_Locale> SDL_GetPreferredLocalesList() {
        Pointer localeArrayPointer = SDL_GetPreferredLocales();
        if (localeArrayPointer == null) {
            return null;
        }
        Pointer localePointer = localeArrayPointer;
        List<SDL_Locale> localesList = new ArrayList<>();
        while (true) {
            SDL_Locale locale = new SDL_Locale(localePointer);
            locale.read();
            if (locale.language == null) break;
            localesList.add(locale);
            localePointer = localePointer.share(locale.size());
        }
        SDL_free(localeArrayPointer);
        return localesList;
    }

    /**
     * @deprecated Use more Java-style version {@link #SDL_GetPreferredLocalesList()}
     */
    @SuppressWarnings("DeprecatedIsStillUsed")
    @Deprecated
    public static native Pointer SDL_GetPreferredLocales();
}
