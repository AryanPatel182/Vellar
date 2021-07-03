import java.util.*;
import java.io.*;

public class WildCardMatching {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s1 = scn.next();
        String s2 = scn.next();
        scn.close();
        
        int c = s1.length();
        int r = s2.length();

        boolean[][] dp = new boolean[r+1][c+1];

        for(int i = r ; i>=0 ; i--)
        {
            for(int j = c ; j>=0 ; j--)
            {
                if(i==r && j==c)
                {
                    dp[i][j] = true;
                }
                else if(i==r)
                {
                    dp[i][j] = false;
                }
                else if(j==c)
                {
                    if(s2.charAt(i) == '*')
                    {
                        dp[i][j] = dp[i+1][j];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else
                {
                    if(s2.charAt(i) == '?')
                    {
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else if(s2.charAt(i) == '*') 
                    {
                        if(dp[i][j+1] == true )
                        {
                            dp[i][j] = true;
                        }
                        else{
                            dp[i][j] = dp[i+1][j];
                        }
                    }
                    else
                    {
                        if(s2.charAt(i) == s1.charAt(j))
                        {
                            dp[i][j] = dp[i+1][j+1];
                        }
                        else{
                            dp[i][j] = false;
                        }
                    }
                }

                System.out.print(dp[i][j]);                
            }
            System.out.println();
        }

        System.out.println(dp[0][0]);


    }
}
