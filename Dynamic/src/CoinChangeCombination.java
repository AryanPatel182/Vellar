import java.util.*;
import java.io.*;

public class CoinChangeCombination {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0 ; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int i = 0 ; i<n ; i++)
        {
            int val = arr[i];
            for(int j = val ; j< tar+1 ; j++)
            {
               dp[j] += dp[j-val];
            }
        }

        scn.close();
        System.out.println(dp[tar]);

    }
}
