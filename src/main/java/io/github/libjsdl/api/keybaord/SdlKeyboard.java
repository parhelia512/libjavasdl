package io.github.libjsdl.api.keybaord;

import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;

import io.github.libjsdl.api.rect.SDL_Rect;
import io.github.libjsdl.api.video.SDL_Window;
import io.github.libjsdl.loader.NativeLoader;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "checkstyle:ConstantName",
        "checkstyle:AbbreviationAsWordInName"})
public final class SdlKeyboard {

    public static final int SDL_SCANCODE_UNKNOWN = 0;

    public static final int SDL_SCANCODE_A = 4;
    public static final int SDL_SCANCODE_B = 5;
    public static final int SDL_SCANCODE_C = 6;
    public static final int SDL_SCANCODE_D = 7;
    public static final int SDL_SCANCODE_E = 8;
    public static final int SDL_SCANCODE_F = 9;
    public static final int SDL_SCANCODE_G = 10;
    public static final int SDL_SCANCODE_H = 11;
    public static final int SDL_SCANCODE_I = 12;
    public static final int SDL_SCANCODE_J = 13;
    public static final int SDL_SCANCODE_K = 14;
    public static final int SDL_SCANCODE_L = 15;
    public static final int SDL_SCANCODE_M = 16;
    public static final int SDL_SCANCODE_N = 17;
    public static final int SDL_SCANCODE_O = 18;
    public static final int SDL_SCANCODE_P = 19;
    public static final int SDL_SCANCODE_Q = 20;
    public static final int SDL_SCANCODE_R = 21;
    public static final int SDL_SCANCODE_S = 22;
    public static final int SDL_SCANCODE_T = 23;
    public static final int SDL_SCANCODE_U = 24;
    public static final int SDL_SCANCODE_V = 25;
    public static final int SDL_SCANCODE_W = 26;
    public static final int SDL_SCANCODE_X = 27;
    public static final int SDL_SCANCODE_Y = 28;
    public static final int SDL_SCANCODE_Z = 29;

    public static final int SDL_SCANCODE_1 = 30;
    public static final int SDL_SCANCODE_2 = 31;
    public static final int SDL_SCANCODE_3 = 32;
    public static final int SDL_SCANCODE_4 = 33;
    public static final int SDL_SCANCODE_5 = 34;
    public static final int SDL_SCANCODE_6 = 35;
    public static final int SDL_SCANCODE_7 = 36;
    public static final int SDL_SCANCODE_8 = 37;
    public static final int SDL_SCANCODE_9 = 38;
    public static final int SDL_SCANCODE_0 = 39;

    public static final int SDL_SCANCODE_RETURN = 40;
    public static final int SDL_SCANCODE_ESCAPE = 41;
    public static final int SDL_SCANCODE_BACKSPACE = 42;
    public static final int SDL_SCANCODE_TAB = 43;
    public static final int SDL_SCANCODE_SPACE = 44;

    public static final int SDL_SCANCODE_MINUS = 45;
    public static final int SDL_SCANCODE_EQUALS = 46;
    public static final int SDL_SCANCODE_LEFTBRACKET = 47;
    public static final int SDL_SCANCODE_RIGHTBRACKET = 48;
    public static final int SDL_SCANCODE_BACKSLASH = 49;
    public static final int SDL_SCANCODE_NONUSHASH = 50;
    public static final int SDL_SCANCODE_SEMICOLON = 51;
    public static final int SDL_SCANCODE_APOSTROPHE = 52;
    public static final int SDL_SCANCODE_GRAVE = 53;
    public static final int SDL_SCANCODE_COMMA = 54;
    public static final int SDL_SCANCODE_PERIOD = 55;
    public static final int SDL_SCANCODE_SLASH = 56;

    public static final int SDL_SCANCODE_CAPSLOCK = 57;

    public static final int SDL_SCANCODE_F1 = 58;
    public static final int SDL_SCANCODE_F2 = 59;
    public static final int SDL_SCANCODE_F3 = 60;
    public static final int SDL_SCANCODE_F4 = 61;
    public static final int SDL_SCANCODE_F5 = 62;
    public static final int SDL_SCANCODE_F6 = 63;
    public static final int SDL_SCANCODE_F7 = 64;
    public static final int SDL_SCANCODE_F8 = 65;
    public static final int SDL_SCANCODE_F9 = 66;
    public static final int SDL_SCANCODE_F10 = 67;
    public static final int SDL_SCANCODE_F11 = 68;
    public static final int SDL_SCANCODE_F12 = 69;

