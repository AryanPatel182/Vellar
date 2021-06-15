import java.util.*;
import java.io.*;

public class MinCostPath {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for(int i = 0; i< n; i++)
        {
            for(int j = 0 ; j< m ; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        for(int i=n-1; i>=0; i--)
        {
            for(int j = m-1; j>=0; j--)
            {
                if(i==n-1 && j == m-1)
                {
                    dp[i][j] = arr[i][j];
                }
                else if(i==n-1)
                {
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                }
                else if(j==m-1)
                {
                    dp[i][j] = arr[i][j] +  dp[i+1][j];
                }
                else{                    
                    int min = Math.min(dp[i+1][j], dp[i][j+1]);
                    dp[i][j] = arr[i][j] + min ;
                }
            }
        }

        System.out.println(dp[0][0]);

        scn.close();





        
        
    }
}

