package Graphics.Pages;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import Graphics.Assets;

/*This class is responsible for the start menu, call addComponents() first to avoid null pointer exceptions*/
public class StartMenu implements Page {
    private final JFrame frame;
    private JButton exitButton;
    private JLabel backgroundImageLabel;
    private ImageIcon backgroundImage;

    public StartMenu() {
        frame = new JFrame("Start Menu");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        ImageIcon icon = new ImageIcon("src/Components/Images/logo.png");
        frame.setIconImage(icon.getImage());
    }

    @Override
    public void addComponents() {
        exitButton = new JButton("Exit");
        int buttonWidth = frame.getWidth() / 4;
        int buttonHeight = frame.getHeight() / 10;
        Assets.frameAddButton(frame, exitButton, buttonWidth, buttonHeight);
        backgroundImage = new ImageIcon("src/Components/Images/hahaha.jpg");
        backgroundImageLabel = new JLabel();
        Assets.frameAddImageLabel(frame, backgroundImageLabel, backgroundImage, frame.getWidth(), frame.getHeight());
    }

    @Override
    public void addListeners() {
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                renderPage();
            }
        });
        try {
            exitButton.addActionListener(e -> onExitButtonClicked());
        } catch (NullPointerException ex) {
            System.out.println("Null pointer exception, make sure you've called addComponents() first for the page");
        }
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void hide() {
        frame.setVisible(false);
    }

    @Override
    public void dispose() {
        frame.dispose();
    }

    @Override
    public void renderPage() {
        try {
            Assets.frameCenterButton(frame, exitButton, 0, frame.getHeight() / 4);
            exitButton.setSize(frame.getWidth() / 4, frame.getHeight() / 10);
            Assets.frameSetImage(backgroundImageLabel, backgroundImage, frame.getWidth(), frame.getHeight());
        } catch (NullPointerException ex) {
            System.out.println("Null pointer exception, make sure you've called addComponents() first for the page");
        }
    }

    private void onExitButtonClicked() {
        dispose();
    }
}