    public static final int SDL_SCANCODE_PRINTSCREEN = 70;
    public static final int SDL_SCANCODE_SCROLLLOCK = 71;
    public static final int SDL_SCANCODE_PAUSE = 72;
    public static final int SDL_SCANCODE_INSERT = 73;
    public static final int SDL_SCANCODE_HOME = 74;
    public static final int SDL_SCANCODE_PAGEUP = 75;
    public static final int SDL_SCANCODE_DELETE = 76;
    public static final int SDL_SCANCODE_END = 77;
    public static final int SDL_SCANCODE_PAGEDOWN = 78;
    public static final int SDL_SCANCODE_RIGHT = 79;
    public static final int SDL_SCANCODE_LEFT = 80;
    public static final int SDL_SCANCODE_DOWN = 81;
    public static final int SDL_SCANCODE_UP = 82;

    public static final int SDL_SCANCODE_NUMLOCKCLEAR = 83;
    public static final int SDL_SCANCODE_KP_DIVIDE = 84;
    public static final int SDL_SCANCODE_KP_MULTIPLY = 85;
    public static final int SDL_SCANCODE_KP_MINUS = 86;
    public static final int SDL_SCANCODE_KP_PLUS = 87;
    public static final int SDL_SCANCODE_KP_ENTER = 88;
    public static final int SDL_SCANCODE_KP_1 = 89;
    public static final int SDL_SCANCODE_KP_2 = 90;
    public static final int SDL_SCANCODE_KP_3 = 91;
    public static final int SDL_SCANCODE_KP_4 = 92;
    public static final int SDL_SCANCODE_KP_5 = 93;
    public static final int SDL_SCANCODE_KP_6 = 94;
    public static final int SDL_SCANCODE_KP_7 = 95;
    public static final int SDL_SCANCODE_KP_8 = 96;
    public static final int SDL_SCANCODE_KP_9 = 97;
    public static final int SDL_SCANCODE_KP_0 = 98;
    public static final int SDL_SCANCODE_KP_PERIOD = 99;

    public static final int SDL_SCANCODE_NONUSBACKSLASH = 100;
    public static final int SDL_SCANCODE_APPLICATION = 101;
    public static final int SDL_SCANCODE_POWER = 102;
    public static final int SDL_SCANCODE_KP_EQUALS = 103;
    public static final int SDL_SCANCODE_F13 = 104;
    public static final int SDL_SCANCODE_F14 = 105;
    public static final int SDL_SCANCODE_F15 = 106;
    public static final int SDL_SCANCODE_F16 = 107;
    public static final int SDL_SCANCODE_F17 = 108;
    public static final int SDL_SCANCODE_F18 = 109;
    public static final int SDL_SCANCODE_F19 = 110;
    public static final int SDL_SCANCODE_F20 = 111;
    public static final int SDL_SCANCODE_F21 = 112;
    public static final int SDL_SCANCODE_F22 = 113;
    public static final int SDL_SCANCODE_F23 = 114;
    public static final int SDL_SCANCODE_F24 = 115;
    public static final int SDL_SCANCODE_EXECUTE = 116;
    public static final int SDL_SCANCODE_HELP = 117;
    public static final int SDL_SCANCODE_MENU = 118;
    public static final int SDL_SCANCODE_SELECT = 119;
    public static final int SDL_SCANCODE_STOP = 120;
    public static final int SDL_SCANCODE_AGAIN = 121;
    public static final int SDL_SCANCODE_UNDO = 122;
    public static final int SDL_SCANCODE_CUT = 123;
    public static final int SDL_SCANCODE_COPY = 124;
    public static final int SDL_SCANCODE_PASTE = 125;
    public static final int SDL_SCANCODE_FIND = 126;
    public static final int SDL_SCANCODE_MUTE = 127;
    public static final int SDL_SCANCODE_VOLUMEUP = 128;
    public static final int SDL_SCANCODE_VOLUMEDOWN = 129;

