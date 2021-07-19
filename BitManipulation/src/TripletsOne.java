import java.util.*;
import java.io.*;

public class TripletsOne {
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

        int count = 0;
        for(int i = 0 ; i<n; i++)
        {
            int val = arr[i];
            for(int k = i+1; k<n ;k++)
            {
                val = val ^ arr[i];

                if(val == 0)
                {
                    count = count + k - i;
                }
            }
        }

        System.out.println(count);

        scn.close();

    }
}
