import java.util.*;
import java.io.*;

public class ZeroOneBFS {
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
        int wsf;

        Pair(int v, int wsf) {
            this.v = v;
            this.wsf = wsf;
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

            graph[self].add(new Edge(self, nbr, 0));
            graph[nbr].add(new Edge(nbr, self, 1));

        }

        int dest = scn.nextInt();
        boolean[] visited = new boolean[vts];
        scn.close();


        LinkedList<Pair> queue=  new LinkedList<>();
        queue.addLast(new Pair(0,0));

        while(queue.size()>0)
        {
            Pair rm = queue.removeFirst();
            
            if (visited[rm.v] == true) {
                continue;
            }
            if(rm.v == dest)
            {
                System.out.println(rm.wsf);
                break;
            }
            visited[rm.v] = true;
            
            System.out.println(rm.v + " @ " + rm.wsf);
            for(Edge e:graph[rm.v])
            {
                if(visited[e.nbr] ==true)
                {
                    continue;
                }
                if(e.val == 0)
                {
                    queue.addFirst(new Pair(e.nbr , rm.wsf + 0));
                }
                if(e.val == 1)
                {
                    queue.addLast(new Pair(e.nbr , rm.wsf + 1));
                }
                
            }
        }
        


    }
}
