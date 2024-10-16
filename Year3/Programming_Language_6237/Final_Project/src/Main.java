package src;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <input_file>");
            System.exit(1);
        }

        try {
            Lexer lexer = new Lexer(new FileReader(args[0]));
            Lexer.Token token;
            while ((token = lexer.yylex()) != null) {
                switch (token) {
                    case OPERATOR:
                        System.out.println("operator: " + lexer.yytext());
                        break;
                    case PARENTHESIS:
                        System.out.println("parenthesis: " + lexer.yytext());
                        break;
                    case SEMICOLON:
                        System.out.println("semicolon: " + lexer.yytext());
                        break;
                    case KEYWORD:
                        System.out.println("keyword: " + lexer.yytext());
                        break;
                    case INTEGER:
                        System.out.println("integer: " + lexer.yytext());
                        break;
                    case STRING:
                        System.out.println("string: " + lexer.yytext());
                        break;
                    case ERROR:
                        // Already printed in Lexer
                        System.exit(1);
                        break;
                    case IDENTIFIER:
                        // Already printed in Lexer
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}