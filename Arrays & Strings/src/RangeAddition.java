import java.util.*;
import java.io.*;

public class RangeAddition {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int qry = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < qry ; i++)
        {
            int si = scn.nextInt();
            int ei = scn.nextInt();
            int val = scn.nextInt();

            arr[si] += val;
            if(ei+1 < n)
                arr[ei+1] = arr[ei+1] - val;
        }

        int sum = 0;
        for(int i = 0 ; i<n; i++)
        {
            sum = sum + arr[i];
            arr[i] = sum;
            System.out.println(arr[i]);
        }

        scn.close();

    }
}
