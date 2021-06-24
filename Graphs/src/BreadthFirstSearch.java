import java.util.*;
import java.io.*;

public class BreadthFirstSearch {
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

    static class Pair
    {
        int v;
        String psf; 

        Pair(int v, String psf)
        {
            this.v = v;
            this.psf = psf;
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

            graph[self].add(new Edge(self, nbr, 10));
            graph[nbr].add(new Edge(nbr, self, 10));

        }
        int src = scn.nextInt();
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[vts];
        queue.add(new Pair(src , src+ ""));

        while(queue.size() > 0)
        {
            // rm chk wrk add

            Pair rm = queue.removeFirst();
            if(visited[rm.v] == true)
            {
                continue;
            }
            visited[rm.v] = true;

            System.out.println(rm.v + " @"+ rm.psf);

            for(Edge e : graph[rm.v])
            {
                if(visited[e.nbr] == false)
                {
                    queue.add(new Pair(e.nbr, rm.psf + e.nbr ));
                }
            }

        }

        scn.close();

    }
}
