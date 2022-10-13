package io.github.libsdl4j.api.locale;

import java.util.ArrayList;
import java.util.List;
import com.sun.jna.Pointer;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_free;

/**
 * Definitions from file SDL_locale.h
 *
 * <p>Include file for SDL locale services</p>
 */
public final class SdlLocale {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlLocale.class);
    }

    private SdlLocale() {
    }

    /**
     * Report the user's preferred locale.
     *
     * <p>This returns a list of SDL_Locale structs.</p>
     *
     * <p>Returned language strings are in the format xx, where 'xx' is an ISO-639
     * language specifier (such as "en" for English, "de" for German, etc).
     * Country strings are in the format YY, where "YY" is an ISO-3166 country
     * code (such as "US" for the United States, "CA" for Canada, etc). Country
     * might be null if there's no specific guidance on them (so you might get {
     * "en", "US" } for American English, but { "en", null } means "English
     * language, generically"). Language strings are never null, except to
     * terminate the array.</p>
     *
     * <p>Please note that not all of these strings are 2 characters; some are three
     * or more.</p>
     *
     * <p>The returned list of locales are in the order of the user's preference. For
     * example, a German citizen that is fluent in US English and knows enough
     * Japanese to navigate around Tokyo might have a list like: { "de", "en_US",
     * "jp" }. Someone from England might prefer British English (where
     * "color" is spelled "colour", etc), but will settle for anything like it: {
     * "en_GB", "en" }.</p>
     *
     * <p>This function returns null on error, including when the platform does not
     * supply this information at all.</p>
     *
     * <p>This might be a "slow" call that has to query the operating system. It's
     * best to ask for this once and save the results. However, this list can
     * change, usually because the user has changed a system preference outside of
     * your program; SDL will send an SDL_LOCALECHANGED event in this case, if
     * possible, and you can call this function again to get an updated copy of
     * preferred locales.</p>
     *
     * @return list of locales. Will return null on error.
     * @since This function is available since SDL 2.0.14.
     */
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
     * Report the user's preferred locale.
     *
     * <p>This returns an array of SDL_Locale structs, the final item zeroed out.
     * When the caller is done with this array, it should call SDL_free() on the
     * returned value; all the memory involved is allocated in a single block, so
     * a single SDL_free() will suffice.</p>
     *
     * <p>Returned language strings are in the format xx, where 'xx' is an ISO-639
     * language specifier (such as "en" for English, "de" for German, etc).
     * Country strings are in the format YY, where "YY" is an ISO-3166 country
     * code (such as "US" for the United States, "CA" for Canada, etc). Country
     * might be null if there's no specific guidance on them (so you might get {
     * "en", "US" } for American English, but { "en", null } means "English
     * language, generically"). Language strings are never null, except to
     * terminate the array.</p>
     *
     * <p>Please note that not all of these strings are 2 characters; some are three
     * or more.</p>
     *
     * <p>The returned list of locales are in the order of the user's preference. For
     * example, a German citizen that is fluent in US English and knows enough
     * Japanese to navigate around Tokyo might have a list like: { "de", "en_US",
     * "jp", null }. Someone from England might prefer British English (where
     * "color" is spelled "colour", etc), but will settle for anything like it: {
     * "en_GB", "en", null }.</p>
     *
     * <p>This function returns null on error, including when the platform does not
     * supply this information at all.</p>
     *
     * <p>This might be a "slow" call that has to query the operating system. It's
     * best to ask for this once and save the results. However, this list can
     * change, usually because the user has changed a system preference outside of
     * your program; SDL will send an SDL_LOCALECHANGED event in this case, if
     * possible, and you can call this function again to get an updated copy of
     * preferred locales.</p>
     *
     * @return array of locales, terminated with a locale with a null language
     * field. Will return null on error.
     * @since This function is available since SDL 2.0.14.
     * @deprecated Use more Java-style version {@link #SDL_GetPreferredLocalesList()}
     */
    @Deprecated
    public static native Pointer SDL_GetPreferredLocales();
}
