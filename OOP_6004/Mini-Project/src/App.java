package src;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class App {
    private final JFrame frame;
    private ControlPanel controlPanel;
    private GamePanel gamePanel;

    public App() {
        frame = new JFrame("Match Numbers");
        frame.setSize(700,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        gamePanel = new GamePanel();
        controlPanel = new ControlPanel(gamePanel);
        gamePanel.settingGame(controlPanel);

        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
