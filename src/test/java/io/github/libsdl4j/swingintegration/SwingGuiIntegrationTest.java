package io.github.libsdl4j.swingintegration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import io.github.libsdl4j.api.rect.SDL_Rect;
import io.github.libsdl4j.api.surface.SDL_Surface;
import io.github.libsdl4j.api.video.SDL_Window;

import static io.github.libsdl4j.api.Sdl.SDL_Init;
import static io.github.libsdl4j.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static io.github.libsdl4j.api.surface.SdlSurface.SDL_FillRect;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_CreateWindowFrom;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_GetWindowSurface;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_UpdateWindowSurface;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class SwingGuiIntegrationTest {

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame window = new JFrame("Test");
        window.setLayout(new BorderLayout());
        Panel mainPanel = new Panel();
        mainPanel.setBackground(null);
        window.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setPreferredSize(new Dimension(400, 300));
        mainPanel.setMinimumSize(new Dimension(400, 300));
        mainPanel.setMaximumSize(new Dimension(400, 300));

        JToolBar toolbarPanel = new JToolBar();
        JButton openFileButton = new JButton(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("io/github/libsdl4j/swingintegration/open-file-icon-24.png")));
        JButton saveFileButton = new JButton(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("io/github/libsdl4j/swingintegration/save-file-icon-24.png")));
        openFileButton.setFocusable(false);
        openFileButton.setBorder(new EmptyBorder(8, 8, 8, 8));
        toolbarPanel.add(openFileButton);
        saveFileButton.setFocusable(false);
        saveFileButton.setBorder(new EmptyBorder(8, 8, 8, 8));
        toolbarPanel.add(saveFileButton);
        window.add(toolbarPanel, BorderLayout.NORTH);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.setVisible(true);

        Pointer nativePanelHandle = Native.getComponentPointer(mainPanel);

        SDL_Init(SDL_INIT_VIDEO);
        SDL_Window sdlPanel = SDL_CreateWindowFrom(nativePanelHandle);
        SDL_Surface surface = SDL_GetWindowSurface(sdlPanel);
        SDL_Rect backgroundRect = new SDL_Rect();
        backgroundRect.x = 20;
        backgroundRect.y = 40;
        backgroundRect.w = 120;
        backgroundRect.h = 200;
        SDL_FillRect(surface, backgroundRect, 0x00FF00FF);
        SDL_UpdateWindowSurface(sdlPanel);
    }

}
