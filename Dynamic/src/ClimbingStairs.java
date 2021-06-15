import java.util.*;
import java.io.*;

public class ClimbingStairs {

    public static int climb(int n , int[] qb) {
        
        if(n==0)
        {
            return 1;
        }
        if(n<0)
        {
            return 0;
        }
        if(qb[n]>0)
        {
            return qb[n];
        }


        int p1 = climb(n-1,qb);
        int p2 = climb(n-2,qb);
        int p3 = climb(n-3,qb);

        qb[n] = p1+p2+p3;
        return(p1+p2+p3);
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        
        int n  = scn.nextInt();        
        scn.close();


        int[] qb = new int[n+1];
        System.out.println(climb(n,qb));


        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i<=n; i++)
        {
            if(i==1)
            {
                dp[i] = dp[i-1];
            }
            else if(i==2)
            {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else
            {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }            
        }
        System.out.println(dp[n]);
        
        
    }
}

