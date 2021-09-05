import java.util.*;
import java.io.*;

public class CountSubarrayswithSumEqualsK {
    public static int countsubsumK(int[] arr, int k) 
    {
        int ans = 0;
        int n = arr.length;

        int psum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            psum += val;

            if (map.containsKey(psum - k)) {
                ans += (map.get(psum - k));
            }

            map.put(psum, map.getOrDefault(psum, 0) + 1);
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

        
        System.out.println(countsubsumK(arr, k));

        scn.close();

    }
}
