import java.util.*;
import java.io.*;

public class CountZerosXorPairs {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        
        scn.close();

        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i =0;  i<n ;i++)
        {
            if(hmap.containsKey(arr[i]))            
            {
                hmap.put(arr[i], hmap.get(arr[i])+1);
            }            
            else
            {
                hmap.put(arr[i], 1);
            }
        }

        int count = 0;
        for(int key:hmap.keySet())
        {
            int val = hmap.get(key);
            count = count + (val*(val-1))/2;                    
        }

        System.out.println(count);


    }
}
