import java.util.*;
import java.io.*;

public class ToppersofClass {
    public static class Pair implements Comparable<Pair>
    {
        int marks;
        int index;

        Pair(int marks , int index)
        {
            this.marks = marks;
            this.index = index;
        }

        public int compareTo(Pair o)
        {
            if(this.marks == o.marks)
            {
                return o.index - this.index;
            }
            return this.marks - o.marks;
        }
        
    }


    public static void findtoppers(int[] arr, int k)
    {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++)
        {
            if(pq.size() < k)
            {
                pq.add(new Pair(arr[i], i));
            }
            else
            {
                if(arr[i] > pq.peek().marks)
                {
                    pq.remove();
                    pq.add(new Pair(arr[i], i));
                }
            }
        }

        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--)
        {
            ans[i] = pq.peek().index;
            pq.remove();
        }

        for(int i=0; i<k; i++)
        {
            System.out.println(ans[i]);
        }
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

        findtoppers(arr,k);
        scn.close();

    }
}
