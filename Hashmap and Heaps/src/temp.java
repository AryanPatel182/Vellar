import java.util.*;
import java.io.*;

public class temp {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        // for(int i = 1; i<=7 ; i++)
        // {
        // hmap.put(i, 1);
        // }
        // System.out.println(hmap);
        while (n != 0) {
            HashMap<Integer, Integer> hmap = new HashMap<>();
            for (int j = 1; j <= 7; j++) {
                hmap.put(j, 1);
            }
            int count = 0;

            // System.out.println(hmap.size());
            int size = scn.nextInt();
            System.out.println(size);
            int[] arr = new int[size + 1];

            for (int i = 1; i <= size; i++) {
                // System.out.println(hmap);
                // arr[i] = scn.nextInt();
                System.out.println(arr[i]);
                if (hmap.containsKey(arr[i])) {
                    hmap.remove(arr[i]);
                    // ans++;
                }
                count++;
                if (hmap.size() == 0) {
                    System.out.println(count);
                    break;
                }

                // System.out.println(hmap);
                // if(i==size-1 && hmap.size()==1)
                // {
                // System.out.println(i+1);
                // break;
                // }

                // System.out.println(hmap);
            }

            // System.out.println(ans);
            n--;

        }
        scn.close();

    }
}

