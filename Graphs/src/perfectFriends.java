import java.util.*;
import java.io.*;

public class perfectFriends {
    public static class Edge {
        int e;
        int n;

        Edge(int e , int n)
        {
            this.e = e;
            this.n = n;
        }
    }

    public static void printConnectedPaths(int src, ArrayList<Edge>[] graph, boolean[] visited,
            ArrayList<Integer> comp) {

        visited[src] = true;
        comp.add(src);
        for (Edge e : graph[src]) {
            if (visited[e.n] == false) {
                printConnectedPaths(e.n, graph, visited, comp);
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
        int edges = scn.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vts];
        for(int i = 0; i<vts; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<edges; i++)
        {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));                    
        }

        boolean[] visited = new boolean[vts];

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int i = 0; i < vts; i++) {
            if (visited[i] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                printConnectedPaths(i, graph, visited, comp);
                comps.add(comp);
            }
        }
        int pairs = 0;

        for(int i = 0; i<comps.size() ; i++)
        {
            for(int j = i+1 ; j<comps.size(); j++)
            {
                pairs += comps.get(i).size()*comps.get(j).size();
            }
        }
        System.out.println(pairs);
        scn.close();

    }
}
