import java.util.*;
import java.io.*;

public class GoldMine {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n =  scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for(int i= 0; i<n ;i++)
        {
            for(int j = 0; j< m ; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();

        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;

        for(int j=m-1; j>=0; j--)
        {
            for(int i=0; i<n; i++)
            {
                if(j==m-1)
                {
                    dp[i][j] = arr[i][j];                
                }
                else if(i==0)
                {
                    dp[i][j] = arr[i][j] + Math.max(dp[i+1][j+1], dp[i][j+1]);
                }
                else if(i==n-1)
                {
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j+1], dp[i][j+1]);
                }
                else{
                    dp[i][j] = arr[i][j] +Math.max(dp[i+1][j+1],Math.max(dp[i][j+1], dp[i - 1][j + 1]));
                }                

                if(dp[i][j] > max)
                {
                    max =  dp[i][j];
                }
            }            
        }
        
        System.out.println(max);

    }
}
