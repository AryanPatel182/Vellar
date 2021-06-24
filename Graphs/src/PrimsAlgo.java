import java.util.*;
import java.io.*;

public class PrimsAlgo {
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

    public static class Pair implements Comparable<Pair>
    {
        int v; 
        int av;
        int wt;

        Pair(int v, int av, int wt)
        {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }        
        
        public int compareTo(Pair o) {
            return this.wt - o.wt;
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
        int src = scn.nextInt();
        boolean[] visited = new boolean[vts];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src,-1,0));

        while(pq.size()>0)
        {
            Pair rm = pq.remove();

            if(visited[rm.v] == true)
            {
                continue;
            }
            
            visited[rm.v] = true;
            if(rm.av != -1)
            {
                System.out.println(rm.v + " - " +rm.av +" @" + rm.wt);
            }
            for(Edge e : graph[rm.v])
            {
                if(visited[e.nbr]==false)
                {
                    pq.add(new Pair(e.nbr , rm.v , e.val));
                }
            }
        }


        scn.close();

    }
}
