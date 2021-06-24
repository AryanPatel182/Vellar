import java.util.*;
import java.io.*;

public class IsCyclic {
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

    static class Pair {
        int v;
        

        Pair(int v) {
            this.v = v;            
        }
    }


    public static boolean Iscycle(ArrayList<Edge>[] graph , int src, boolean[] visited) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src));

        while(queue.size()>0)
        {
            
            Pair rm = queue.removeFirst();
            
            if(visited[rm.v] == true)
            {
                return true;
            }
            visited[rm.v] = true;

            for(Edge e: graph[rm.v])
            {
                if(visited[e.nbr] == false)
                {
                    queue.add(new Pair(e.nbr));
                }
            }

        }
        
        return false;
        
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

        int edges = scn.nextInt();
        for (int i = 0; i < vts; i++) {
            graph[i] = new ArrayList<>();
        }        
        for (int i = 0; i < edges; i++) {
            int self = scn.nextInt();
            int nbr = scn.nextInt();

            graph[self].add(new Edge(self, nbr, 10));
            graph[nbr].add(new Edge(nbr, self, 10));

        }

        scn.close();
        boolean[] visited = new boolean[vts];
        for(int v=0; v<vts ; v++)
        {
            if(visited[v] == false)
            {
                boolean cycle = Iscycle(graph , v, visited);
                // System.out.println(cycle);
                if(cycle)
                {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    

    }
}
