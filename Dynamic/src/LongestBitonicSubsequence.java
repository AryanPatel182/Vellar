import java.util.*;
import java.io.*;

public class LongestBitonicSubsequence {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = scn.nextInt();
        }
        scn.close();

        int[] dp1 = new int[n];

        dp1[0] = 1;        
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < val) {
                    max = Math.max(dp1[j], max);
                }
            }

            dp1[i] = max + 1;
        
        }


        int[] dp2 = new int[n];
        dp2[n-1] = 1;        
        for (int i = n-2; i >= 0; i--) {
            int val = arr[i];
            int max = 0;
            for (int j = n-1; j > i; j--) {
                if (arr[j] < val) {
                    max = Math.max(dp2[j], max);
                }
            }

            dp2[i] = max + 1;
            
        }

        int ans = 0;
        for(int i = 0 ;i<n; i++)
        {
            ans = Math.max(ans, dp1[i]+dp2[i]-1);
        }

        System.out.println(ans);

    }
}
