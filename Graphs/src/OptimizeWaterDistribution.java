import java.util.*;
import java.io.*;


public class OptimizeWaterDistribution{
    public static class Pair implements Comparable<Pair>
    {
        int vtx;
        int wt;

        Pair(int vtx, int wt)
        {
            this.vtx = vtx;
            this.wt = wt;
        }

        public int compareTo(Pair o)
        {
            return this.wt - o.wt;
        }

    }


    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<pipes.length; i++)
        {
            int src = pipes[i][0];
            int dst = pipes[i][1];
            int cst = pipes[i][2];

            graph.get(src).add(new Pair(dst,cst));
            graph.get(dst).add(new Pair(src,cst));
        }

        for(int i=1; i<=n; i++)
        {
            int cst = wells[i-1];
            graph.get(0).add(new Pair(i, cst));
            graph.get(i).add(new Pair(0, cst));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        pq.add(new Pair(0,0));
        int cost = 0;
        while(pq.size() > 0)
        {
            Pair rm = pq.remove();
            if(visited[rm.vtx] == true)
            {
                continue;
            }

            visited[rm.vtx] = true;
            cost+= rm.wt;

            ArrayList<Pair> nbrs = graph.get(rm.vtx);
            for(Pair nbr : nbrs)
            {
                if(visited[nbr.vtx] != true)
                {
                    pq.add(nbr);
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        
        int n = scn.nextInt();
        int v = scn.nextInt();

        int[] wells = new int[n];
        for(int i=0; i<n; i++)
        {
            wells[i] = scn.nextInt();
        }
        int[][] pipes = new int[v][3];
        for(int i=0; i<v; i++)
        {
            pipes[i][0] = scn.nextInt();
            pipes[i][1] = scn.nextInt();
            pipes[i][2] = scn.nextInt();
        }


        
        System.out.println(minCostToSupplyWater(n, wells, pipes));
        scn.close();

    }
}
