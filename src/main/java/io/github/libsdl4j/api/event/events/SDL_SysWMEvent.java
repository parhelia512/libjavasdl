package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.syswm.event.SDL_SysWMmsg;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_SYSWMEVENT;

/**
 * A video driver dependent system event (event.syswm.*)
 * This event is disabled by default, you can enable it with SDL_EventState()
 *
 * <p><b>Note:</b> If you want to use this event, you should include SDL_syswm.h.</p>
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "msg"
})
public final class SDL_SysWMEvent extends Structure {

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_SYSWMEVENT SDL_SYSWMEVENT} */
    @MagicConstant(intValues = SDL_SYSWMEVENT)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** driver dependent data, defined in SDL_syswm.h */
    public SDL_SysWMmsg msg;

    public SDL_SysWMEvent() {
    }

    public SDL_SysWMEvent(Pointer p) {
        super(p);
    }
}