    public static final int SDL_SCANCODE_KP_COMMA = 133;
    public static final int SDL_SCANCODE_KP_EQUALSAS400 = 134;

    public static final int SDL_SCANCODE_INTERNATIONAL1 = 135;
    public static final int SDL_SCANCODE_INTERNATIONAL2 = 136;
    public static final int SDL_SCANCODE_INTERNATIONAL3 = 137;
    public static final int SDL_SCANCODE_INTERNATIONAL4 = 138;
    public static final int SDL_SCANCODE_INTERNATIONAL5 = 139;
    public static final int SDL_SCANCODE_INTERNATIONAL6 = 140;
    public static final int SDL_SCANCODE_INTERNATIONAL7 = 141;
    public static final int SDL_SCANCODE_INTERNATIONAL8 = 142;
    public static final int SDL_SCANCODE_INTERNATIONAL9 = 143;
    public static final int SDL_SCANCODE_LANG1 = 144;
    public static final int SDL_SCANCODE_LANG2 = 145;
    public static final int SDL_SCANCODE_LANG3 = 146;
    public static final int SDL_SCANCODE_LANG4 = 147;
    public static final int SDL_SCANCODE_LANG5 = 148;
    public static final int SDL_SCANCODE_LANG6 = 149;
    public static final int SDL_SCANCODE_LANG7 = 150;
    public static final int SDL_SCANCODE_LANG8 = 151;
    public static final int SDL_SCANCODE_LANG9 = 152;

    public static final int SDL_SCANCODE_ALTERASE = 153;
    public static final int SDL_SCANCODE_SYSREQ = 154;
    public static final int SDL_SCANCODE_CANCEL = 155;
    public static final int SDL_SCANCODE_CLEAR = 156;
    public static final int SDL_SCANCODE_PRIOR = 157;
    public static final int SDL_SCANCODE_RETURN2 = 158;
    public static final int SDL_SCANCODE_SEPARATOR = 159;
    public static final int SDL_SCANCODE_OUT = 160;
    public static final int SDL_SCANCODE_OPER = 161;
    public static final int SDL_SCANCODE_CLEARAGAIN = 162;
    public static final int SDL_SCANCODE_CRSEL = 163;
    public static final int SDL_SCANCODE_EXSEL = 164;

    public static final int SDL_SCANCODE_KP_00 = 176;
    public static final int SDL_SCANCODE_KP_000 = 177;
    public static final int SDL_SCANCODE_THOUSANDSSEPARATOR = 178;
    public static final int SDL_SCANCODE_DECIMALSEPARATOR = 179;
    public static final int SDL_SCANCODE_CURRENCYUNIT = 180;
    public static final int SDL_SCANCODE_CURRENCYSUBUNIT = 181;
    public static final int SDL_SCANCODE_KP_LEFTPAREN = 182;
    public static final int SDL_SCANCODE_KP_RIGHTPAREN = 183;
    public static final int SDL_SCANCODE_KP_LEFTBRACE = 184;
    public static final int SDL_SCANCODE_KP_RIGHTBRACE = 185;
    public static final int SDL_SCANCODE_KP_TAB = 186;
    public static final int SDL_SCANCODE_KP_BACKSPACE = 187;
    public static final int SDL_SCANCODE_KP_A = 188;
    public static final int SDL_SCANCODE_KP_B = 189;
    public static final int SDL_SCANCODE_KP_C = 190;
    public static final int SDL_SCANCODE_KP_D = 191;
    public static final int SDL_SCANCODE_KP_E = 192;
    public static final int SDL_SCANCODE_KP_F = 193;
    public static final int SDL_SCANCODE_KP_XOR = 194;
    public static final int SDL_SCANCODE_KP_POWER = 195;
    public static final int SDL_SCANCODE_KP_PERCENT = 196;
    public static final int SDL_SCANCODE_KP_LESS = 197;
    public static final int SDL_SCANCODE_KP_GREATER = 198;
    public static final int SDL_SCANCODE_KP_AMPERSAND = 199;
    public static final int SDL_SCANCODE_KP_DBLAMPERSAND = 200;
    public static final int SDL_SCANCODE_KP_VERTICALBAR = 201;
    public static final int SDL_SCANCODE_KP_DBLVERTICALBAR = 202;
    public static final int SDL_SCANCODE_KP_COLON = 203;
    public static final int SDL_SCANCODE_KP_HASH = 204;
    public static final int SDL_SCANCODE_KP_SPACE = 205;
    public static final int SDL_SCANCODE_KP_AT = 206;
    public static final int SDL_SCANCODE_KP_EXCLAM = 207;
    public static final int SDL_SCANCODE_KP_MEMSTORE = 208;
    public static final int SDL_SCANCODE_KP_MEMRECALL = 209;
    public static final int SDL_SCANCODE_KP_MEMCLEAR = 210;
    public static final int SDL_SCANCODE_KP_MEMADD = 211;
    public static final int SDL_SCANCODE_KP_MEMSUBTRACT = 212;
    public static final int SDL_SCANCODE_KP_MEMMULTIPLY = 213;
    public static final int SDL_SCANCODE_KP_MEMDIVIDE = 214;
    public static final int SDL_SCANCODE_KP_PLUSMINUS = 215;
    public static final int SDL_SCANCODE_KP_CLEAR = 216;
    public static final int SDL_SCANCODE_KP_CLEARENTRY = 217;
    public static final int SDL_SCANCODE_KP_BINARY = 218;
    public static final int SDL_SCANCODE_KP_OCTAL = 219;
    public static final int SDL_SCANCODE_KP_DECIMAL = 220;
    public static final int SDL_SCANCODE_KP_HEXADECIMAL = 221;

