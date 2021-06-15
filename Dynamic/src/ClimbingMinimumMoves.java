import java.util.*;
import java.io.*;

public class ClimbingMinimumMoves {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int  n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i< n; i++)
        {
            arr[i] = scn.nextInt();
        }    
        scn.close();
        Integer[] dp = new Integer[n+1];
        dp[n] = 0;
        for(int i= n-1; i>=0; i--)
        {
            
            if(arr[i] != 0)
            {            
                // System.out.println(arr[i]);    
                Integer min = Integer.MAX_VALUE;
                for(int j = 1; j<=arr[i] && i+j<=n; j++)
                {
                    if(dp[i+j]!=null)
                    {
                        min = Math.min(min, dp[i+j]);
                    }
                }
                if(min != Integer.MIN_VALUE)
                    dp[i] = min + 1;
                else{
                    dp[i] = null;
                }
                
            }
        }

        System.out.println(dp[0]);


    }
}
