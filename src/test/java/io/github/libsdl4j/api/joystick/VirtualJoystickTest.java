package io.github.libsdl4j.api.joystick;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import org.junit.jupiter.api.Test;
import io.github.libsdl4j.api.joystick.virtual.SDL_VirtualJoystickDesc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static io.github.libsdl4j.api.Sdl.SDL_Init;
import static io.github.libsdl4j.api.SdlSubSystemConst.SDL_INIT_EVERYTHING;
import static io.github.libsdl4j.api.gamecontroller.SDL_GameControllerAxis.SDL_CONTROLLER_AXIS_LEFTX;
import static io.github.libsdl4j.api.gamecontroller.SDL_GameControllerAxis.SDL_CONTROLLER_AXIS_RIGHTY;
import static io.github.libsdl4j.api.gamecontroller.SDL_GameControllerButton.SDL_CONTROLLER_BUTTON_A;
import static io.github.libsdl4j.api.gamecontroller.SDL_GameControllerButton.SDL_CONTROLLER_BUTTON_B;
import static io.github.libsdl4j.api.gamecontroller.SDL_GameControllerButton.SDL_CONTROLLER_BUTTON_START;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickAttachVirtualEx;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickClose;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickHasLED;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickHasRumble;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickHasRumbleTriggers;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickOpen;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickRumble;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickRumbleTriggers;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickSendEffect;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickSetLED;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_JoystickSetPlayerIndex;
import static io.github.libsdl4j.api.joystick.SdlJoystick.SDL_NumJoysticks;

public class VirtualJoystickTest {

    @Test
    public void allCallbacksShouldBeNotified() {
        SDL_Init(SDL_INIT_EVERYTHING);

        int joysticksCountBefore = SDL_NumJoysticks();

        SDL_VirtualJoystickDesc desc = new SDL_VirtualJoystickDesc();
        desc.version = SdlJoystickConst.SDL_VIRTUAL_JOYSTICK_DESC_VERSION;
        desc.type = SDL_JoystickType.SDL_JOYSTICK_TYPE_GAMECONTROLLER;
        desc.naxes = 2;
        desc.nbuttons = 3;
        desc.nhats = 1;
        desc.vendorId = 999;
        desc.productId = 999;
        desc.buttonMask = 1 << SDL_CONTROLLER_BUTTON_A | 1 << SDL_CONTROLLER_BUTTON_B | 1 << SDL_CONTROLLER_BUTTON_START;
        desc.axisMask = 1 << SDL_CONTROLLER_AXIS_LEFTX | 1 << SDL_CONTROLLER_AXIS_RIGHTY;
        desc.name = "TestJoystick";
        desc.userdata = new Memory(8L);
        desc.userdata.setLong(0L, 0x1122334455667788L);
        desc.Update = this::assertUpdateInvoked;
        desc.SetPlayerIndex = this::assertSetPlayerIndexInvoked;
        desc.Rumble = this::assertRumbleInvoked;
        desc.RumbleTriggers = this::assertRumbleTriggersInvoked;
        desc.SetLED = this::assetSetLEDInvoked;
        desc.SendEffect = this::assertSendEffectInvoked;
        int deviceIndex = SDL_JoystickAttachVirtualEx(desc);
        assertNotEquals(-1, deviceIndex);

        int joysticksCountAfter = SDL_NumJoysticks();
        assertEquals(joysticksCountBefore + 1, joysticksCountAfter);

        SDL_Joystick joystickDevice = SDL_JoystickOpen(deviceIndex);
        SDL_JoystickSetPlayerIndex(joystickDevice, 2);
        assertTrue(SDL_JoystickHasRumble(joystickDevice));
        SDL_JoystickRumble(joystickDevice, (short) 10, (short) 20, 1000);
        assertTrue(SDL_JoystickHasRumbleTriggers(joystickDevice));
        SDL_JoystickRumbleTriggers(joystickDevice, (short) 30, (short) 40, 1500);
        assertTrue(SDL_JoystickHasLED(joystickDevice));
        SDL_JoystickSetLED(joystickDevice, (byte) 255, (byte) 128, (byte) 0);
        Memory effectData = new Memory(4L);
        effectData.setInt(0L, 0x22446688);
        SDL_JoystickSendEffect(joystickDevice, effectData, (int) effectData.size());

        SDL_JoystickClose(joystickDevice);
    }

