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
        setIcon(questionIcon);
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

            if (source.getIcon() == null || !gamePanel.getGameStatus()) return;

            source.showNumber();

            if (buttonOpened == null) {
                buttonOpened = source;
            } else {
                if (buttonOpened.getText().equals(source.getText())) {
                    buttonOpened.showNumber();
                    buttonOpened = null;
                    alreadyOpen += 2;

                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (alreadyOpen == gamePanel.getButtonAmount()) {
                                if (gamePanel.getLevel() % 5 == 0) gamePanel.increaseButtonAmount();
                                alreadyOpen = 0;
                                gamePanel.increaseLevel();
                                gamePanel.nextGame();
                            }
                        }
                    });

                    timer.setRepeats(false);
                    timer.start();
                } else {
                    gamePanel.setGameStatus(false);

                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            source.hideNumber();
                            buttonOpened.hideNumber();
                            gamePanel.setGameStatus(true);
                            buttonOpened = null;
                        }
                    });

                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }
    }
}