import java.util.*;
import java.io.*;

public class CountMountainAndValleys {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n= scn.nextInt();

        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i<=n ; i++)
        {
            int left = i-1;
            int right = 0;

            int sum = 0;
            while(left>=0)
            {

                sum = sum + dp[left]*dp[right];

                right+=1;
                left-=1;

            }
            dp[i] = sum;

        }
        scn.close();
        System.out.println(dp[n]);

    }
}
