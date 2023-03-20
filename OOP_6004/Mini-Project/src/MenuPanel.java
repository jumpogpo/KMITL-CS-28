package src;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
    private final MenuPanelButtonListener menuPanelGameAction = new MenuPanelButtonListener();
    private final Font playFont = new Font("Comic Sans MS", Font.BOLD, 45);
    private JLabel backgroundLB;
    private JButton playButton;
    private JFrame frame;
    private GamePanel gamePanel;
    private ControlPanel controlPanel;

    public MenuPanel(JFrame frame) {
        this.frame = frame;
    }

    private void removeComponents() {
        frame.getContentPane().removeAll();

        for (Component c : frame.getContentPane().getComponents()) {
            if (c instanceof ControlPanel) {
                ((ControlPanel) c).removeAll();
                ((ControlPanel) c).revalidate();
            } else if (c instanceof GamePanel) {
                ((GamePanel) c).removeAll();
                ((GamePanel) c).revalidate();
            }
        }
    }

    protected void showMenu() {
        removeComponents();

        FlowLayout layout = new FlowLayout();
        layout.setVgap(265);

        backgroundLB = new JLabel();
        backgroundLB.setIcon(new ImageIcon("src/../picture/Background.png"));

        playButton = new JButton("Play Game");
        playButton.setPreferredSize(new Dimension(460,80));
        playButton.setFont(playFont);
        playButton.setOpaque(false);
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);
        playButton.addActionListener(menuPanelGameAction);

        frame.setContentPane(backgroundLB);
        frame.setLayout(layout);
        frame.add(playButton);
    }

    private void playGame() {
        removeComponents();

        backgroundLB.setIcon(null);
        gamePanel = new GamePanel(frame, this);
        controlPanel = new ControlPanel(gamePanel, this);
        gamePanel.settingGame(controlPanel);

        frame.setLayout(new BorderLayout());
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);
    }

    private class MenuPanelButtonListener  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton) ev.getSource();

            if (source == playButton) {
                playGame();
            }
        }
    }
}