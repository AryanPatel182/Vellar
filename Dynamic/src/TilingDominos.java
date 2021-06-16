import java.util.*;
import java.io.*;

public class TilingDominos {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<n+1; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
        scn.close();

    }
}

