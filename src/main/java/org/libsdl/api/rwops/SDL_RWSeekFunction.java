package org.libsdl.api.rwops;

import com.sun.jna.Callback;
import org.intellij.lang.annotations.MagicConstant;

@FunctionalInterface
public interface SDL_RWSeekFunction extends Callback {

    long size(
            SDL_RWops context,
            long offset,
            @MagicConstant(valuesFromClass = SdlRWopsConst.class) int whence);
}
