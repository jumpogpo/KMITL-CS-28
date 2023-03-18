package src;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Dimension;

class ControlPanel extends JPanel {
    private final JButton newGameButton;
    private final JLabel gameLevelLb, timeRemainingLb;
    private final NewGameButtonListener newGameAction;
    private final GamePanel gamePanel;
    private Timer countDownTimer;

    public ControlPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        newGameAction = new NewGameButtonListener();

        newGameButton = new JButton("New Game");
        newGameButton.setPreferredSize(new Dimension(150, 40));
        newGameButton.addActionListener(newGameAction);

        gameLevelLb = new JLabel("Level: " + gamePanel.getLevel());
        gameLevelLb.setPreferredSize(new Dimension(65, 50));
        gameLevelLb.setForeground(Color.WHITE);

        timeRemainingLb = new JLabel("Time Remaining: " + gamePanel.getTimeRemaining());
        timeRemainingLb.setPreferredSize(new Dimension(150, 50));
        timeRemainingLb.setBounds(500, 50, 100, 50);
        timeRemainingLb.setForeground(Color.WHITE);

        setBackground(new java.awt.Color(33, 33, 33));
        add(newGameButton);
        add(gameLevelLb);
        add(timeRemainingLb);
    }

    protected void setTimeRemainingLB(int time) {
        timeRemainingLb.setText("Time Remaining: " + time);
    }

    protected void setLevelLB(int level) {
        gameLevelLb.setText("Level: " + level);
    }

    protected void timer() {        
        countDownTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int timeRemaining = gamePanel.getTimeRemaining();

                if (gamePanel.getGameStatus()) return;
                if (timeRemaining > 0) {
                    gamePanel.setTimeRemaining(timeRemaining - 1);
                    setTimeRemainingLB(gamePanel.getTimeRemaining());
                } else {
                    gamePanel.newGame();
                }
            }
        });

        countDownTimer.start();
    }

    private class NewGameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            gamePanel.newGame();
            setTimeRemainingLB(gamePanel.getTimeRemaining());
            setLevelLB(gamePanel.getLevel());
        }
    }
}