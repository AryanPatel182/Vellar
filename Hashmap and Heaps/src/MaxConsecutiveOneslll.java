import java.util.*;
import java.io.*;

public class MaxConsecutiveOneslll {
    public static int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        int j = -1;
        int count = 0;
        for(int i=0; i<n; i++)
        {
            if(arr[i] == 0)
            {
                count+=1;
            }

            while(count > k)
            {
                j+=1;
                if(arr[j] == 0)
                {
                    count-=1;
                }
            }

            ans = Math.max(ans,i-j);
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

        int k = scn.nextInt();        
        System.out.println(longestOnes(arr, k));
        scn.close();

    }
}
