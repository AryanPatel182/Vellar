import java.util.*;
import java.io.*;

public class PrintAllPathsMinJumps {

    public static class Pair {

        String psf;
        int i;
        int j;

        Pair(String psf , int i , int j)
        {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }        
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr= new int[n];
        

        for(int i = 0 ; i< n ;i++)
        {
            arr[i] = scn.nextInt();
        }

        Integer[] dp  = new Integer[n];

        dp[n-1] = 0;
        for(int i = n-2; i>=0 ;i--)
        {
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j<=arr[i] && i+j < n; j++)
            {
                if(dp[i+j] !=null && dp[i+j] <= min)
                {
                    min = dp[i+j];
                }                
            }
            if(min!= Integer.MAX_VALUE){
                dp[i] = min + 1;
            }            
        }

        System.out.println(dp[0]);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("0", 0, arr[0]));

        while(queue.size()>0)
        {
            Pair rm = queue.remove();

            if(rm.j == 0)
            {
                System.out.println(rm.psf);
            }
            
            for(int j = 1 ; j <= rm.j  && rm.i+j < n; j++)
            {
                if(dp[rm.i+j] != null && dp[rm.i+j]==dp[rm.i]-1)
                {
                    queue.add(new Pair(rm.psf + " -> " + (rm.i+j) , rm.i+j , arr[rm.i+j]));
                }
            }
        }
        scn.close();

    }
}
