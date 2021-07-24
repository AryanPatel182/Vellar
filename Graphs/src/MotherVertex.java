import java.util.*;
import java.io.*;

public class MotherVertex {
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

    public static class Pair
    {
        int v;

        Pair(int v)
        {
            this.v = v;
        }
    }

    public static void mothervertex(ArrayList<Edge>[] graph, boolean[] visited , int vts)
    {   
        Stack<Integer> st= new Stack<>();        
        for(int i=0; i<vts; i++)        
        {
            if(visited[i]== false)
            {
                dfs(graph,i,visited,st);
            }
        }

        System.out.println(st.peek());

    }

    public static void dfs(ArrayList<Edge>[] graph,int src, boolean[] visited, Stack<Integer> st)
    {
        visited[src] = true;

        for(Edge e:graph[src])
        {
            if(visited[e.nbr] == false)
            {
                dfs(graph, e.nbr, visited, st);
            }
        }
        st.push(src);
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

        mothervertex(graph,visited,vts);
        scn.close();

    }
}
