import java.util.*;
import java.io.*;

public class PrintAllPaths {

    public static class Edge {
        int v1;
        int v2;
        int val;

        Edge(int v1, int v2, int val) {
            this.v1 = v1;
            this.v2 = v2;
            this.val = val;
        }
    }

    public static void printAllPaths(int src, int dest, ArrayList<Edge>[] graph, boolean[] visited, String util)  {
        if (src == dest) {
            System.out.println(util);
            return;
        }

        visited[src] = true;        
        for (Edge edge : graph[src]) {
            if (visited[edge.v2] == false) {
                printAllPaths(edge.v2, dest, graph, visited , util + edge.v2 + " -> ");                     
            }
        }
        visited[src] = false;        
        
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int vts = scn.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vts];

        for (int i = 0; i < vts; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = scn.nextInt();

        for (int i = 0; i < edges; i++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));

        }

        int src = scn.nextInt();
        int dest = scn.nextInt();

        boolean[] visited = new boolean[vts];

        printAllPaths(src, dest, graph, visited, src + " -> " );
        scn.close();

    }
}
