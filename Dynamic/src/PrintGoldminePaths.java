import java.util.*;
import java.io.*;

public class PrintGoldminePaths {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[r][c];

        for(int i=0; i<r; i++)
        {
            for(int j = 0 ; j<c; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();

        int[][] dp = new int[r][c];

        
        
        for(int j = c-1 ; j>=0; j--)
        {   
            for(int i = 0 ; i<r ; i++)
            {
                if(j==c-1)
                {
                    dp[i][j] = arr[i][j];
                }
                else if(i==0)
                {
                    dp[i][j] = arr[i][j] +  Math.max(arr[i][j+1], arr[i+1][j+1]);
                }
                else if(i==r-1)
                {
                    dp[i][j] = arr[i][j] + Math.max(arr[i][j + 1], arr[i - 1][j + 1]);
                }

                else{
                    dp[i][j] = arr[i][j] + Math.max(arr[i][j + 1], Math.max(arr[i+1][j+1], arr[i - 1][j + 1]));
                }
                System.out.println(dp[i][j]);
            }

        }
        int max = Integer.MIN_VALUE;
        for(int i= 0 ; i<r ; i++)
        {
            max = Math.max(max, dp[i][0]);
        }
        System.out.println(max);
    }
}
