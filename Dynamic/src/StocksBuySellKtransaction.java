import java.util.*;
import java.io.*;

public class StocksBuySellKtransaction {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();


        int[][] dp = new int[k+1][n];

        for(int i=1; i<k+1; i++)
        {
            int max = dp[i][0]-arr[0];
            for(int j = 1 ; j< n ;j++)
            {        
                if(i==0 || j==0)
                {
                    dp[i][j] = 0;
                    max = dp[i][j] - arr[j];
                }
                
                max = Math.max(max, dp[i - 1][j - 1]-arr[j]);                
                dp[i][j] = Math.max(dp[i][j-1], max+arr[j]);            
            }
            
        }

        System.out.println(dp[k][n-1]);
        scn.close();

    }
}
