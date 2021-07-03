import java.util.*;
import java.io.*;

public class PrintAllMinPath {
    public static class Pair{
        String util;    
        int r;
        int c;

        Pair(String util , int r , int c)
        {
            this.util = util;
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[r][c];
        for(int i = 0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c ; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }

        scn.close();
        int[][] dp = new int[r][c];
        
        for(int i = r-1 ; i>=0 ; i--)
        {
            for(int j = c-1; j>=0 ; j--)
            {
                if(i==r-1 && j == c-1)
                {
                    dp[i][j] = arr[i][j];
                }
                else if(i==r-1)
                {
                    dp[i][j] = dp[i][j+1] + arr[i][j];
                }
                else if(j==c-1)
                {
                    dp[i][j] = dp[i+1][j] + arr[i][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i+1][j] , dp[i][j+1]) + arr[i][j];
                }                
            }
        }
        // System.out.println(dp[0][0]);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(" ", 0 , 0));

        while(queue.size()>0)
        {
            Pair rm = queue.remove();

            if(rm.r == r-1 && rm.c == c-1)
            {
                System.out.println(rm.util);
            }
            else if(rm.r == r-1)
            {
                queue.add(new Pair(rm.util + "H", rm.r, rm.c + 1));
            }
            else if(rm.c == c-1)
            {
                queue.add(new Pair(rm.util + "V", rm.r + 1, rm.c));
            }
            else
            {
                if(dp[rm.r][rm.c + 1] < dp[rm.r + 1][rm.c] )
                {
                    queue.add(new Pair(rm.util + "H" , rm.r , rm.c + 1));
                }
                else if(dp[rm.r][rm.c + 1] > dp[rm.r + 1][rm.c])
                {
                    queue.add(new Pair(rm.util + "V", rm.r+1, rm.c));
                }
                else
                {
                    queue.add(new Pair(rm.util + "H", rm.r, rm.c + 1));
                    queue.add(new Pair(rm.util + "V", rm.r + 1, rm.c));
                }
            }

        }
        

    }
}
