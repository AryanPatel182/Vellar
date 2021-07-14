import java.util.*;
import java.io.*;

public class ChocolateDistribution {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();

        Arrays.sort(arr);
        int l = 0;
        int h = l+k-1;

        int ans = Integer.MAX_VALUE;
        while(h<n)
        {
            ans = Math.min(ans, arr[h]-arr[l]);
            l=l+1;
            h=h+1;
        }

        System.out.println(ans);
    }
}
