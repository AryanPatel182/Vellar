import java.util.*;
import java.io.*;

public class CatalanNumber {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        scn.close();
        int[] dp =  new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2 ; i<=n ; i++)
        {
            int left = 0;
            int right = i-1;

            int sum = 0 ;
            while(left<i || right>=0)
            {
                sum = sum + dp[left]*dp[right];
                left+=1;
                right-=1;
            }

            dp[i] = sum;
        }

        System.out.println(dp[n]);

    }
}
