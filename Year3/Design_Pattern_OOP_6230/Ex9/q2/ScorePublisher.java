package q2;

import java.util.*;

class ScorePublisher {
    private List<Observer> observers = new ArrayList<>();
    private String latestScore;

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestScore);
        }
    }

    public void setScore(String score) {
        this.latestScore = score;
        notifyObservers();
    }
}
