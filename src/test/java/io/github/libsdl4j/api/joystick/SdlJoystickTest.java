package io.github.libsdl4j.api.joystick;

import com.sun.jna.ptr.ShortByReference;
import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.Sdl.SDL_Init;
import static io.github.libsdl4j.api.Sdl.SDL_Quit;
import static io.github.libsdl4j.api.SdlSubSystemConst.SDL_INIT_EVERYTHING;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_QUERY;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickClose;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickEventState;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickGetAxis;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickGetAxisInitialState;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickGetButton;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickGetDeviceGUID;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickGetGUID;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickGetGUIDFromString;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickGetGUIDString;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickIsVirtual;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickNameForIndex;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickNumAxes;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickNumBalls;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickNumButtons;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickNumHats;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickOpen;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickUpdate;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_NumJoysticks;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class SdlJoystickTest {

    public static void main(String[] args) throws InterruptedException {
        SDL_Init(SDL_INIT_EVERYTHING);

        int joysticksCount = SDL_NumJoysticks();
        System.out.println("Number of joysticks: " + joysticksCount);

        if (joysticksCount > 0) {
            String joystickName = SDL_JoystickNameForIndex(0);
            System.out.println("Joystick name: " + joystickName);

            SDL_JoystickGUID joystickGUID1 = SDL_JoystickGetDeviceGUID(0);
            System.out.println("Joystick GUID: " + joystickGUID1);

            String joystickGUID1Text = SDL_JoystickGetGUIDString(joystickGUID1);
            System.out.println("Joystick GUID as text: " + joystickGUID1Text);

            SDL_Joystick joystick = SDL_JoystickOpen(0);

            SDL_JoystickGUID joystickGUID2 = SDL_JoystickGetGUID(joystick);
            System.out.println("Joystick GUID (alternative way): " + joystickGUID2);

            System.out.println("Is Virtual: " + SDL_JoystickIsVirtual(0));

            int axisCount = SDL_JoystickNumAxes(joystick);
            System.out.println("Number of available axis: " + axisCount);

            int trackBallCount = SDL_JoystickNumBalls(joystick);
            System.out.println("Number of available trackballs: " + trackBallCount);

            int hatsCount = SDL_JoystickNumHats(joystick);
            System.out.println("Number of available POV hats: " + hatsCount);

            int buttonsCount = SDL_JoystickNumButtons(joystick);
            System.out.println("Number of available buttons: " + buttonsCount);

            SDL_JoystickEventState(SDL_QUERY);
            for (int axisNumber = 0; axisNumber < axisCount; axisNumber++) {
                ShortByReference state1 = new ShortByReference((short) 0);
                SDL_JoystickGetAxisInitialState(joystick, axisNumber, state1);
                System.out.println("Axis " + axisNumber + " initial state: " + state1.getValue());
            }

            for (int i = 0; i < 2000; i++) {
                System.out.printf("\rTime: %tT", System.currentTimeMillis());
                SDL_JoystickUpdate();
                for (int axisNumber = 0; axisNumber < axisCount; axisNumber++) {
                    short state = SDL_JoystickGetAxis(joystick, axisNumber);
                    System.out.printf(", Axis %d: %s ", axisNumber, state);
                }
                for (int buttonNumber = 0; buttonNumber < buttonsCount; buttonNumber++) {
                    byte state = SDL_JoystickGetButton(joystick, buttonNumber);
                    System.out.printf(", Button %d: %s ", buttonNumber, state);
                }
                System.out.flush();
                Thread.sleep(10L);
            }
            System.out.println();

            SDL_JoystickClose(joystick);
        }

        SDL_Quit();
    }

    @Test
    public void guidConversionShouldWorkBothWays() {
        SDL_Init(0);

        SDL_JoystickGUID guid1 = new SDL_JoystickGUID();
        guid1.mostSigBits = 0xAABBCCDDEEFF1122L;
        guid1.leastSigBits = 0x3344556677889900L;

        String guidText = SDL_JoystickGetGUIDString(guid1);
        assertEquals("00998877665544332211ffeeddccbbaa", guidText);

        SDL_JoystickGUID guid2 = SDL_JoystickGetGUIDFromString(guidText);
        assertEquals(guid1.mostSigBits, guid2.mostSigBits);
        assertEquals(guid1.leastSigBits, guid2.leastSigBits);

        SDL_Quit();
    }
}
