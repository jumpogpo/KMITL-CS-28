package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {
    private JFrame frame;
    private JLabel creditLabel, scoreLabel;
    private JButton newGameButton, nextButton, leftPictureButton, rightPictureButton;
    private Icon answerImageOneIcon, answerImageTwoIcon, leftButtonPictureIcon, rightButtonPictureIcon;
    private boolean isClicked;
    private int answer, score;

    public App() {
        frame = new JFrame("Where is the Book");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new java.awt.Color(33, 33, 33));
        detailComponents();
        frame.setVisible(true);
    }

    private void detailComponents() {
        try {
            Image resultImageOne = new ImageIcon("src/../picture/CS.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            Image resultImageTwo = new ImageIcon("src/../picture/Book.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);

            leftButtonPictureIcon = new ImageIcon("src/../picture/blue600x600.png");
            rightButtonPictureIcon = new ImageIcon("src/../picture/orange600x600.jpg");
            answerImageOneIcon = (Icon) new ImageIcon(resultImageOne);
            answerImageTwoIcon = (Icon) new ImageIcon(resultImageTwo);
        }catch (Exception e) {
            System.out.println(e);
        }

        creditLabel = new JLabel("");
        scoreLabel = new JLabel("Score: 0");
        newGameButton = new JButton("New Game");
        nextButton = new JButton("Next Stage");
        leftPictureButton = new JButton(answerImageOneIcon);
        rightPictureButton = new JButton(answerImageTwoIcon);
        frame.setLayout(new FlowLayout());

        creditLabel.setPreferredSize(new Dimension(4, 50));
        scoreLabel.setPreferredSize(new Dimension(60, 100));
        leftPictureButton.setPreferredSize(new Dimension(200, 200));
        rightPictureButton.setPreferredSize(new Dimension(200, 200));

        creditLabel.setForeground(Color.WHITE);
        scoreLabel.setForeground(Color.WHITE);

        frame.add(creditLabel);
        frame.add(newGameButton);
        frame.add(scoreLabel);
        frame.add(nextButton);
        frame.add(leftPictureButton);
        frame.add(rightPictureButton);

        AllButtonListener buttonAction = new AllButtonListener();
        leftPictureButton.addActionListener(buttonAction);
        rightPictureButton.addActionListener(buttonAction);
        newGameButton.addActionListener(buttonAction);
        nextButton.addActionListener(buttonAction);

        Play();

        isClicked = false; 
    }

    private void newGame() {
        leftPictureButton.setIcon(leftButtonPictureIcon);
        rightPictureButton.setIcon(rightButtonPictureIcon);
        isClicked = false;
        score = 0;
        scoreLabel.setText("Score: " + score);
    }

    private void Play() {
        leftPictureButton.setIcon(leftButtonPictureIcon);
        rightPictureButton.setIcon(rightButtonPictureIcon);
        isClicked = false;
        answer = Math.random() > 0.5 ? 0 : 1;
    }

    private class AllButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton)ev.getSource();

            if (source == leftPictureButton && !isClicked) {
                isClicked = true;

                if (answer == 0) {
                    leftPictureButton.setIcon(answerImageTwoIcon);
                    score++;
                } else {
                    leftPictureButton.setIcon(answerImageOneIcon);
                }

                scoreLabel.setText("Score: " + score);
            } else if (source == rightPictureButton && !isClicked) {
                isClicked = true;

                if (answer == 0) {
                    rightPictureButton.setIcon(answerImageTwoIcon);
                    score++;
                } else {
                    rightPictureButton.setIcon(answerImageOneIcon);
                }    
                
                scoreLabel.setText("Score: " + score);
            } else if (source == nextButton) {
                Play();
            } else if (source == newGameButton) {
                newGame();
            }
        }
    }
}