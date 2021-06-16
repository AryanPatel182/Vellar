import java.util.*;
import java.io.*;

public class MaxSumNonadjacent {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i] = scn.nextInt();
        }

        int in = arr[0];
        int en = 0;

        for(int i=1; i<n; i++)
        {
            int nin = en + arr[i];
            int nen = Math.max(in,en);

            in = nin ;
            en = nen;
        }
        
        System.out.println(Math.max(in, en));
        scn.close();

    }
}
