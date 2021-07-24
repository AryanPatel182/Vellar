import java.util.*;
import java.io.*;

public class EulerianPathandCircuit {
    public static class Edge {
        int self;
        int nbr;
        int val;

        Edge(int self, int nbr, int val) {
            this.self = self;
            this.nbr = nbr;
            this.val = val;
        }
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
            int self = scn.nextInt();
            int nbr = scn.nextInt();

            graph[self].add(new Edge(self, nbr, 10));
            graph[nbr].add(new Edge(nbr, self, 10));

        }
        


        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ For directed Grpah   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        // Circuit = All the (n) vertex must have even degree to have eulerian cycle
        // Path = n-2 vertex must have even degree to have eulerian Path


        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ For undirected Graph  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // Circuit = All the (n) vetex must have equal number of inderee and outdegree to have eulerian cycle
        // Path = n-2 vertex must have equal number of indegree and outdegree to have eulerian path



        scn.close();

    }
}
