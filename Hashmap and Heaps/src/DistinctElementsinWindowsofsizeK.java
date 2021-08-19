import java.util.*;
import java.io.*;

public class DistinctElementsinWindowsofsizeK {
    public static ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int fq = hmap.getOrDefault(A[i], 0);
            hmap.put(A[i], fq + 1);
        }

        ans.add(hmap.size());
        int i = 0;
        int j = k;

        while (j < n) {
            int fl = hmap.getOrDefault(A[j], 0);
            hmap.put(A[j], fl + 1);

            int ff = hmap.get(A[i]);
            hmap.put(A[i], ff - 1);
            if (hmap.get(A[i]) == 0) {
                hmap.remove(A[i]);
            }

            ans.add(hmap.size());
            j += 1;
            i += 1;
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
        int k  = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> ans = countDistinct(arr, n, k);

        for(int i:ans)
        {
            System.out.print(i + " ");
        }


        scn.close();

    }
}
