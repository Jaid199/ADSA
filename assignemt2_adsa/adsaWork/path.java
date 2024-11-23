import java.util.*;

public class path {
    private int V;
    private LinkedList<int[]> adj[];

    // Constructor
    path(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add Edge
    void addEdge(int v, int w, int weight) {
        adj[v].add(new int[]{w, weight}); // Add edge with weight
    }

    // Helper function to find all paths
    private void findAllPathsUtil(int src, int dest, boolean[] visited, List<Integer> path) {
        visited[src] = true; // Mark the current node as visited
        path.add(src); // Add the current node to the path

        // If destination is reached, print the path
        if (src == dest) {
            printPath(path);
        } else {
            // Recur for all adjacent vertices
            for (int[] neighbor : adj[src]) {
                if (!visited[neighbor[0]]) {
                    findAllPathsUtil(neighbor[0], dest, visited, path);
                }
            }
        }

        // Backtrack: Remove the current node from path and mark it unvisited
        path.remove(path.size() - 1);
        visited[src] = false;
    }

    // Function to print all paths from source to destination
    public void findAllPaths(int src, int dest) {
        boolean[] visited = new boolean[V]; // Keep track of visited nodes
        List<Integer> path = new ArrayList<>(); // Store the current path
        findAllPathsUtil(src, dest, visited, path);
    }

    // Utility to print a single path
    private void printPath(List<Integer> path) {
        for (int node : path) {
            System.out.print((char) ('A' + node) + " "); // Convert node index to letter
        }
        System.out.println();
    }

    public static void main(String[] args) {
        path g = new path(5);

        // Adding all edges from the image with weights
        g.addEdge(0, 1, 10); // A -> B (weight 10)
        g.addEdge(0, 2, 3);  // A -> C (weight 3)
        g.addEdge(1, 2, 1);  // B -> C (weight 1)
        g.addEdge(1, 3, 2);  // B -> D (weight 2)
        g.addEdge(2, 1, 4);  // C -> B (weight 4)
        g.addEdge(2, 3, 8);  // C -> D (weight 8)
        g.addEdge(2, 4, 2);  // C -> E (weight 2)
        g.addEdge(3, 4, 7);  // D -> E (weight 7)
        g.addEdge(4, 3, 9);  // E -> D (weight 9)

       
        System.out.println("All paths from A to E:");
        g.findAllPaths(0, 4);
    }
}
