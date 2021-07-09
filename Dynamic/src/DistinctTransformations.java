import java.util.*;
import java.io.*;

public class DistinctTransformations{

    public static void main(String[] args) throws Exception{
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        
        String s = scn.next();
        String t = scn.next();

        int r = t.length();
        int c = s.length();
        int[][] dp = new int[t.length()+1][s.length()+1];

        for(int i = r ; i>=0 ;i--)
        {
            for(int j = c ; j>=0; j--)
            {
                if(i==r)
                {
                    dp[i][j] = 1;                    
                }
                else if(j==c)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    if(t.charAt(i) != s.charAt(j))
                    {
                        dp[i][j] = dp[i][j+1];
                    }
                    else
                    {
                        dp[i][j] = dp[i][j+1] + dp[i+1][j+1];
                    }
                }
            }
        }
        scn.close();

        System.out.println(dp[0][0]);
    }

}
