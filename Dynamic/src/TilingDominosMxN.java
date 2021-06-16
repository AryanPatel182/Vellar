import java.util.*;
import java.io.*;

public class TilingDominosMxN {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int m = scn.nextInt();
        int n  =scn.nextInt();

        int[] dp = new int[n+1];
        
        for(int i=1; i<=n ; i++)
        {
            if(i<m)
            {
                dp[i] = 1;
            }
            else if(i==m) dp[i] = 2;
            else{
                dp[i] = dp[i-1] + dp[i-m];
            }
        }


        System.out.println(dp[n]);
        scn.close();

    }
}
