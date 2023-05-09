package src;

import javax.swing.JFrame;

public class App {
    private final JFrame frame;
    private MenuPanel menuPanel;

    public App() {
        frame = new JFrame("Match Numbers");
        frame.setSize(700,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        menuPanel = new MenuPanel(frame);
        menuPanel.showMenu();

        frame.setVisible(true);
    }
}
