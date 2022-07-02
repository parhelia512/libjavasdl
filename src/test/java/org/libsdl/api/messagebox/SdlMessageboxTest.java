package org.libsdl.api.messagebox;

import com.sun.jna.ptr.IntByReference;
import org.libsdl.api.error.SdlError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.libsdl.api.messagebox.SDL_MessageBoxButtonFlags.SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT;
import static org.libsdl.api.messagebox.SDL_MessageBoxButtonFlags.SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT;
import static org.libsdl.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_BACKGROUND;
import static org.libsdl.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_BUTTON_BACKGROUND;
import static org.libsdl.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_BUTTON_BORDER;
import static org.libsdl.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_BUTTON_SELECTED;
import static org.libsdl.api.messagebox.SDL_MessageBoxColorType.SDL_MESSAGEBOX_COLOR_TEXT;
import static org.libsdl.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_INFORMATION;
import static org.libsdl.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_WARNING;
import static org.libsdl.api.messagebox.SdlMessagebox.SDL_ShowMessageBox;
import static org.libsdl.api.messagebox.SdlMessagebox.SDL_ShowSimpleMessageBox;

class SdlMessageboxTest {

    // This class does not contain proper @Test methods because it isn't easy to close the message box programatically
    // in an OS portable fashion.
    public static void main(String[] args) {
        SdlMessageboxTest testObject = new SdlMessageboxTest();
        testObject.simpleMessageBoxShouldBeDisplayedEvenWithoutSdlInit();
        testObject.fullMessageBoxShouldBeDisplayedEvenWithoutSdlInit();
    }

    public void simpleMessageBoxShouldBeDisplayedEvenWithoutSdlInit() {
        int result = SDL_ShowSimpleMessageBox(SDL_MESSAGEBOX_INFORMATION, "Test title", "Test message", null);
        assertEquals(result, 0);
    }

    public void fullMessageBoxShouldBeDisplayedEvenWithoutSdlInit() {
        SDL_MessageBoxData data = new SDL_MessageBoxData();
        data.flags = SDL_MESSAGEBOX_WARNING;
        data.window = null;
        data.title = "Test title 2";
        data.message = "Test message 2";
        SDL_MessageBoxButtonData button1 = new SDL_MessageBoxButtonData(
                SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT,
                999,
                "Yes");
        SDL_MessageBoxButtonData button2 = new SDL_MessageBoxButtonData();
        button2.flags = SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT;
        button2.buttonid = 5555;
        button2.text = "No";

        data.setButtons(new SDL_MessageBoxButtonData[]{button1, button2});
        data.colorScheme = new SDL_MessageBoxColorScheme();
        data.colorScheme.setColorFor(SDL_MESSAGEBOX_COLOR_BACKGROUND, new SDL_MessageBoxColor(255, 255, 255));
        data.colorScheme.setColorFor(SDL_MESSAGEBOX_COLOR_TEXT, 0, 0, 0);
        data.colorScheme.setColorFor(SDL_MESSAGEBOX_COLOR_BUTTON_BORDER, 255, 0, 0);
        data.colorScheme.setColorFor(SDL_MESSAGEBOX_COLOR_BUTTON_BACKGROUND, 0, 255, 0);
        data.colorScheme.setColorFor(SDL_MESSAGEBOX_COLOR_BUTTON_SELECTED, 0, 0, 255);
        IntByReference clickedButtonRef = new IntByReference();

        int result = SDL_ShowMessageBox(data, clickedButtonRef);

        assertEquals(result, 0, "Error in SDL call: " + SdlError.SDL_GetError());
        if (clickedButtonRef.getValue() == 999) {
            System.out.println("User clicked Yes (" + clickedButtonRef.getValue() + ")");
        } else if (clickedButtonRef.getValue() == 5555) {
            System.out.println("User clicked No (" + clickedButtonRef.getValue() + ")");
        } else {
            throw new AssertionError("Failed to check which button was clicked on the message box (" + clickedButtonRef.getValue() + ")");
        }
    }
}
