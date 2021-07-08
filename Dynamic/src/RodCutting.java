import java.util.*;
import java.io.*;

public class RodCutting {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        
        int[] arr= new int[n+1];

        for(int i = 1; i<n+1; i++)
        {
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = arr[1];
        for(int i=2; i<=n;i++)
        {
            dp[i] = arr[i];
            int si = 1, ei = i-1;

            while(si<=ei)
            {
                dp[i] = Math.max(dp[i], dp[si]+dp[ei]);
                si++;
                ei--;
            }
        }

        System.out.println(dp[n]);
        scn.close();

    }
}
