import java.util.*;
import java.io.*;

public class LargestSumncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n];

        dp[0] = arr[0];
        int ans = dp[0];

        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < val) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = max + val;
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

        scn.close();

    }
}
