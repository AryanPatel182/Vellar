
import java.util.*;
import java.io.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ;i< n; i++)
        {
            arr[i] = scn.nextInt();
        }

        HashMap<Integer , Boolean> hmap = new HashMap<>();

        for(int val : arr)
        {
            hmap.put(val, true);
        }

        for(int val : arr)
        {
            if(hmap.containsKey(val-1))
                hmap.put(val, false);            
        }

        int osp = 0;
        int ol = 0;

        for(int val : arr)
        {
            if(hmap.containsKey(val))
            {
                int tsp = val;
                int tl = 1;

                while(hmap.containsKey(tsp+tl))
                {
                    tl++;
                }

                if(tl > ol)
                {
                    ol = tl;
                    osp = tsp;
                }
            }
        }

        System.out.println(osp + " " + ol);

        // System.out.println(hmap);
        scn.close();

    }
}
