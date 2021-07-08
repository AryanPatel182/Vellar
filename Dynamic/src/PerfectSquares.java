import java.util.*;
import java.io.*;

public class PerfectSquares {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        scn.close();
        for(int i = 2;  i<=n; i++)
        {
            int min = Integer.MAX_VALUE;

            for(int k = 1 ; k*k <= i ; k++)
            {
                min = Math.min(min, dp[i - k*k]);
            }

            dp[i] = min+1;
        }
        System.out.println(dp[n]);

    }
}
