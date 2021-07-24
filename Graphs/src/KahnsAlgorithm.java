import java.util.*;
import java.io.*;

public class KahnsAlgorithm {
    public static class Edge 
    {
        int self;
        int nbr;
        int val;

        Edge(int self, int nbr, int val) {
            this.self = self;
            this.nbr = nbr;
            this.val = val;
        }
    }

    public static class Pair implements Comparable<Pair>
    {
        int v;

        Pair(int v)
        {
            this.v = v;
        }

        public int compareTo(Pair o)
        {
            return this.v- o.v;
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

        boolean[] visited = new boolean[vts];
        for (int i = 0; i < vts; i++) 
        {
            graph[i] = new ArrayList<>();
        }

        int edges = scn.nextInt();

        for (int i = 0; i < edges; i++)
        {
            int self = scn.nextInt();
            int nbr = scn.nextInt();

            graph[self].add(new Edge(self, nbr, 10));            
        }

        int[] arr = new int[vts];

        for(int i=0; i<graph.length; i++)
        {
            for(Edge e: graph[i])
            {
                arr[e.nbr]+=1;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<vts; i++)
        {
            if(arr[i] == 0)
            {
                pq.add(new Pair(0));
            }
        }

        while(pq.size()>0)
        {
            Pair rm = pq.remove();

            if(visited[rm.v] == true)
            {
                continue;
            }

            visited[rm.v] = true;

            System.out.println(rm.v);

            for(Edge e : graph[rm.v])
            {
                arr[e.nbr]-=1;
            }

            for(int i=0; i<vts; i++)
            {
                if(visited[i]==false && arr[i]==0)
                {
                    pq.add(new Pair(i));
                }
            }


        }
        

        scn.close();

    }
}
