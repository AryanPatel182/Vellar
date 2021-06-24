import java.util.*;
import java.io.*;

public class TopologicalSort {
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

    public static void topologicalsort(ArrayList<Edge>[] graph, int src , boolean[] visited, Stack<Integer> st) {
        
            visited[src]  = true;
            for(Edge e: graph[src])
            {
                if(visited[e.nbr] == false)
                {
                    topologicalsort(graph, e.nbr, visited, st);
                }
            }
            st.add(src);

            
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

        }

        

        boolean[] visited = new boolean[vts];
        scn.close();

        Stack<Integer> st = new Stack<>();
        for(int v = 0; v<vts ;v++)
        {
            if(visited[v] == false)
            {
                topologicalsort(graph , v , visited , st);
            }
        }

        while(st.size()>0)
        {            
            System.out.println(st.pop());
        }


    }
}
