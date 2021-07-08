import java.util.*;
import java.io.*;

public class PalindromePartitioningWithMinimumCuts {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s = scn.next();
        scn.close();
        int n = s.length();

        boolean[][] dp  = new boolean[n][n];

        for(int g= 0 ; g<n; g++)
        {
            for(int i = 0 ,j = g ; j<n; i++,j++)
            {
                if(g==0)
                {
                    dp[i][j] = true;
                }
                else if(g==1)
                {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else
                {
                    if(s.charAt(i) == s.charAt(j))
                    {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
            }
        }

        if(dp[0][n-1] == true)
        {
            System.out.println(0);
        }        
        else
        {
            int[] strg = new int[n];
            strg[0] = 0;

            for (int j = 1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int i = j; i >= 1; i--) {
                    if (dp[i][j]) {
                        min = Math.min(min, strg[i - 1]);
                    }
                }
                strg[j] = min + 1;
            }

            System.out.println(strg[n - 1]);
        }        
    }
}
