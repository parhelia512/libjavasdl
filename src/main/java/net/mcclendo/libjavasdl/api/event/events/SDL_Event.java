package net.mcclendo.libjavasdl.api.event.events;

import com.sun.jna.Union;

@SuppressWarnings("checkstyle:classfanoutcomplexity")
public final class SDL_Event extends Union {

    public int type;
    public SDL_CommonEvent common;
    public SDL_WindowEvent window;
    public SDL_KeyboardEvent key;
    public SDL_TextEditingSdlStructure edit;
    public SDL_TextInputSdlStructure text;
    public SDL_MouseMotionEvent motion;
    public SDL_MouseButtonEvent button;
    public SDL_MouseWheelEvent wheel;
    public SDL_JoyAxisEvent jaxis;
    public SDL_JoyBallEvent jball;
    public SDL_JoyHatEvent jhat;
    public SDL_JoyButtonEvent jbutton;
    public SDL_JoyDeviceEvent jdevice;
    public SDL_ControllerAxisEvent caxis;
    public SDL_ControllerButtonEvent cbutton;
    public SDL_ControllerDeviceEvent cdevice;
    public SDL_AudioDeviceEvent adevice;
    public SDL_QuitEvent quit;
    public SDL_OSEvent os;
    public SDL_UserEvent user;
    public SDL_SysWMEvent syswm;
    public SDL_TouchFingerSdlStructure tfinger;
    public SDL_MultiGestureEvent mgesture;
    public SDL_DollarGestureEvent dgesture;
    public SDL_DropEvent drop;
}
