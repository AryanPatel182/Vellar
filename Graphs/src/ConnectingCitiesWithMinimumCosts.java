import java.util.*;
import java.io.*;

public class ConnectingCitiesWithMinimumCosts {
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
        int wt;

        Pair(int v, int wt)
        {
            this.v = v;
            this.wt = wt;

        }
        public int compareTo(Pair o) {
            return this.wt-o.wt;
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

        boolean[] visited = new boolean[vts];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0,0));
        int ans = 0;
        int count = 1;

        while(pq.size()>0)
        {
            Pair rm = pq.remove();

            if(visited[rm.v] == true)
            {
                continue;
            }

            visited[rm.v] = true;
            ans = ans + rm.wt;
            

            for(Edge e:graph[rm.v])
            {
                if(visited[e.nbr] == false)
                {
                    pq.add(new Pair(e.nbr, e.val));
                    count++;
                }
            }
        }

        if(count == vts)
        {
            System.out.println(ans);
            
        }
        else{
            System.out.println(-1);            
        }

        scn.close();

    }
}
