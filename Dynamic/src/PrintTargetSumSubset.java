import java.util.*;
import java.io.*;

public class PrintTargetSumSubset {

    public static class Pair 
    {
        int i;
        int j;
        String psf;

        Pair(int i , int j , String psf )
        {
            this.i= i;
            this.j= j;
            this.psf= psf;
        }
        
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        
        int target = scn.nextInt();

        scn.close();
        boolean[][] dp = new boolean[n+1][target+1];

        for(int i = 0 ; i<= n ; i++)
        {
            for(int j = 0 ; j<=target ; j++)
            {
                if(j==0)
                {
                    dp[i][j] =  true;
                }
                else if(i==0)
                {
                    dp[i][j] = false;
                }
                else
                {
                    int val = arr[i-1];
                    if(j<val)
                    {
                        dp[i][j] = dp[i-1][j];
                    }
                    else
                    {
                        if(dp[i-1][j-val] == true)
                        {
                            dp[i][j] = true;
                        }
                        else{
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
                // System.out.println(dp[i][j]);
            }
        }

        System.out.println(dp[n][target]);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, target , ""));

        while(queue.size()>0)
        {
            Pair rm = queue.remove();

            if(rm.i == 0 || rm.j == 0 )
            {
                System.out.println(rm.psf);
            }
            else
            {
                if(dp[rm.i-1][rm.j] == true)
                {
                    queue.add(new Pair(rm.i-1 , rm.j, rm.psf  ));
                }

                if(rm.j >= arr[rm.i-1])
                {
                    if(dp[rm.i-1][rm.j - arr[rm.i-1]] == true)
                    {
                        queue.add(new Pair(rm.i-1, rm.j-arr[rm.i-1] , rm.psf + " " + arr[rm.i-1]));
                    }
                }
            }
        }

        

    }
}
