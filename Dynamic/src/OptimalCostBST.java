import java.util.*;
import java.io.*;

public class OptimalCostBST {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        
        int[] freq = new int[n];
        
        for(int i=0 ; i<n ; i++)
        {
            freq[i] = scn.nextInt();            
        }
        scn.close();

        int[][] dp = new int[n][n];
        
        for(int g=0 ; g<n ; g++)
        {
            for(int i=0 , j=g ; j<n ; i++,j++)
            {
                if(g==0)
                {
                    dp[i][j] = freq[i];
                }
                else if(g==1)
                {
                    int f1 = freq[i];
                    int f2 = freq[j];

                    dp[i][j] =Math.min(f1 + 2*f2, f2 + 2*f1);                    
                }
                else
                {
                    int fs = 0 ;
                    for(int v = i ; v<=j ; v++)
                    {
                        fs += freq[v];
                    }

                    int min = Integer.MAX_VALUE;
                    for(int k = i ; k <= j ; k++)
                    {
                        int lc = i==k ? 0 : dp[i][k-1];
                        int rc = k==j ? 0 : dp[k+1][j];
                        min = Math.min(min, lc + rc + fs);
                    }

                    dp[i][j] = min;
                }
            }
        }

        System.out.println(dp[0][n-1]);

    }
}