    public static final int SDL_SCANCODE_LCTRL = 224;
    public static final int SDL_SCANCODE_LSHIFT = 225;
    public static final int SDL_SCANCODE_LALT = 226;
    public static final int SDL_SCANCODE_LGUI = 227;
    public static final int SDL_SCANCODE_RCTRL = 228;
    public static final int SDL_SCANCODE_RSHIFT = 229;
    public static final int SDL_SCANCODE_RALT = 230;
    public static final int SDL_SCANCODE_RGUI = 231;

    public static final int SDL_SCANCODE_MODE = 257;

    public static final int SDL_SCANCODE_AUDIONEXT = 258;
    public static final int SDL_SCANCODE_AUDIOPREV = 259;
    public static final int SDL_SCANCODE_AUDIOSTOP = 260;
    public static final int SDL_SCANCODE_AUDIOPLAY = 261;
    public static final int SDL_SCANCODE_AUDIOMUTE = 262;
    public static final int SDL_SCANCODE_MEDIASELECT = 263;
    public static final int SDL_SCANCODE_WWW = 264;
    public static final int SDL_SCANCODE_MAIL = 265;
    public static final int SDL_SCANCODE_CALCULATOR = 266;
    public static final int SDL_SCANCODE_COMPUTER = 267;
    public static final int SDL_SCANCODE_AC_SEARCH = 268;
    public static final int SDL_SCANCODE_AC_HOME = 269;
    public static final int SDL_SCANCODE_AC_BACK = 270;
    public static final int SDL_SCANCODE_AC_FORWARD = 271;
    public static final int SDL_SCANCODE_AC_STOP = 272;
    public static final int SDL_SCANCODE_AC_REFRESH = 273;
    public static final int SDL_SCANCODE_AC_BOOKMARKS = 274;

    public static final int SDL_SCANCODE_BRIGHTNESSDOWN = 275;
    public static final int SDL_SCANCODE_BRIGHTNESSUP = 276;
    public static final int SDL_SCANCODE_DISPLAYSWITCH = 277;
    public static final int SDL_SCANCODE_KBDILLUMTOGGLE = 278;
    public static final int SDL_SCANCODE_KBDILLUMDOWN = 279;
    public static final int SDL_SCANCODE_KBDILLUMUP = 280;
    public static final int SDL_SCANCODE_EJECT = 281;
    public static final int SDL_SCANCODE_SLEEP = 282;

    public static final int SDL_SCANCODE_APP1 = 283;
    public static final int SDL_SCANCODE_APP2 = 284;

    public static final int SDL_SCANCODE_AUDIOREWIND = 285;
    public static final int SDL_SCANCODE_AUDIOFASTFORWARD = 286;
    public static final int SDL_NUM_SCANCODES = 512;

