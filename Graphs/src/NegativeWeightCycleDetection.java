import java.util.*;
import java.io.*;

public class NegativeWeightCycleDetection {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[][] wts = new int[n][3];

        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;
        for(int i =0 ; i<n; i++)
        {
            wts[i][0] = scn.nextInt();
            wts[i][1] = scn.nextInt();
            wts[i][2] = scn.nextInt();
        }

        for(int i=0; i<n-1; i++)
        {
            for(int j=0; j<n; j++)
            {
                int u = wts[j][0];
                int v = wts[j][1];
                int wt = wts[j][2];

                if(path[u] == Integer.MAX_VALUE)
                {
                    continue;
                }
                if(path[u] + wt < path[v])
                {
                    path[v] = path[u] + wt;
                }
            }
        }
        String ans = "No";
        
        for(int j=0; j<n; j++ )
        {
            int u = wts[j][0];
            int v = wts[j][1];
            int wt = wts[j][2];

            if (path[u] == Integer.MAX_VALUE) {
                continue;
            }
            if (path[u] + wt < path[v]) {
                ans = "Yes";
            }
        }

        scn.close();
        System.out.println(ans);

    }
}
