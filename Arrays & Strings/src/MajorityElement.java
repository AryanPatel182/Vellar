import java.util.*;
import java.io.*;

public class MajorityElement {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] arr = new int[n];

        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0; i<n ;i++)
        {
            arr[i] = scn.nextInt();
            if(hmap.containsKey(arr[i]) == false)
            {
                hmap.put(arr[i] , 1);
            }
            else{
                int ov= hmap.get(arr[i]);
                int nv = ov +1;
                hmap.put(arr[i], nv);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int e : hmap.keySet())
        {
            if(hmap.get(e) > n/k)
            {
                ans.add(e);
            }
        }

        Collections.sort(ans);
        System.out.println(ans);
        scn.close();

    }
}
