import java.util.*;
import java.io.*;

public class TargetSumSubset {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();        
        scn.close();

        boolean[][] dp = new boolean[n+1][tar+1];

        for(int i=0 ; i<n+1 ; i++)
        {
            for(int j =0 ; j<tar+1; j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j] = true;
                }
                else if(i==0)
                {
                    dp[i][j] = false;
                }
                else if(j==0)
                {
                    dp[i][j] = true;
                }
                else{

                    if(dp[i-1][j] == true)
                    {
                        dp[i][j]= true;
                    }
                    else{
                        if(j>=arr[i-1] )
                        {
                            dp[i][j] = dp[i-1][j-arr[i-1]];
                        }
                    }
                }
            }
        }

        System.out.println(dp[n][tar]);
    }
}
