import java.util.*;
import java.io.*;

public class KadensAlgo {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        int[] arr= new int[n];

        for(int i = 0 ; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int csum = arr[0];
        int osum = arr[0];

        for(int i = 1; i<n ;i++)
        {
            if(csum  < 0)
            {
                csum = arr[i];
            }
            else{
                csum += arr[i];
            }

            osum = Math.max(osum, csum);
        }

        System.out.println(osum);

        scn.close();

    }
}
