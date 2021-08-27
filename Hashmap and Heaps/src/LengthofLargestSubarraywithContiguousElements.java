import java.util.*;
import java.io.*;

public class LengthofLargestSubarraywithContiguousElements {
    public static int LargestSubContigous(int[] arr) {
        int ans = 1;
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++)
        {
            min = arr[i];
            max = arr[i];

            for(int j=i+1; j<n; j++)
            {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);

                if((max-min) == (j-i))
                {
                    ans = Math.max(ans ,j-i+1);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        System.out.println(LargestSubContigous(arr));
        scn.close();

    }
}
