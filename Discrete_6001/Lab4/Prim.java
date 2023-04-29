import java.util.ArrayList;
import java.util.Map;

public class Prim {
    ArrayList<Edges> graph;
    ArrayList<Edges> alreadyConnect;

    Prim(ArrayList<Edges> graph) {
        this.graph = graph;
        alreadyConnect = new ArrayList<>();
    }

    public ArrayList<Edges> findMinimumSpanningTree(Edges starterEdge) {
        alreadyConnect = new ArrayList<>();
        alreadyConnect.add(starterEdge);
        starterEdge.connect();

        while (true) {
            Edges bestWays = findBestWay();

            if (bestWays == null) break;

            bestWays.connect();
            alreadyConnect.add(bestWays);
        }

        return alreadyConnect;
    }

    private Edges findBestWay() {
        int currentDistance = Integer.MAX_VALUE;
        Edges result = null;
        Edges mainEdge = null;

        for (Edges edge : alreadyConnect) {
            for (Map.Entry<String, Integer> entry : edge.getCanConnectMap().entrySet()) {
                String name = entry.getKey();
                Integer distance = entry.getValue();
                Edges edgeByName = Edges.findEdgeByName(graph, name);
    
                if (edgeByName.isConnect() == true) continue;
                if (distance < currentDistance) {
                    currentDistance = distance;
                    result = edgeByName;
                    mainEdge = edge;
                }
            }
        }

        if (result != null) System.out.printf("%s ---> %s [%d]%n", mainEdge, result, currentDistance);
        return result;
    }
}