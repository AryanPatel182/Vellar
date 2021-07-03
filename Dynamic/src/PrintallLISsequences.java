import java.util.*;
import java.io.*;

public class PrintallLISsequences {

    /**
     * Pair
     */
    public static class Pair 
    {
        int l;
        int i;    
        int v;
        String psf;

        Pair(int l, int i , int v,String psf)
        {
            this.l = l;
            this.i= i;
            this.v = v;
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
        int[] arr = new int[n];

        for(int i = 0 ; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n];
        int omax = 0;
        
        for(int i=0 ; i<n; i++)
        {            
            int max= 0;
            for(int j= 0 ; j<i; j++)
            {
                if(arr[j] < arr[i])
                {
                    max= Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            omax = Math.max(omax, dp[i]);
        }

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for(int i= 0 ; i<n; i++)
        {
            if(dp[i] == omax)
            {
                queue.add(new Pair(dp[i] , i , arr[i] ,""+arr[i]));
            }
        }

        while(queue.size()>0)
        {
            Pair rm = queue.remove();

            if(rm.i == 0)
            {
                System.out.println(rm.psf);
            }
            for(int i = rm.i ; i >= 0 ; i--)
            {
                if(dp[i] == rm.l-1 && arr[i]<=rm.v)
                {
                    queue.add(new Pair(dp[i], i , arr[i], arr[i] + " - " +rm.psf));
                }
            }
        }

        scn.close();

    }
}
