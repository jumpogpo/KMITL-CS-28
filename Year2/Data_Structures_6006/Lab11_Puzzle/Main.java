import java.util.Arrays;

public class Main {
    static Puzzle8_650368 game;

    public static void main(String[] args) {
        game = new Puzzle8_650368(new int[] {
            9, 0, 0,
            1, 0, 1,
            3, 0, 2,
            4, 1, 0,
            2, 1, 1,
            5, 1, 2,
            7, 2, 0,
            8, 2, 1,
            6, 2, 2
        });

        demo1();
        demo2();
        demo3();
    }

    static void demo1() {
        System.out.println("[Task 1]");
        game.displayBoard();
    }

    static void demo2() {
        System.out.println("\n[Task 2]");
        game.generateNextMove();        
    }

    static void demo3() {
        System.out.println("\n[Task 3]");
        game.generateNextMoveWithStack();
        System.out.println(game.explored.size());
        System.out.println("partial explored state");

        for (Puzzle8State s : game.explored) {
            if (s.sequence[0] == 1 && s.sequence[1] == 2 && s.sequence[2] == 3 && s.sequence[3] == 4) {
                System.out.println(Arrays.toString(s.sequence));
            }
        }
    }
}
