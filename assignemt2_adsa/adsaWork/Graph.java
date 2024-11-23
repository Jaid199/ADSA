import java.util.*;

public class Graph {
    private int V; // Number of vertices
    private LinkedList<int[]> adj[]; // Adjacency list to store {destination, weight}

    // Constructor
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add an edge with weight
    void addEdge(int u, int v, int weight) {
        adj[u].add(new int[]{v, weight}); // Directed edge
    }

    // Dijkstra's Algorithm to find the shortest path
    void dijkstra(int src) {
        int[] dist = new int[V]; // Distance array
        int[] prev = new int[V]; // To track the shortest path
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances as infinity
        Arrays.fill(prev, -1); // Initialize previous nodes as -1

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // Min-heap based on distance
        pq.add(new int[]{src, 0}); // Add source node with distance 0
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0]; // Current node
            int d = current[1]; // Distance to current node

            // Skip outdated entries in the priority queue
            if (d > dist[u]) continue;

            // Explore neighbors
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u; // Track the previous node
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        // Print shortest paths to all nodes
        printAllPaths(src, dist, prev);
    }

    // Print all shortest paths from the source
    private void printAllPaths(int src, int[] dist, int[] prev) {
        System.out.println("Shortest paths from " + (char) (src + 'A') + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println((char) (src + 'A') + " -> " + (char) (i + 'A') + ": No path");
            } else {
                System.out.print((char) (src + 'A') + " -> " + (char) (i + 'A') + " (Distance: " + dist[i] + "): ");
                printPath(prev, i);
                System.out.println();
            }
        }
    }

    // Helper function to print the path using the prev array
    private void printPath(int[] prev, int node) {
        if (node == -1) return;
        printPath(prev, prev[node]);
        System.out.print((char) (node + 'A') + " ");
    }

    // Main Method
    public static void main(String[] args) {
        // Graph with 5 nodes (A-E, represented as 0-4)
        Graph g = new Graph(5);

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

        // Find the shortest paths from A (0) to all nodes
        g.dijkstra(0); // Source is A (0)
    }
}
