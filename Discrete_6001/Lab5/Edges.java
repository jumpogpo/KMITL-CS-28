import java.util.ArrayList;

public class Edges {
    private static ArrayList<Edges> allEdges = new ArrayList<>();
    private boolean startEdge;
    private boolean endEdge;
    private ArrayList<Edges> nextEdge;

    public Edges(boolean started, boolean end) {
        startEdge = started;
        endEdge = end;
        nextEdge = new ArrayList<>();
        allEdges.add(this);
    }

    public void addNextEdge(Edges[] nextEdgeArray) {
        for (Edges edge : nextEdgeArray) {
            nextEdge.add(edge);
        }
    }

    public ArrayList<Edges> getNextEdgesList() {
        return nextEdge;
    }

    public boolean isEnd() {
        return endEdge;
    }

    public static Edges getStartedEdge() {
        return allEdges.stream()
        .filter(e -> e.startEdge == true)
        .findFirst()
        .orElse(null);
    }
}
