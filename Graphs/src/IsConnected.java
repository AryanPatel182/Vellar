import java.util.*;
import java.io.*;

public class IsConnected {

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

    public static void printConnectedPaths(int src, ArrayList<Edge>[] graph, boolean[] visited,
            ArrayList<Integer> comp) {

        visited[src] = true;
        comp.add(src);
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                printConnectedPaths(e.nbr, graph, visited, comp);
            }
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
            int wt = scn.nextInt();

            graph[self].add(new Edge(self, nbr, wt));
            graph[nbr].add(new Edge(nbr, self, wt));

        }

        // int dest = scn.nextInt();

        boolean[] visited = new boolean[vts];

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int i = 0; i < vts; i++) {
            if (visited[i] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                printConnectedPaths(i, graph, visited, comp);
                comps.add(comp);
            }
        }
        System.out.println(comps.size()==1);
        scn.close();

    }

}
