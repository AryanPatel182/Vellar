import java.util.*;
import java.io.*;

public class UnboundedKnapsack {
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

        int[] dp = new int[limit+1];

        dp[0] = 0 ;




        for(int i=0; i< limit+1 ; i++)
        {            
            for(int j = 0; j < n ; j++)
            {
                if(wts[j] <= i)
                {
                    dp[i] = Math.max(dp[i] , dp[i-wts[j]] + vals[j]);                    
                }                
            }
            
        }
        System.out.println(dp[limit]);

        
        for(int i = 0; i< n; i++)
        {
            for(int j= 0 ; j< limit+1 ; j++)
            {
                // System.out.println(j);   
                if(j>= wts[i])         
                {
                    dp[j] = Math.max(dp[j], vals[i] + dp[j-wts[i]] );                
                }
                // System.out.println(dp[j]);
            }
        }
        System.out.println(dp[limit]);
        scn.close();

    }
}
