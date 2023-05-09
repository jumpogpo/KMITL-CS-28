import java.util.Scanner;

public class Finite {
    private Edges currentEdges;

    public void startFinite() {
        // Create Node
        Edges node1 = new Edges(true, false);
        Edges node2 = new Edges(false, false);
        Edges node3 = new Edges(false, true);
        Edges node4 = new Edges(false, true);
        Edges node5 = new Edges(false, false);

        // Connect Node to Another Node
        node1.addNextEdge(new Edges[] {node1, node2});
        node2.addNextEdge(new Edges[] {node3, node5});
        node3.addNextEdge(new Edges[] {node4, node5});
        node4.addNextEdge(new Edges[] {node3, node2});
        node5.addNextEdge(new Edges[] {node4, node2});

        // Set Started Edge
        currentEdges = Edges.getStartedEdge();

        // Get User Input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter input: ");
        String fullInput = sc.nextLine();
        sc.close();

        // Split Input And Convert to Number
        String[] splitInput = fullInput.split(" ");
        int[] inputArray = new int[splitInput.length];

        for (int i = 0; i < splitInput.length; i++) {
            try {
                inputArray[i] = Integer.parseInt(splitInput[i]);    
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + splitInput[i]);
                System.exit(0);
            }
        }

        // Start Finite
        for (int input : inputArray) {
            nextStep(input);
        }

        if (currentEdges.isEnd()) {
            System.out.println("Accept");
        } else {
            System.out.println("Reject");
        }
    }

    public boolean nextStep(int input) {
        currentEdges = currentEdges.getNextEdgesList().get(input);

        if (currentEdges.isEnd()) return true;

        return false;
    }
}
