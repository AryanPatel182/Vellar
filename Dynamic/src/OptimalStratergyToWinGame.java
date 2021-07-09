import java.util.*;
import java.io.*;

public class OptimalStratergyToWinGame {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int[][] dp = new int[n][n];

        for(int g = 0 ; g< n ;g++)
        {
            for(int i = 0 , j=g ; j<n ;i++,j++)
            {
                if(g==0)
                {
                    dp[i][j] = arr[i];
                }
                else if(g==1)
                {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                }
                else
                {
                    int val1 = arr[i] + Math.min(dp[i+2][j] , dp[i+1][j-1]);
                    int val2 = arr[j] + Math.min(dp[i+1][j-1] , dp[i][j-2]);

                    int val = Math.max(val1, val2);
                    dp[i][j] = val;                    
                }
            }
        }

        System.out.println(dp[0][n-1]);

        scn.close();

    }
}
