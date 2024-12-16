import java.util.Scanner;

public class Foot {
    private FootShape footShape = new FootShape();

    public void draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What to draw? 1. Ellipse, 2. Rectangle ");
        int choice = scanner.nextInt();
        scanner.close();

        switch (choice) {
            case 1:
                footShape.drawAsEllipse();
                break;
            case 2:
                footShape.drawAsRectangle();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}