    public static final int SDLK_SCANCODE_MASK = 1 << 30;

    public static final int SDLK_UNKNOWN = 0;

    public static final int SDLK_RETURN = '\r';
    public static final int SDLK_ESCAPE = '\033';
    public static final int SDLK_BACKSPACE = '\b';
    public static final int SDLK_TAB = '\t';
    public static final int SDLK_SPACE = ' ';
    public static final int SDLK_EXCLAIM = '!';
    public static final int SDLK_QUOTEDBL = '"';
    public static final int SDLK_HASH = '#';
    public static final int SDLK_PERCENT = '%';
    public static final int SDLK_DOLLAR = '$';
    public static final int SDLK_AMPERSAND = '&';
    public static final int SDLK_QUOTE = '\'';
    public static final int SDLK_LEFTPAREN = '(';
    public static final int SDLK_RIGHTPAREN = ')';
    public static final int SDLK_ASTERISK = '*';
    public static final int SDLK_PLUS = '+';
    public static final int SDLK_COMMA = ';';
    public static final int SDLK_MINUS = '-';
    public static final int SDLK_PERIOD = '.';
    public static final int SDLK_SLASH = '/';
    public static final int SDLK_0 = '0';
    public static final int SDLK_1 = '1';
    public static final int SDLK_2 = '2';
    public static final int SDLK_3 = '3';
    public static final int SDLK_4 = '4';
    public static final int SDLK_5 = '5';
    public static final int SDLK_6 = '6';
    public static final int SDLK_7 = '7';
    public static final int SDLK_8 = '8';
    public static final int SDLK_9 = '9';
    public static final int SDLK_COLON = ':';
    public static final int SDLK_SEMICOLON = ';';
    public static final int SDLK_LESS = '<';
    public static final int SDLK_EQUALS = '=';
    public static final int SDLK_GREATER = '>';
    public static final int SDLK_QUESTION = '?';
    public static final int SDLK_AT = '@';

    public static final int SDLK_LEFTBRACKET = '[';
    public static final int SDLK_BACKSLASH = '\\';
    public static final int SDLK_RIGHTBRACKET = ']';
    public static final int SDLK_CARET = '^';
    public static final int SDLK_UNDERSCORE = '_';
    public static final int SDLK_BACKQUOTE = '`';
    public static final int SDLK_a = 'a';
    public static final int SDLK_b = 'b';
    public static final int SDLK_c = 'c';
    public static final int SDLK_d = 'd';
    public static final int SDLK_e = 'e';
    public static final int SDLK_f = 'f';
    public static final int SDLK_g = 'g';
    public static final int SDLK_h = 'h';
    public static final int SDLK_i = 'i';
    public static final int SDLK_j = 'j';
    public static final int SDLK_k = 'k';
    public static final int SDLK_l = 'l';
    public static final int SDLK_m = 'm';
    public static final int SDLK_n = 'n';
    public static final int SDLK_o = 'o';
    public static final int SDLK_p = 'p';
    public static final int SDLK_q = 'q';
    public static final int SDLK_r = 'r';
    public static final int SDLK_s = 's';
    public static final int SDLK_t = 't';
    public static final int SDLK_u = 'u';
    public static final int SDLK_v = 'v';
    public static final int SDLK_w = 'w';
    public static final int SDLK_x = 'x';
    public static final int SDLK_y = 'y';
    public static final int SDLK_z = 'z';

