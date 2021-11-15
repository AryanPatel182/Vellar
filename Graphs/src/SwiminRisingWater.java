import java.util.*;
import java.io.*;

public class SwiminRisingWater {
    public static class Pair implements Comparable<Pair>{
        int r;
        int c;
        int msf;

        Pair(int r, int c, int msf) {
            this.r = r;
            this.c = c;
            this.msf = msf;
        }
        public int compareTo(Pair o)
        {
            return this.msf - o.msf;
        }
    }
    public static int[][] dirc = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int swimInWater(int[][] arr)
    {
        int m = arr.length;
        int n = arr[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, arr[0][0]));
        boolean[][] visited = new boolean[m][n];  
            
        while(pq.size() > 0)
        {
            // System.out.println(pq.peek().r +" "+ pq.peek().c + " " + pq.peek().msf );
            Pair rm = pq.remove();

            if(rm.r == m-1 && rm.c == n-1) 
            {
                return rm.msf;
            }
            if(visited[rm.r][rm.c] == true)
            {
                continue;
            }
            visited[rm.r][rm.c] = true;
            

            for(int i=0; i<4; i++)
            {
                int rdash = rm.r + dirc[i][0];
                int cdash = rm.c + dirc[i][1];

                if(rdash >=0 && rdash <m && cdash>=0 && cdash<n && visited[rdash][cdash] == false)
                {
                    pq.add(new Pair(rdash, cdash, Math.max(rm.msf, arr[rdash][cdash])));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        
        
        System.out.println(swimInWater(arr));
        scn.close();

    }
}
