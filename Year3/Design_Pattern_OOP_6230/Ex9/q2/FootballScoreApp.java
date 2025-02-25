package q2;

import java.util.Scanner;

public class FootballScoreApp {
    public static void main(String[] args) {
        ScorePublisher publisher = new ScorePublisher();
        
        // Register at least two subscribers
        Observer user1 = new ScoreSubscriber("User1");
        Observer user2 = new ScoreSubscriber("User2");
        publisher.register(user1);
        publisher.register(user2);
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Score: ");
            String score = scanner.nextLine();
            if (score.isEmpty()) break; // Stop loop when Enter is pressed without input
            publisher.setScore(score);
        }
        scanner.close();
    }
}
