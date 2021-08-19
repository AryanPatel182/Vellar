import java.util.*;
import java.io.*;

public class ZeroSumSubarrays {
    public static long findSubarray(long[] arr, int n) {


        HashMap<Long, Long> hmap = new HashMap<>();
        long sum = 0;
        hmap.put(sum, 1l);
        long count = 0;
        for(int i=0; i<n; i++)
        {
            sum+= arr[i];
            if(hmap.containsKey(sum))
            {
                count+= hmap.get(sum);
                hmap.put(sum, hmap.get(sum) +1);
            }
            else
            {
                hmap.put(sum, 1l);
            }
        }
        return count;
        // Your code here
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        long[] arr= new long[n];

        for(int i= 0; i<n; i++)
        {
            arr[i] = scn.nextLong();
        }

        System.out.println(findSubarray(arr, n));

        scn.close();

    }
}