    private void assertUpdateInvoked(Pointer userdata) {
        System.out.printf("virtualJoystick.Update(userdata=%x) invoked%n",
                userdata.getLong(0L));
    }

    private void assertSetPlayerIndexInvoked(Pointer userdata, int playerIndex) {
        System.out.printf("virtualJoystick.SetPlayerIndex(userdata=%x, playerIndex=%d) invoked%n",
                userdata.getLong(0L),
                playerIndex);
    }

    private void assertRumbleInvoked(Pointer userdata, short lowFrequencyRumble, short highFrequencyRumble) {
        System.out.printf("virtualJoystick.Rumble(userdata=%x, lowFrequencyRumble=%d, highFrequencyRumble=%d) invoked%n",
                userdata.getLong(0L),
                lowFrequencyRumble,
                highFrequencyRumble);
    }

    private void assertRumbleTriggersInvoked(Pointer userdata, short leftRumble, short rightRumble) {
        System.out.printf("virtualJoystick.RumbleTriggers(userdata=%x, leftRumble=%d, rightRumble=%d) invoked%n",
                userdata.getLong(0L),
                leftRumble,
                rightRumble);
    }

    private void assetSetLEDInvoked(Pointer userdata, byte red, byte green, byte blue) {
        System.out.printf("virtualJoystick.SetLED(userdata=%x, red=%d, green=%d, blue=%d) invoked%n",
                userdata.getLong(0L),
                red & 255,
                green & 255,
                blue & 255);
    }

    private void assertSendEffectInvoked(Pointer userdata, Pointer data, int size) {
        System.out.printf("virtualJoystick.SendEffect(userdata=%x, data=%x, size=%d) invoked%n",
                userdata.getLong(0L),
                data.getInt(0L),
                size);
    }

    @Test
    public void nullCallbacksShouldDenoteMissingFeature() {
        SDL_Init(SDL_INIT_EVERYTHING);

        int joysticksCountBefore = SDL_NumJoysticks();

        SDL_VirtualJoystickDesc desc = new SDL_VirtualJoystickDesc();
        desc.version = SdlJoystickConst.SDL_VIRTUAL_JOYSTICK_DESC_VERSION;
        desc.type = SDL_JoystickType.SDL_JOYSTICK_TYPE_GAMECONTROLLER;
        desc.naxes = 2;
        desc.nbuttons = 3;
        desc.nhats = 1;
        desc.vendorId = 999;
        desc.productId = 999;
        desc.buttonMask = 1 << SDL_CONTROLLER_BUTTON_A;
        desc.axisMask = 1 << SDL_CONTROLLER_AXIS_LEFTX;
        desc.name = "TestJoystick2";
        desc.userdata = new Memory(8L);
        desc.userdata.setLong(0L, 0x2222333344445555L);
        desc.Update = this::assertUpdateInvoked;
        desc.SetPlayerIndex = this::assertSetPlayerIndexInvoked;
        desc.Rumble = null;
        desc.RumbleTriggers = null;
        desc.SetLED = null;
        desc.SendEffect = this::assertSendEffectInvoked;
        int deviceIndex = SDL_JoystickAttachVirtualEx(desc);
        assertNotEquals(-1, deviceIndex);

        int joysticksCountAfter = SDL_NumJoysticks();
        assertEquals(joysticksCountBefore + 1, joysticksCountAfter);

        SDL_Joystick joystickDevice = SDL_JoystickOpen(deviceIndex);
        assertFalse(SDL_JoystickHasRumble(joystickDevice));
        assertFalse(SDL_JoystickHasRumbleTriggers(joystickDevice));
        assertFalse(SDL_JoystickHasLED(joystickDevice));

        SDL_JoystickClose(joystickDevice);
    }
}
