package src;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
    private Random rand = new Random();
    private ArrayList<GameButton> gameButtons;
    private ArrayList<Integer> usedNumber;
    private int buttonAmount, level, timeRemaining;
    private int currentRandNumber;
    private boolean gameStart;
    private ControlPanel controlPanel;

    public GamePanel() {
        buttonAmount = 4;
        level = 1;
        timeRemaining = 60;

        setBackground(new java.awt.Color(33, 33, 33));
        setLayout(new GridLayout(buttonAmount / 2, buttonAmount / 2));
    }

    private void createButton() {
        int count = 0;
        gameStart = false;
        usedNumber = new ArrayList<>();
        gameButtons = new ArrayList<>();

        currentRandNumber = randomNumber();
        usedNumber.add(currentRandNumber);

        for (int i = 1; i < (buttonAmount + 1); i++) {
            GameButton button = new GameButton(this);
            add(button);
            gameButtons.add(button);
        }

        for (int a = 0; a < buttonAmount; a++) {
            if (count == 2) {
                count = 0;
                currentRandNumber = randomNumber();
            }

            int index = (int) (Math.random() * gameButtons.size());
            gameButtons.get(index).setText(String.valueOf(currentRandNumber));
            gameButtons.remove(index);
            count++;
        }

        preViewNumber();
    }

    private int randomNumber() {
        int randomNumberResult = rand.nextInt(100);

        if (usedNumber.contains(randomNumberResult)) return randomNumber();
        return randomNumberResult;
    }

    protected void settingGame(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
        createButton();
        controlPanel.timer();
    }

    private void preViewNumber() {
        Component[] components = this.getComponents();

        for (Component component : components) {
            if (component instanceof GameButton) {
                ((GameButton) component).showNumber();
            }
        }

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : components) {
                    if (component instanceof GameButton) {
                        ((GameButton) component).hideNumber();
                    }
                }
                gameStart = true;
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    protected void newGame() {
        this.removeAll();
        buttonAmount = 4;
        level = 1;
        timeRemaining = 60;
        gameStart = false;
        createButton();
    }

    protected void nextGame() {
        this.removeAll();
        timeRemaining = 60;
        gameStart = false;
        controlPanel.setLevelLB(level);
        controlPanel.setTimeRemainingLB(timeRemaining);
        createButton();
    }

    protected int getButtonAmount() {
        return buttonAmount;
    }

    protected int getLevel() {
        return level;
    }

    protected int getTimeRemaining() {
        return timeRemaining;
    }

    protected boolean getGameStatus() {
        return gameStart;
    }

    protected void setGameStatus(boolean status) {
        gameStart = status;
    }

    protected void setTimeRemaining(int time) {
        timeRemaining = time;
    }

    protected void increaseLevel() {
        level += 1;
    }

    protected void increaseButtonAmount() {
        buttonAmount += 2;
    }
}