    public static final int SDLK_CAPSLOCK = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_CAPSLOCK);

    public static final int SDLK_F1 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F1);
    public static final int SDLK_F2 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F2);
    public static final int SDLK_F3 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F3);
    public static final int SDLK_F4 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F4);
    public static final int SDLK_F5 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F5);
    public static final int SDLK_F6 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F6);
    public static final int SDLK_F7 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F7);
    public static final int SDLK_F8 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F8);
    public static final int SDLK_F9 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F9);
    public static final int SDLK_F10 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F10);
    public static final int SDLK_F11 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F11);
    public static final int SDLK_F12 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F12);

    public static final int SDLK_PRINTSCREEN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_PRINTSCREEN);
    public static final int SDLK_SCROLLLOCK = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_SCROLLLOCK);
    public static final int SDLK_PAUSE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_PAUSE);
    public static final int SDLK_INSERT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_INSERT);
    public static final int SDLK_HOME = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_HOME);
    public static final int SDLK_PAGEUP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_PAGEUP);
    public static final int SDLK_DELETE = '\177';
    public static final int SDLK_END = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_END);
    public static final int SDLK_PAGEDOWN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_PAGEDOWN);
    public static final int SDLK_RIGHT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_RIGHT);
    public static final int SDLK_LEFT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_LEFT);
    public static final int SDLK_DOWN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_DOWN);
    public static final int SDLK_UP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_UP);

    public static final int SDLK_NUMLOCKCLEAR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_NUMLOCKCLEAR);
    public static final int SDLK_KP_DIVIDE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_DIVIDE);
    public static final int SDLK_KP_MULTIPLY = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_MULTIPLY);
    public static final int SDLK_KP_MINUS = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_MINUS);
    public static final int SDLK_KP_PLUS = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_PLUS);
    public static final int SDLK_KP_ENTER = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_ENTER);
    public static final int SDLK_KP_1 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_1);
    public static final int SDLK_KP_2 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_2);
    public static final int SDLK_KP_3 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_3);
    public static final int SDLK_KP_4 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_4);
    public static final int SDLK_KP_5 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_5);
    public static final int SDLK_KP_6 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_6);
    public static final int SDLK_KP_7 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_7);
    public static final int SDLK_KP_8 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_8);
    public static final int SDLK_KP_9 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_9);
    public static final int SDLK_KP_0 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_0);
    public static final int SDLK_KP_PERIOD = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_PERIOD);

    public static final int SDLK_APPLICATION = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_APPLICATION);
    public static final int SDLK_POWER = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_POWER);
    public static final int SDLK_KP_EQUALS = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_EQUALS);
    public static final int SDLK_F13 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F13);
    public static final int SDLK_F14 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F14);
    public static final int SDLK_F15 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F15);
    public static final int SDLK_F16 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F16);
    public static final int SDLK_F17 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F17);
    public static final int SDLK_F18 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F18);
    public static final int SDLK_F19 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F19);
    public static final int SDLK_F20 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F20);
    public static final int SDLK_F21 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F21);
    public static final int SDLK_F22 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F22);
    public static final int SDLK_F23 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F23);
    public static final int SDLK_F24 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_F24);
    public static final int SDLK_EXECUTE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_EXECUTE);
    public static final int SDLK_HELP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_HELP);
    public static final int SDLK_MENU = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_MENU);
    public static final int SDLK_SELECT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_SELECT);
    public static final int SDLK_STOP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_STOP);
    public static final int SDLK_AGAIN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AGAIN);
    public static final int SDLK_UNDO = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_UNDO);
    public static final int SDLK_CUT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_CUT);
    public static final int SDLK_COPY = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_COPY);
    public static final int SDLK_PASTE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_PASTE);
    public static final int SDLK_FIND = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_FIND);
    public static final int SDLK_MUTE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_MUTE);
    public static final int SDLK_VOLUMEUP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_VOLUMEUP);
    public static final int SDLK_VOLUMEDOWN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_VOLUMEDOWN);
    public static final int SDLK_KP_COMMA = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_COMMA);
    public static final int SDLK_KP_EQUALSAS400 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_EQUALSAS400);

    public static final int SDLK_ALTERASE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_ALTERASE);
    public static final int SDLK_SYSREQ = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_SYSREQ);
    public static final int SDLK_CANCEL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_CANCEL);
    public static final int SDLK_CLEAR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_CLEAR);
    public static final int SDLK_PRIOR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_PRIOR);
    public static final int SDLK_RETURN2 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_RETURN2);
    public static final int SDLK_SEPARATOR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_SEPARATOR);
    public static final int SDLK_OUT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_OUT);
    public static final int SDLK_OPER = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_OPER);
    public static final int SDLK_CLEARAGAIN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_CLEARAGAIN);
    public static final int SDLK_CRSEL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_CRSEL);
    public static final int SDLK_EXSEL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_EXSEL);

    public static final int SDLK_KP_00 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_00);
    public static final int SDLK_KP_000 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_000);
    public static final int SDLK_THOUSANDSSEPARATOR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_THOUSANDSSEPARATOR);
    public static final int SDLK_DECIMALSEPARATOR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_DECIMALSEPARATOR);
    public static final int SDLK_CURRENCYUNIT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_CURRENCYUNIT);
    public static final int SDLK_CURRENCYSUBUNIT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_CURRENCYSUBUNIT);
    public static final int SDLK_KP_LEFTPAREN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_LEFTPAREN);
    public static final int SDLK_KP_RIGHTPAREN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_RIGHTPAREN);
    public static final int SDLK_KP_LEFTBRACE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_LEFTBRACE);
    public static final int SDLK_KP_RIGHTBRACE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_RIGHTBRACE);
    public static final int SDLK_KP_TAB = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_TAB);
    public static final int SDLK_KP_BACKSPACE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_BACKSPACE);
    public static final int SDLK_KP_A = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_A);
    public static final int SDLK_KP_B = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_B);
    public static final int SDLK_KP_C = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_C);
    public static final int SDLK_KP_D = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_D);
    public static final int SDLK_KP_E = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_E);
    public static final int SDLK_KP_F = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_F);
    public static final int SDLK_KP_XOR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_XOR);
    public static final int SDLK_KP_POWER = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_POWER);
    public static final int SDLK_KP_PERCENT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_PERCENT);
    public static final int SDLK_KP_LESS = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_LESS);
    public static final int SDLK_KP_GREATER = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_GREATER);
    public static final int SDLK_KP_AMPERSAND = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_AMPERSAND);
    public static final int SDLK_KP_DBLAMPERSAND = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_DBLAMPERSAND);
    public static final int SDLK_KP_VERTICALBAR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_VERTICALBAR);
    public static final int SDLK_KP_DBLVERTICALBAR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_DBLVERTICALBAR);
    public static final int SDLK_KP_COLON = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_COLON);
    public static final int SDLK_KP_HASH = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_HASH);
    public static final int SDLK_KP_SPACE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_SPACE);
    public static final int SDLK_KP_AT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_AT);
    public static final int SDLK_KP_EXCLAM = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_EXCLAM);
    public static final int SDLK_KP_MEMSTORE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_MEMSTORE);
    public static final int SDLK_KP_MEMRECALL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_MEMRECALL);
    public static final int SDLK_KP_MEMCLEAR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_MEMCLEAR);
    public static final int SDLK_KP_MEMADD = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_MEMADD);
    public static final int SDLK_KP_MEMSUBTRACT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_MEMSUBTRACT);
    public static final int SDLK_KP_MEMMULTIPLY = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_MEMMULTIPLY);
    public static final int SDLK_KP_MEMDIVIDE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_MEMDIVIDE);
    public static final int SDLK_KP_PLUSMINUS = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_PLUSMINUS);
    public static final int SDLK_KP_CLEAR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_CLEAR);
    public static final int SDLK_KP_CLEARENTRY = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_CLEARENTRY);
    public static final int SDLK_KP_BINARY = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_BINARY);
    public static final int SDLK_KP_OCTAL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_OCTAL);
    public static final int SDLK_KP_DECIMAL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_DECIMAL);
    public static final int SDLK_KP_HEXADECIMAL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KP_HEXADECIMAL);

    public static final int SDLK_LCTRL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_LCTRL);
    public static final int SDLK_LSHIFT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_LSHIFT);
    public static final int SDLK_LALT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_LALT);
    public static final int SDLK_LGUI = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_LGUI);
    public static final int SDLK_RCTRL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_RCTRL);
    public static final int SDLK_RSHIFT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_RSHIFT);
    public static final int SDLK_RALT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_RALT);
    public static final int SDLK_RGUI = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_RGUI);

    public static final int SDLK_MODE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_MODE);

    public static final int SDLK_AUDIONEXT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AUDIONEXT);
    public static final int SDLK_AUDIOPREV = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AUDIOPREV);
    public static final int SDLK_AUDIOSTOP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AUDIOSTOP);
    public static final int SDLK_AUDIOPLAY = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AUDIOPLAY);
    public static final int SDLK_AUDIOMUTE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AUDIOMUTE);
    public static final int SDLK_MEDIASELECT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_MEDIASELECT);
    public static final int SDLK_WWW = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_WWW);
    public static final int SDLK_MAIL = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_MAIL);
    public static final int SDLK_CALCULATOR = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_CALCULATOR);
    public static final int SDLK_COMPUTER = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_COMPUTER);
    public static final int SDLK_AC_SEARCH = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AC_SEARCH);
    public static final int SDLK_AC_HOME = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AC_HOME);
    public static final int SDLK_AC_BACK = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AC_BACK);
    public static final int SDLK_AC_FORWARD = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AC_FORWARD);
    public static final int SDLK_AC_STOP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AC_STOP);
    public static final int SDLK_AC_REFRESH = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AC_REFRESH);
    public static final int SDLK_AC_BOOKMARKS = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AC_BOOKMARKS);

    public static final int SDLK_BRIGHTNESSDOWN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_BRIGHTNESSDOWN);
    public static final int SDLK_BRIGHTNESSUP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_BRIGHTNESSUP);
    public static final int SDLK_DISPLAYSWITCH = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_DISPLAYSWITCH);
    public static final int SDLK_KBDILLUMTOGGLE = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KBDILLUMTOGGLE);
    public static final int SDLK_KBDILLUMDOWN = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KBDILLUMDOWN);
    public static final int SDLK_KBDILLUMUP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_KBDILLUMUP);
    public static final int SDLK_EJECT = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_EJECT);
    public static final int SDLK_SLEEP = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_SLEEP);
    public static final int SDLK_APP1 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_APP1);
    public static final int SDLK_APP2 = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_APP2);

    public static final int SDLK_AUDIOREWIND = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AUDIOREWIND);
    public static final int SDLK_AUDIOFASTFORWARD = SDL_SCANCODE_TO_KEYCODE(SDL_SCANCODE_AUDIOFASTFORWARD);

    public static final int KMOD_NONE = 0x0000;
    public static final int KMOD_LSHIFT = 0x0001;
    public static final int KMOD_RSHIFT = 0x0002;
    public static final int KMOD_LCTRL = 0x0040;
    public static final int KMOD_RCTRL = 0x0080;
    public static final int KMOD_LALT = 0x0100;
    public static final int KMOD_RALT = 0x0200;
    public static final int KMOD_LGUI = 0x0400;
    public static final int KMOD_RGUI = 0x0800;
    public static final int KMOD_NUM = 0x1000;
    public static final int KMOD_CAPS = 0x2000;
    public static final int KMOD_MODE = 0x4000;
    public static final int KMOD_RESERVED = 0x8000;

    public static final int KMOD_CTRL = (KMOD_LCTRL | KMOD_RCTRL);
    public static final int KMOD_SHIFT = (KMOD_LSHIFT | KMOD_RSHIFT);
    public static final int KMOD_ALT = (KMOD_LALT | KMOD_RALT);
    public static final int KMOD_GUI = (KMOD_LGUI | KMOD_RGUI);

    static {
        NativeLoader.registerNativeMethods(SdlKeyboard.class);
    }

    private SdlKeyboard() {
    }

    public static int SDL_SCANCODE_TO_KEYCODE(
            final int x) {
        return (x | SDLK_SCANCODE_MASK);
    }

    public static native SDL_Window SDL_GetKeyboardFocus();

    public static native ByteByReference SDL_GetKeyboardState(
            IntByReference numkeys);

    public static native int SDL_GetModState();

    public static native void SDL_SetModState(
            int modstate);

    public static native int SDL_GetKeyFromScancode(
            int scancode);

    public static native int SDL_GetScancodeFromKey(
            int key);

    public static native String SDL_GetScancodeName(
            int scancode);

    public static native int SDL_GetScancodeFromName(
            String name);

    public static native String SDL_GetKeyName(
            int key);

    public static native int SDL_GetKeyFromName(
            String name);

    public static native void SDL_StartTextInput();

    public static native boolean SDL_IsTextInputActive();

    public static native void SDL_StopTextInput();

    public static native void SDL_SetTextInputRect(
            SDL_Rect rect);

    public static native boolean SDL_HasScreenKeyboardSupport();

    public static native boolean SDL_IsScreenKeyboardShown(
            SDL_Window window);
}
