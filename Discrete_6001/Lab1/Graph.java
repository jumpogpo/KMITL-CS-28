import java.util.ArrayList;

class Graph {
    private ArrayList<ArrayList<Integer>> maps = new ArrayList<ArrayList<Integer>>();
    private String[] points = {"A", "B", "C", "D", "E"};

    public void addEdge(int vertex, int edge) {
        if (maps.size() <= vertex) maps.add(new ArrayList<>());
        maps.get(vertex).add(edge);
    }

    public int getDregree(int vertex) {
        return maps.get(vertex).size();
    }

    public ArrayList<String> getEdge(int vertex) {
        ArrayList<String> edges = new ArrayList<>();

        for (int edge : maps.get(vertex)) {
            edges.add(points[edge]);
        }

        return edges;
    }

    public void showMatrix() {
        System.out.print("[Matirx]\n    ");

        for (int vertex = 0; vertex < maps.size(); vertex++) {
            System.out.print(points[vertex] + " ");
        }

        System.out.println();

        for (int vertex = 0; vertex < maps.size(); vertex++) {
            System.out.print(points[vertex] + " | ");

            for (int edge = 0; edge < maps.size(); edge++) {
                if (maps.get(vertex).contains(edge)) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        int totalDregree = 0;

        showMatrix();
        string.append("[Detail]\n");

        for (int vertex = 0; vertex < maps.size(); vertex++) {
            string.append(String.format("Vertex: %s | Dregree: %d | Edge: %s --- %s%n", points[vertex], getDregree(vertex), points[vertex], getEdge(vertex).toString()));
            totalDregree += getDregree(vertex);
        }

        string.append("[Total]: " + totalDregree);
        return string.toString();    
    }

    public static void main(String[] args) {
        Graph map = new Graph();

        map.addEdge(0, 1);
        map.addEdge(0, 2);
        
        map.addEdge(1, 0);
        map.addEdge(1, 3);
        map.addEdge(1, 4);

        map.addEdge(2, 0);
        map.addEdge(2, 3);

        map.addEdge(3, 1);
        map.addEdge(3, 2);
        map.addEdge(3, 4);

        map.addEdge(4, 1);
        map.addEdge(4, 3);

        System.out.println(map);
    }
}