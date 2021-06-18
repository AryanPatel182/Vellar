import java.util.*;
import java.io.*;

public class Graph {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v , int wt) {
        adj.get(u).add(v);        
        adj.get(u).add(wt);        
        adj.get(v).add(u);        
        adj.get(v).add(wt);        
    }

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int V = scn.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        
        int edges = scn.nextInt();
        

        for(int i = 0; i<edges-1 ; i++)
        {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            addEdge(adj, u, v, wt);
        }
        scn.close();
    }
}
