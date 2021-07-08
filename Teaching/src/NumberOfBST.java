import java.util.*;
import java.io.*;

public class NumberOfBST {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        
        int n = scn.nextInt();

        int[] dp = new int[n+1];
        scn.close();

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i <= n ; i++)
        {
            int left = 0;
            int right = i-1;

            while(left < i && right >= 0)
            {
                dp[i] +=  dp[left] * dp[right];

                left+=1;
                right-=1;
            }
        }


        System.out.println(dp[n]);
    }
}
