import java.util.*;
import java.io.*;

public class KnapsackPrint {

    public static class Pair {
        int i;
        int j;
        String psf;
        
        Pair(int i , int j , String psf)
        {
            this.i = i;
            this.j = j; 
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        int[] val = new int[n];

        for(int i = 0 ; i<n ; i++)
        {
            val[i] = scn.nextInt();
        }
        int[] wt = new int[n];
        for(int i = 0 ; i<n ; i++)
        {
            wt[i] = scn.nextInt();            
        }        
        int target = scn.nextInt();
        scn.close();

        int[][] dp = new int[n+1][target+1];

        for(int i = 0 ; i<=n; i++)        
        {
            for(int j=0 ; j<=target ; j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    if(j>=wt[i-1])
                    {
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-wt[i-1]] + val[i-1]);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }                
            }                        
        }
        System.out.println(dp[n][target]);


        ArrayDeque<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(n , target , ""));

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ BFS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
        while(queue.size()>0)
        {
            Pair rm = queue.remove();

                        

            if(rm.i==0 || rm.j ==0)
            {
                System.out.println(rm.psf);
            }
            else
            {
                int cval = dp[rm.i][rm.j];
                int pval1 = dp[rm.i - 1][rm.j];
                if(cval == pval1)
                {
                    queue.add(new Pair(rm.i-1, rm.j , rm.psf));
                }
                if(rm.j >= wt[rm.i-1])
                {
                    int pval2 = dp[rm.i-1][rm.j-wt[rm.i-1]];

                    if(pval2 + val[rm.i-1] == cval)
                    {
                        queue.add(new Pair(rm.i-1, rm.j-wt[rm.i-1] , rm.psf + val[rm.i-1] + " "));
                    }
                }
            }
        }

    }
}
