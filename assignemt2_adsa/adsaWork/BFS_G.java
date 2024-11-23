import java.io.*;
import java.util.*;

public class BFS_G {
private int V;
private LinkedList<int[]> adj [];
 
    BFS_G(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i){
            adj[i] = new LinkedList();
        }
    }
    
    // void addEdge (int v, int[] w){ 
    //     adj[v].add(w); 
    // } 

    void addEdge(int v, int w, int weight) {
        adj[v].add(new int[] { 
            w, weight 
        }); 
    }
    
    void BFS (int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

            visited[s] = true;
            queue.add(s);
            
            while (queue.size() != 0){
                s = queue.poll();
                System.out.print(s + " ");

                Iterator<int[]> i = adj[s].listIterator();
                while (i.hasNext()){
                    int[] n = i.next();
                        if (!visited[n[0]]){
                        visited[n[0]] = true;
                        queue.add(n[0]);
                    }
                }
            }
    }

    public void adjmatrix (BFS_G g){
        int[][] sample = new int[V][V];
        int temp;

        for (int i = 0; i < V; i++){
            Iterator<int[]> current = adj[i].listIterator();
            while (current.hasNext()){
                int[] edge = current.next();
                sample[i][edge[0]] = edge[1];
            }

        }

        for (int i = 1; i < V; i++){
            for (int j = 1; j < V; j++){
                System.out.print(sample[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main (String args[]){
        BFS_G g = new BFS_G(6);
        int[] th = new int[2];

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 1);
        g.addEdge(3, 5, 3);
            
        g.adjmatrix(g);
       
    }
}