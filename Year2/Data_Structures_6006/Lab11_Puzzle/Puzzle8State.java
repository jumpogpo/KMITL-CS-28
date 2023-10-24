import java.util.Arrays;

public class Puzzle8State {
    public int[] sequence;

    public Puzzle8State(int[] sequence) {
        this.sequence = sequence;
    }

    public boolean equals(Object obj) {
        return true;
    }

    public String toString() {
        return Arrays.toString(sequence);
    }
}