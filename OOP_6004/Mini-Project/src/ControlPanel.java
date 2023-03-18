package src;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

class ControlPanel extends JPanel {
    private final JButton newGameButton, nextGameButton;
    private final JLabel gameLevelLb, timeRemainingLb;
    private final ControlPanelButtonListener controlPanelGameAction;
    private final GamePanel gamePanel;
    private final Font mainFont = new Font("Times New Roman", Font.PLAIN, 18);
    private Timer countDownTimer;
    
    public ControlPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        controlPanelGameAction = new ControlPanelButtonListener();
    
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(controlPanelGameAction);
        newGameButton.setFont(mainFont);
    
        nextGameButton = new JButton("Next Game");
        nextGameButton.addActionListener(controlPanelGameAction);
        nextGameButton.setFont(mainFont);
    
        timeRemainingLb = new JLabel(String.valueOf(gamePanel.getTimeRemaining()));
        timeRemainingLb.setBounds(500, 50, 100, 50);
        timeRemainingLb.setForeground(Color.RED);
        timeRemainingLb.setFont(mainFont);

        gameLevelLb = new JLabel("Level: " + gamePanel.getLevel());
        gameLevelLb.setPreferredSize(new Dimension(65, 50));
        gameLevelLb.setForeground(Color.WHITE);
        gameLevelLb.setFont(mainFont);
    
        setBackground(new java.awt.Color(33, 33, 33));
        setLayout(new BorderLayout());
    
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(newGameButton);
        buttonBox.add(nextGameButton);
    
        Box timeAndLevelBox = Box.createHorizontalBox();
        timeAndLevelBox.add(Box.createHorizontalStrut(100));
        timeAndLevelBox.add(timeRemainingLb);
        timeAndLevelBox.add(Box.createHorizontalGlue());
        timeAndLevelBox.add(gameLevelLb);
        timeAndLevelBox.add(Box.createHorizontalStrut(10));
    
        add(buttonBox, BorderLayout.WEST);
        add(timeAndLevelBox, BorderLayout.CENTER);
    }

    protected void setTimeRemainingLB(int time) {
        timeRemainingLb.setText(String.valueOf(time));
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

    private class ControlPanelButtonListener  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton) ev.getSource();

            if (source == newGameButton) {
                gamePanel.newGame();
                setTimeRemainingLB(gamePanel.getTimeRemaining());
                setLevelLB(gamePanel.getLevel());
            } else {
                if (!gamePanel.getGameFinish()) return;
                
                gamePanel.nextGame();
                setTimeRemainingLB(gamePanel.getTimeRemaining());
                setLevelLB(gamePanel.getLevel());
            }
        }
    }
}