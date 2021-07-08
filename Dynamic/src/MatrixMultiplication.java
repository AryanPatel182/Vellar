import java.util.*;
import java.io.*;

public class MatrixMultiplication {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i<n; i++)
        {
            arr[i] = scn.nextInt();            
        }

        int[][] dp = new int[n-1][n-1];

        for(int g = 0 ; g<dp.length ; g++)
        {
            for(int i = 0 , j = g ; j < dp.length ; i++, j++)
            {
                if(g==0)
                {
                    dp[i][j] = 0;
                }
                else if(g==1)
                {
                    dp[i][j] = arr[i]*arr[j]*arr[j+1];
                }
                else
                {
                    int min = Integer.MAX_VALUE;
                    for(int k = i ; k<=j-1; k++)
                    {
                        int lc = dp[0][k];
                        int rc = dp[k+1][j];
                        int mc = arr[i]*arr[k+1]*arr[j+1];

                        min = Math.min(min, lc+rc+mc);
                    }
                    dp[i][j] = min;
                }
            }
        }

        System.out.println(dp[0][n-2]);

        scn.close();

    }
}
