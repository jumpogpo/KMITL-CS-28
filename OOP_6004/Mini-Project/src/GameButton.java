package src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

public class GameButton extends JButton {
    private final Font invisibleFont = new Font("Times New Roman", Font.PLAIN, 0);
    private final Font unInvisibleFont = new Font("Times New Roman", Font.PLAIN, 30);
    private final GameButtonListener gameButtonAction = new GameButtonListener();
    
    private static GameButton buttonOpened = null;
    private static int alreadyOpen = 0;
    private static boolean cooldown = false;
    private GamePanel gamePanel;

    public GameButton(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        GridLayout layout = (GridLayout) gamePanel.getLayout();
        int rows = layout.getRows();
        int columns = layout.getColumns();
        ImageIcon questionIcon = new ImageIcon(new ImageIcon("src/../picture/QuestionMark.png").getImage().getScaledInstance(300 / columns, 200 / rows, Image.SCALE_SMOOTH));
        
        setIcon(questionIcon);
        setPreferredSize(new Dimension(150, 50));
        setFont(invisibleFont);
        addActionListener(gameButtonAction);
    }

    protected void showNumber() {
        setIcon(null);
        setFont(unInvisibleFont);
    }

    protected void hideNumber() {
        GridLayout layout = (GridLayout) gamePanel.getLayout();
        int rows = layout.getRows();
        int columns = layout.getColumns();
        ImageIcon questionIcon = new ImageIcon(new ImageIcon("src/../picture/QuestionMark.png").getImage().getScaledInstance(300 / columns, 200 / rows, Image.SCALE_SMOOTH));
        setFont(invisibleFont);
        setIcon(questionIcon);
    }

    private class GameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            GameButton source = (GameButton) ev.getSource();

            if (source.getIcon() == null || cooldown) return;

            source.showNumber();

            if (buttonOpened == null) {
                buttonOpened = source;
            } else {
                if (buttonOpened.getText().equals(source.getText())) {
                    buttonOpened.showNumber();
                    buttonOpened = null;
                    alreadyOpen += 2;

                    if (alreadyOpen == gamePanel.getButtonAmount()) {
                        gamePanel.setGameFinish(true);
                        gamePanel.setPauseGame(true);
                        alreadyOpen = 0;
                    }
                } else {
                    cooldown = true;

                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            source.hideNumber();
                            buttonOpened.hideNumber();
                            buttonOpened = null;
                            cooldown = false;
                        }
                    });

                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }
    }
}