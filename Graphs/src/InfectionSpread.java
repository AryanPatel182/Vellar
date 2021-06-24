import java.util.*;
import java.io.*;

public class InfectionSpread {
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

    public static class Pair {
        int v;
        String psf;
        int level;

        Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
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
        int t = scn.nextInt();
        scn.close();

        int[] visited = new int[vts];
        Arrays.fill(visited, 0);
    



        int count = 0;
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + " ", 1));

        while (q.size() > 0) {
            Pair rm = q.removeFirst();

            if (visited[rm.v] > 0) {
               continue;
            } 

            visited[rm.v] = rm.level;
            if(rm.level>t)
            {
                break;
            }
            count++;
            for (Edge e : graph[rm.v]) {
                if (visited[e.nbr] == 0) {
                    q.add(new Pair(e.nbr, rm.psf + e.nbr, rm.level + 1));
                }
            }
        }
        System.out.println(count);

    }

}
