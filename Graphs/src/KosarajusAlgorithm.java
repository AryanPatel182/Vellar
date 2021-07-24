import java.util.*;
import java.io.*;

public class KosarajusAlgorithm {
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
    public static void Kosaraju(ArrayList<Edge>[] graph, int vts, ArrayList<Edge>[] rgraph)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[vts];
        boolean[] rvisited = new boolean[vts];

        for(int i=0; i<vts; i++)
        {
            if(visited[i] == false)
            {
                dfs(graph,i,st,visited);
            }
        }

        System.out.println(st);
        int count = 0;

        while(st.size()>0)
        {
            int curr = st.pop();
            if(rvisited[curr] == false)
            {
                rdfs(rgraph,curr, rvisited);
                count+=1;
            }
        }

        System.out.println(count);


    }

    public static void dfs(ArrayList<Edge>[] graph,int curr, Stack<Integer> st, boolean[] visited)
    {
        visited[curr] = true;
        
        for(Edge e:graph[curr])
        {
            if(visited[e.nbr] == false)
            {
                dfs(graph, e.nbr, st, visited);
            }
        }
        st.push(curr);
    }

    public static void rdfs(ArrayList<Edge>[] graph,int curr, boolean[] rvisited)
    {        

        rvisited[curr] = true;

        for(Edge e:graph[curr])
        {
            if(rvisited[e.nbr] == false)
            {
                rdfs(graph, e.nbr, rvisited);                
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
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] rgraph = new ArrayList[vts];

        for (int i = 0; i < vts; i++) {
            graph[i] = new ArrayList<>();
            rgraph[i] = new ArrayList<>();            
        }

        int edges = scn.nextInt();

        for (int i = 0; i < edges; i++) {
            int self = scn.nextInt();
            int nbr = scn.nextInt();

            graph[self].add(new Edge(self, nbr, 10));            
            rgraph[nbr].add(new Edge(nbr, self, 10));            

        }
        scn.close();

        Kosaraju(graph,vts,rgraph);

                    
        

    }
}
