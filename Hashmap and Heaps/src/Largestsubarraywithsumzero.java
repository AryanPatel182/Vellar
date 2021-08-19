import java.util.*;
import java.io.*;

public class Largestsubarraywithsumzero {
    public static int maxLen(int arr[], int n)
    {
        // Your code here        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        
        int sum = 0;
        hmap.put(sum,-1);
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            sum+=arr[i];
            if(hmap.containsKey(sum))
            {
                int count = i-hmap.get(sum);
                ans = Math.max(ans,count);
            }
            else
            {
                hmap.put(sum,i);
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
        int[] arr= new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        
        System.out.println(maxLen(arr, n));
        scn.close();

    }
}
