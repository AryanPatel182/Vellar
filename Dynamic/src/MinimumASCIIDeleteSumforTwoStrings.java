import java.util.*;
import java.io.*;

public class MinimumASCIIDeleteSumforTwoStrings {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s1 = scn.next();
        String s2 = scn.next();

        int n1= s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1+1][n2+1];
        for(int i=n1 ; i>=0; i--)
        {
            for(int j=n2;j>=0;j--)
            {
                if(i==n1 && j==n2)
                {
                    dp[i][j] = 0;
                }
                else if(i==n1)
                {
                    dp[i][j] = dp[i][j+1] + s2.charAt(j);                    
                }
                else if(j==n2)
                {
                    dp[i][j] = dp[i+1][j] + s1.charAt(i);
                }
                else
                {
                    if(s1.charAt(i) == s2.charAt(j))
                    {
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else
                    {
                        int v1 = s1.charAt(i) + dp[i+1][j];
                        int v2 = s2.charAt(j) + dp[i][j+1];
                        dp[i][j] =  Math.min(v1, v2);
                    }
                }

            }
        }

        scn.close();
        System.out.println(dp[0][0]);

    }
}
