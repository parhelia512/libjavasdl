package org.libsdl.api.locale;

import java.util.ArrayList;
import java.util.List;
import com.sun.jna.Pointer;
import org.libsdl.jna.NativeLoader;

public class SdlLocale {

    static {
        NativeLoader.registerNativeMethods(SdlLocale.class);
    }

    private SdlLocale() {
    }

    public static List<SDL_Locale> SDL_GetPreferredLocalesList() {
        Pointer locales = SDL_GetPreferredLocales();
        List<SDL_Locale> localesList= new ArrayList<>();
        while (true) {
            SDL_Locale locale = new SDL_Locale(locales);
            locale.read();
            if (locale.language == null) break;
            localesList.add(locale);
            locales = locales.getPointer(locale.size());
        }
        return localesList;
    }

    public static native Pointer SDL_GetPreferredLocales();
}
