import java.util.*;
import java.io.*;


public class LargestSquareOfOnesInArray{

    public static void main(String[] args) throws Exception{
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[r][c];
        for(int i = 0 ; i<r; i++)
        {
            for(int j = 0 ; j<c; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[r][c];

        int ans=  0;
        for(int i= r-1; i>=0; i--)
        {
            for(int j = c-1 ; j>=0 ; j--)
            {
                if(i==r-1 && arr[i][j] == 1)
                {
                    dp[i][j] = 1;
                }
                else if(j==c-1 && arr[i][j] == 1)
                {
                    dp[i][j] = 1;
                }
                else{
                    if(arr[i][j] == 1)
                    {
                        dp[i][j] = Math.min(dp[i+1][j] , Math.min(dp[i+1][j+1], dp[i][j+1])) + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }

        System.out.println(ans);
        scn.close();
    }
}