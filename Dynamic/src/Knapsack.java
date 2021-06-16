import java.util.*;
import java.io.*;

public class Knapsack {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int[] wts = new int[n];
        int[] vals = new int[n];

        for(int i = 0 ; i< n ; i++)
        {
            wts[i] = scn.nextInt();
        }
        for(int i = 0 ; i< n ; i++)
        {
            vals[i] = scn.nextInt();
        }
        int limit = scn.nextInt();

        int[][] dp = new int[n+1][limit+1];

        for(int i = 0 ; i < n+1 ; i ++) 
        {
            for(int j = 0 ; j < limit+1 ; j++)
            {
                if(i==0)
                {
                    dp[i][j] = 0;
                }
                else if(j==0)
                {
                    dp[i][j] = 0;
                }
                else{
                    if(j>=wts[i-1])
                    {
                        dp[i][j] = Math.max(dp[i-1][j], vals[i-1]+dp[i-1][j-wts[i-1]]);
                    }
                }
            }
        }

        System.out.println(dp[n][limit]);
        scn.close();

    }
}
