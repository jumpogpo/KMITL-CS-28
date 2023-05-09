package src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

public class GameButton extends JButton {
    private final Font invisibleFont = new Font("Comic Sans MS", Font.BOLD, 0);
    private final Font unInvisibleFont = new Font("Comic Sans MS", Font.BOLD, 30);
    private final GameButtonListener gameButtonAction = new GameButtonListener();
    
    private static GameButton buttonOpened = null;
    private static int alreadyOpen = 0;
    private static boolean cooldown = false;
    private GamePanel gamePanel;
    private MenuPanel menuPanel;

    public GameButton(GamePanel gamePanel, MenuPanel menuPanel) {
        this.gamePanel = gamePanel;
        this.menuPanel = menuPanel;

        GridLayout layout = (GridLayout) gamePanel.getLayout();
        int rows = layout.getRows();
        int columns = layout.getColumns();
        ImageIcon questionIcon = new ImageIcon(new ImageIcon("src/../picture/QuestionMark.png").getImage().getScaledInstance(300 / columns, 200 / rows, Image.SCALE_SMOOTH));
        
        setIcon(questionIcon);
        setPreferredSize(new Dimension(150, 50));
        setFont(invisibleFont);
        addActionListener(gameButtonAction);
        setBorder(BorderFactory.createBevelBorder(0));
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
                        if (gamePanel.getLevel() % 5 == 0) gamePanel.increaseButtonAmount();
                        gamePanel.setGameFinish(true);
                        gamePanel.setPauseGame(true);
                        alreadyOpen = 0;

                        int result = JOptionPane.showOptionDialog(null, "If you want to go next level press 'OK'", "Congratulations!!!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                        
                        if (result == JOptionPane.OK_OPTION) {
                            gamePanel.nextGame();
                        } else {
                            gamePanel.setPauseGame(true);
                            gamePanel.setGameFinish(false);
                            removeAll();
                            revalidate();
                            menuPanel.showMenu();
                        }
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