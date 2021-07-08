import java.util.*;
import java.io.*;

public class RegularExpressionMatching {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s1 = scn.next();
        String s2 = scn.next();

        int c  = s1.length();
        int r = s2.length();

        boolean[][] dp = new boolean[r+1][c+1];
        for(int i = 0; i<= r ; i++)
        {
            for(int j = 0 ; j<=c ; j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j] = true;
                }
                else if(i==0)
                {
                    dp[i][j] = false;
                }
                else if(j==0)
                {
                    if(s2.charAt(i-1) == '*')
                    {
                        dp[i][j] = dp[i-2][j];
                    }
                    else
                    {
                        dp[i][j] = false;
                    }
                }
                else
                {
                    char ch = s2.charAt(i-1);
                    
                    if(ch=='*')
                    {
                        char lc = s2.charAt(i-2);
                        char nc = s1.charAt(j-1);

                        dp[i][j] = dp[i-2][j];
                        
                        if(lc == '.' || lc==nc)
                        {
                            dp[i][j] = dp[i][j] || dp[i][j-1];
                        }
                        
                    }
                    else if(ch=='.')
                    {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    else
                    {
                        if(s1.charAt(j-1) == ch)
                        {
                            dp[i][j] = dp[i-1][j-1];
                        }
                        else
                        {
                            dp[i][j] = false;
                        }
                    }

                }                            
            }
            

        }
        System.out.println(dp[r][c]);
        scn.close();

    }
}
