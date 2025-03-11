public class FootballGame extends Game {
    @Override
    protected void initializeGame() {
        System.out.println("Initializing football game...");
    }

    @Override
    protected void playingGame() {
        System.out.println("Playing football game...");
    }

    @Override
    protected void showResult() {
        System.out.println("Showing the results for the football game...");
    }
}

