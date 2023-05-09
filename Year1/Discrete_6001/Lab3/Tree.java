import java.util.Stack;

public class Tree {
    String infix;

    public Tree(String inputInfix) {
        infix = inputInfix;
    }

    public String infixToPrefix() {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String reversedInfix = new StringBuilder(infix.replaceAll(" ", "")).reverse().toString();

        for (int i = 0; i < reversedInfix.length(); i++) {
            char c = reversedInfix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result.append(c + " ");
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result.append(stack.pop() + " ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    result.append(stack.pop() + " ");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public String infixToPostfix() {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String removeSpaceInfix = infix.replace(" ", "");

        for (int i = 0; i < removeSpaceInfix.length(); i++) {
            char c = removeSpaceInfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c + " ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop() + " ");
                }
                
                if (stack.isEmpty() || stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop() + " ");
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != '(') {
                result.append(stack.pop() + " ");
            }
        }

        return result.toString();
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}