import java.util.*;
import java.io.*;

public class MobileNumericKeyPadProblem {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        int[][] keys = {
            {0,8},
            {1,2,4},
            {2,1,3,5},
            {3,2,6},
            {4,1,5,7},
            {5,4,6,8,2},
            {6,3,5,9},
            {7,4,8},
            {8,7,9,5,0},
            {9,6,8},            
        };
        
        scn.close();

        int[][] dp = new int[n+1][10];
        for(int i= 1; i<=n; i++)
        {
            for(int j = 0 ; j<=9; j++)
            {
                if(i==1)
                {
                    dp[i][j] = i;
                }
                else
                {
                    for(int k:keys[j])
                    {
                        dp[i][j] += dp[i-1][k];
                    }
                }               
            }            
        }

        int ans = 0;
        for(int i = 0 ; i <= 9  ; i++)
        {
            ans+=dp[n][i] ;
        }

        System.out.println(ans);

    }
}
