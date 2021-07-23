import java.util.*;
import java.io.*;

public class BellmanFord {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        
        int n = scn.nextInt();
        

        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++)
        {
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
            arr[i][2] = scn.nextInt();
        }

        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;

        for(int i=0; i<n-1; i++)
        {
            for(int j=0; j<n; j++)
            {
                int u = arr[j][0];
                int v = arr[j][1];
                int wt = arr[j][2];

                if(path[u] == Integer.MAX_VALUE) 
                {
                    continue;
                }
                if(path[u]+wt<path[v])
                {
                    path[v] = path[u] + wt;
                }
            }
        }

        scn.close();
        for(int i=0; i<n; i++)
        {
            System.out.println(path[i]);
        }

    }
}
