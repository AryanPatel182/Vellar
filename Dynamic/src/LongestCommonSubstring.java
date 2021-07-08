import java.util.*;
import java.io.*;

public class LongestCommonSubstring {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s1 = scn.next();
        String s2 = scn.next();
        scn.close();

        int n = s1.length();

        int[][] dp = new int[n+1][n+1];

        int max = 0;
        for(int i = 1 ; i<=n ;i++)
        {
            for(int j = 1 ; j <=n ;j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }            
        }

        System.out.println(max);

    }
}
