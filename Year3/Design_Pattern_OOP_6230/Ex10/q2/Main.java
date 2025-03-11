public class Main {
    public static void main(String[] args) {
        Game footballGame = new Game(new FootballStrategy());
        footballGame.play();

        System.out.println();

        Game basketballGame = new Game(new BasketballStrategy());
        basketballGame.play();
    }
}

