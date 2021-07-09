import java.util.*;
import java.io.*;

public class MaximumSumSubarrayAtlestK {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();

        int[] cmaxarr = new int[n];
        int csum = arr[0];
        cmaxarr[0] = csum;
        
        for(int i= 1; i <n; i++)
        {
            if(csum > 0)
            {
                csum += arr[i];
            }
            else
            {
                csum = arr[i];
            }
            
            cmaxarr[i] = csum;
            // System.out.println(csum);
        }

        int sum = 0 ;
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i<k ;i++)
        {
            sum = sum + arr[i];
        }
        ans = Math.max(ans, sum);

        for(int i = k ; i<n; i++)
        {
            sum = sum + arr[i] - arr[i-k];      
            ans = Math.max(sum, ans);               
            ans = Math.max(ans, sum+cmaxarr[i-k]);
        }

        System.out.println(ans);        
    }
}
