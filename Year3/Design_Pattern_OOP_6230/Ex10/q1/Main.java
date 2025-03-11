public class Main {
    public static void main(String[] args) {
        Game football = new FootballGame();
        football.play();

        System.out.println();

        Game basketball = new BasketballGame();
        basketball.play();
    }
}

