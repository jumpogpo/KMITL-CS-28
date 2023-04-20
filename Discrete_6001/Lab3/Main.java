import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infixExpression;

        System.out.print("Enter your Infix: ");
        infixExpression = sc.nextLine();
        sc.close();

        Tree tree = new Tree(infixExpression);
        System.out.println("Prefix: " + tree.infixToPrefix());
        System.out.println("Infix: " + tree.infix);
        System.out.println("Postfix: " + tree.infixToPostfix());
    }
}