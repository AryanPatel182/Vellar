import java.util.*;
import java.io.*;

public class MinimumScoreTriangulation {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i<n ; i++)
        {
            arr[i] = scn.nextInt();
        }

        int[][] dp = new int[n][n];

        for(int g = 0 ; g < n ; g++)
        {
            for(int i = 0 , j = g; j<n ; i++, j++)
            {            
                if(g==0 || g == 1)
                {
                    dp[i][j] = 0;
                }
                else if(g == 2)
                {
                    dp[i][j] = arr[i] * arr[i+1] * arr[i+2];
                }
                else
                {
                    int min = Integer.MAX_VALUE;
                    int pro = arr[i]*arr[j];
                    for(int k = i+1 ; k<=j-1; k++)
                    {
                        int tpro = pro * arr[k];
                        int m1 = dp[i][k];
                        int m2 = dp[k][j];

                        min = Math.min(min, tpro + m1 + m2);
                    }
                    dp[i][j] = min;
                }                
                // System.out.println(dp[i][j]);
            }
            // System.out.println();
        }

        System.out.println(dp[0][n-1]);
        scn.close();

    }
}
