import java.util.*;
import java.io.*;

public class MinimumNumberOfSwapsRequiredToSortAnArray {
    private static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public static void main(String[] args) throws Exception
    {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn. nextInt();
        int[] vals = new int[n];

        for(int i=0; i<n; i++)
        {
            vals[i] = scn.nextInt();
        }

        Pair[] arr = new Pair[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = new Pair(vals[i], i);
        }

        Arrays.sort(arr);
        int ans  = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++)
        {
            if(visited[i] == true || arr[i].idx == i)
            {
                continue;
            }
            visited[i] = true;
            int clen = 1;
            int j = arr[i].idx;
            while(visited[j] == false)
            {
                clen+=1;
                visited[j] = true;
                j = arr[j].idx;
            }
            ans += clen-1;
        }

        System.out.println(ans);
        scn.close();
    }
}

