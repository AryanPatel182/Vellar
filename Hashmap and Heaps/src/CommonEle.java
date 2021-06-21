import java.util.*;
import java.io.*;

public class CommonEle {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for(int i = 0; i< n1 ; i++)
        {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for(int i = 0 ; i< n2 ;  i++)
        {
            a2[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i = 0 ; i < n1 ; i++)
        {
            if(hmap.containsKey(a1[i]))
            {
                int ov = hmap.get(a1[i]);
                int nv= ov +1;
                hmap.put(a1[i], nv);

            }
            else{
                hmap.put(a1[i], 1);
            }
        }

        for(int i = 0 ; i<n2; i++)
        {
            if(hmap.containsKey(a2[i]))
            {
                System.out.println(a2[i]);
                hmap.remove(a2[i]);
            }
        }
        scn.close();

    }
}
