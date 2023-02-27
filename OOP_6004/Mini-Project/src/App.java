package src;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.Random;

public class App {
    private Random rand = new Random();
    private JFrame f;
    private JPanel top, middle;
    private JButton btnNew, currentOpenButton;
    private JLabel lbLevel, lbTimeRemaining;
    private Icon pictureIcon;
    private Font invisibleFont, unInvisibleFont;
    private int tableSize = 4, alreadyOpen = 0, level = 1, timeRemaining = 60, count = 0, currentRandNumber = rand.nextInt(100);
    private boolean cooldown = false, gameStart = false;
    AllButtonListener buttonAction = new AllButtonListener();

    public App(){
        f = new JFrame("Match Numbers");
        f.setSize(500,450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLayout(new BorderLayout());
        initializeUI();
        f.setVisible(true);
    }

    private void initializeUI(){
        invisibleFont = new Font("Times New Roman", Font.PLAIN, 0);
        unInvisibleFont = new Font("Times New Roman", Font.PLAIN, 30);

        try {
            Image resultPictureIcon = new ImageIcon("src/../picture/QuestionMark.png").getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT);
            pictureIcon = (Icon) new ImageIcon(resultPictureIcon);
        } catch (Exception e) {
            System.out.println(e);
        }

        top = new JPanel();
        middle = new JPanel();
        btnNew = new JButton("New Game");
        lbLevel = new JLabel("Level: " + level);
        lbTimeRemaining = new JLabel(String.valueOf(timeRemaining));

        btnNew.addActionListener(buttonAction);

        createNewTable();

        top.setBackground(new java.awt.Color(33, 33, 33));
        middle.setBackground(new java.awt.Color(33, 33, 33));

        btnNew.setPreferredSize(new Dimension(150,50));
        lbLevel.setPreferredSize(new Dimension(65,50));

        middle.setLayout(new GridLayout(tableSize / 2, tableSize / 2));

        lbLevel.setForeground(Color.WHITE);
        lbTimeRemaining.setForeground(Color.WHITE);

        top.add(btnNew);
        top.add(lbTimeRemaining);
        top.add(lbLevel);

        f.add(top, BorderLayout.NORTH);
        f.add(middle, BorderLayout.CENTER);

        countDownTimer();
    }

    private void resetGameSettings() {
        level = 1;
        tableSize = 4;
        lbLevel.setText("Level: " + level);
        createNewTable();
    }

    private void countDownTimer() {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(gameStart);

                if (gameStart) {
                    try {
                        Thread.sleep(1000);
                        timeRemaining -= 1;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
    
                    if (timeRemaining <= 0) {
                        resetGameSettings();
                    } else {
                        lbTimeRemaining.setText(String.valueOf(timeRemaining));
                    }
                }
            }
        });

        thread.start();
    }

    private void createNewTable() {
        ArrayList<JButton> gameButton = new ArrayList<>();
        middle.removeAll(); 
        timeRemaining = 60;
        lbTimeRemaining.setText(String.valueOf(timeRemaining));

        for (int i = 1; i < (tableSize + 1); i++) {
            JButton button = new JButton(pictureIcon);
            button.setFont(invisibleFont);
            button.setPreferredSize(new Dimension(150,50));
            button.addActionListener(buttonAction);
            button.setText(null);
            middle.add(button);
            gameButton.add(button);
        }

        ArrayList<JButton> clonedGameButton = new ArrayList<>(gameButton.size());

        for (JButton button : gameButton) {
            clonedGameButton.add(button);
        }

        currentOpenButton = null;
        cooldown = false;
        alreadyOpen = 0;

        for (JButton button : clonedGameButton) {
            button.setFont(invisibleFont);
            button.setIcon(pictureIcon);
        }

        for (int a = 0; a < tableSize; a++) {
            if (count == 2) {
                count = 0;
                currentRandNumber = rand.nextInt(100);
            }

            int index = (int) (Math.random() * clonedGameButton.size());
            JButton randomButton = clonedGameButton.get(index);

            randomButton.setText(String.valueOf(currentRandNumber));
            randomButton.setFont(invisibleFont);
            clonedGameButton.remove(index);
            count++;
        }

        gameStart = true;
    }

    private class AllButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton) ev.getSource();

            if (source == btnNew) {
                resetGameSettings();
            } else {
                System.out.println(source.getText());
                if (currentOpenButton == null) {
                    if (source.getIcon() == pictureIcon && !cooldown) {
                        currentOpenButton = source;
                        source.setFont(unInvisibleFont);
                        source.setIcon(null);
                    }
                } else if (currentOpenButton.getText().equals(source.getText()) && source.getIcon() == pictureIcon && !cooldown) {
                    currentOpenButton = null;
                    source.setFont(unInvisibleFont);
                    source.setIcon(null);
                    alreadyOpen += 2;

                    if (alreadyOpen == tableSize) {
                        gameStart = false;
                        cooldown = true;
                        alreadyOpen = 0;
                        level++;

                        if (level % 5 == 0) {
                            tableSize += 2;
                        }

                        Timer timer = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                lbLevel.setText("Level: " + level);
                                createNewTable();
                            }
                        });

                        timer.setRepeats(false);
                        timer.start();
                    }
                
                } else if (!currentOpenButton.getText().equals(source.getText()) && source.getIcon() == pictureIcon && !cooldown) {
                    cooldown = true;
                    source.setFont(unInvisibleFont);
                    source.setIcon(null);

                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            source.setFont(invisibleFont);
                            source.setIcon(pictureIcon);

                            if (currentOpenButton != null) {
                                currentOpenButton.setFont(invisibleFont);
                                currentOpenButton.setIcon(pictureIcon);
                                currentOpenButton = null;
                            }
                            
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