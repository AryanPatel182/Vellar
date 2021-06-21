import java.util.*;
import java.io.*;

public class HamiltonianPathCycle {

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

    public static void IsHamiltonian(int src , ArrayList<Edge>[] graph, HashSet<Integer> visited, String util , int osrc) {        
        if(visited.size() == graph.length-1)
        {
            int k = 0;
            for(Edge e: graph[src])
            {
                if(e.nbr == osrc)
                {
                    k=1;
                    break;
                }
            }
            if(k==1)
            {
                System.out.println(util + " * ");                
                return;
            }
            System.out.println(util + " . ");
            return;
        }

        visited.add(src);
        // System.out.println(visited);

        for(Edge e: graph[src])
        {
            if(visited.contains(e.nbr) == false)
            {
                // System.out.println(e.nbr);
                IsHamiltonian(e.nbr, graph, visited, util + e.nbr + " ", osrc);
            }
        }
        visited.remove(src);
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
            
        // boolean[] visited = new boolean[vts];
        int src = scn.nextInt();
        HashSet<Integer> visited = new HashSet<>();

        IsHamiltonian(src ,graph, visited, src+ " " , 0);
        
        scn.close();
    }
}
