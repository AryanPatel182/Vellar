import java.util.*;
import java.io.*;

public class Dijkstra {
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

    public static class Pair implements Comparable<Pair>{
        int v;   
        String psf;     
        int wsf;

        Pair(int v,String psf, int wsf) {
            this.v = v;       
            this.psf = psf;     
            this.wsf = wsf;
        }

        public int compareTo(Pair o)
        {
            return this.wsf - o.wsf;
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
        

        scn.close();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src + " ", 0));
        boolean[] visited = new boolean[vts];

        while(pq.size()>0)
        {
            Pair rm = pq.remove();

            if(visited[rm.v] == true)
            {
                continue;
            }
            visited[rm.v] = true;

            System.out.println(rm.v + "via" + rm.psf + "@" + rm.wsf);

            for(Edge e:graph[rm.v])
            {
                if(visited[e.nbr] == false)
                {
                    pq.add(new Pair(e.nbr , rm.psf + e.nbr , rm.wsf +e.val));
                }
            }
        }

    }
}
