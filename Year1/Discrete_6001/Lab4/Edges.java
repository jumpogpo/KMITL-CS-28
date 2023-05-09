import java.util.ArrayList;
import java.util.Map;

public class Edges {
    private String name;
    private Boolean isConnect;
    private Map<String, Integer> canConnectMap;

    Edges(String edgeName, Map<String, Integer> canConnectMap) {
        name = edgeName;
        isConnect = false;
        this.canConnectMap = canConnectMap;
    }

    public static Edges findEdgeByName(ArrayList<Edges> edgesList, String name) {
        for (Edges edge : edgesList) {
            if (edge.getName().equals(name)) {
                return edge;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getCanConnectMap() {
        return canConnectMap;
    }

    public void connect() {
        isConnect = true;
    }

    public Boolean isConnect() {
        return isConnect;
    }

    public String toString() {
        return name;
    }
}