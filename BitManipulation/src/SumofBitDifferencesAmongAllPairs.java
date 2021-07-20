import java.util.*;
import java.io.*;

public class SumofBitDifferencesAmongAllPairs {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        scn.close();

        int res = 0;
        for(int i = 0 ; i<32; i++)
        {
            int count = 0;
            for(int j = 0 ; j < n; j++)
            {
                if((arr[j]&(1<<i)) != 0)
                {
                    count++;                    
                }
            }
            res+= (count*(n-count)*2);
        }
        System.out.println(res);

    }
}
