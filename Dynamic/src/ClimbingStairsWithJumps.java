import java.util.*;
import java.io.*;

public class ClimbingStairsWithJumps {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i= 0 ;i <n ;i++)
        {
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int i=n-1; i>=0; i--)
        {
            for(int j=1; j<=arr[i] ; j++)
            {
                dp[i] += dp[i + j];
            }
        }

        System.out.println(dp[0]);
        scn.close();

    }
}
