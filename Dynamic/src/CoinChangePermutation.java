import java.util.*;
import java.io.*;

public class CoinChangePermutation {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n ; i++)
        {
            arr[i] = scn.nextInt();        
        }

        int tar = scn.nextInt();
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int i = 0 ; i< tar+1 ; i++)
        {
            for(int coin : arr)
            {
                if(coin <= i)
                {
                    dp[i] +=  dp[i-coin];
                }
            }
        }
        scn.close();
        System.out.println(dp[tar]);

    }
}
