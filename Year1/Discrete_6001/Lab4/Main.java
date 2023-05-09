import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Edges> graph = new ArrayList<>();
        graph.add(new Edges("Minneapolis", Map.of("Chicago", 355, "Nashville", 695)));
        graph.add(new Edges("Chicago", Map.of("Minneapolis", 355, "Milwaukee", 74, "St. Louis", 262, "Louisville", 269)));
        graph.add(new Edges("Milwaukee", Map.of("Chicago", 74, "Louisville", 348)));
        graph.add(new Edges("Nashville", Map.of("Minneapolis", 695, "Louisville", 151)));
        graph.add(new Edges("St. Louis", Map.of("Chicago", 262, "Louisville", 242)));
        graph.add(new Edges("Louisville", Map.of("Chicago", 269, "Milwaukee", 348, "St. Louis", 242, "Cincinnati", 83, "Detroit", 230, "Nashville", 151)));
        graph.add(new Edges("Cincinnati", Map.of("Louisville", 83, "Detroit", 230)));
        graph.add(new Edges("Detroit", Map.of("Cincinnati", 230, "Louisville", 306)));

        Scanner sc = new Scanner(System.in);
        System.out.print("Input your starter point: ");
        Edges starterEdge = Edges.findEdgeByName(graph, sc.nextLine());
        sc.close();

        if (starterEdge == null) {
            System.out.println("Invalid City Name!!!");
        } else {
            System.out.printf("[Start] %s%n", starterEdge);
            Prim prim = new Prim(graph);
            prim.findMinimumSpanningTree(starterEdge);
        }
    }
}