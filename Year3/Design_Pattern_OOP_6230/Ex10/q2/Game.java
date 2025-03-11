public class Game {
    private GameStrategy strategy;

    public Game(GameStrategy strategy) {
        this.strategy = strategy;
    }

    public void play() {
        strategy.initializeGame();
        strategy.playingGame();
        strategy.showResult();
    }
}

