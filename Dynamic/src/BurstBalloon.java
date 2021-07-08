import java.util.*;
import java.io.*;

public class BurstBalloon {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int[] arr= new int[n];
        for(int i = 0 ; i<n ;i++)
        {
            arr[i] = scn.nextInt();
        }

        int[][] dp = new int[n][n];

        for(int g= 0 ; g<n; g++)
        {
            for(int i = 0 , j = g ; j<n ; i++,j++)
            {
                int max = Integer.MIN_VALUE;
                for(int k = i; k<=j; k++)
                {   
                    int ls = k==i?0:dp[i][k-1];
                    int rs = k==j?0:dp[k+1][j];

                    int val = (i==0?1:arr[i-1]) *  arr[k] * (j==n-1?1:arr[j+1]);
                    max = Math.max(max, ls+rs+val);
                }

                dp[i][j] = max;
            }                            
        }

        scn.close();
        System.out.println(dp[0][n-1]);

    }
}
