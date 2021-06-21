import java.util.*;
import java.io.*;

public class CommonEle2 {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            if (hmap.containsKey(a1[i])) {
                int ov = hmap.get(a1[i]);
                int nv = ov + 1;
                hmap.put(a1[i], nv);

            } else {
                hmap.put(a1[i], 1);
            }
        }
        System.out.println(hmap);

        for(int val : a2)
        {
            if(hmap.containsKey(val) && hmap.get(val)!=0)
            {
                System.out.println(val);
                int ov = hmap.get(val);
                int nv = ov - 1;
                hmap.put(val, nv);
            }
        }
        scn.close();

    }
}
