import java.util.*;
import java.io.*;

public class StocksBuySellFees {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0 ; i< n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int fees = scn.nextInt();
        
        int obs = -arr[0];
        int oss = 0;

        for(int i =1 ;i<n ; i++)
        {   
            int nbs = oss - arr[i];
            int nss = arr[i] - fees + obs;

            if(nbs < obs)
            {
                nbs = obs;
            }
            if(nss < oss)
            {
                nss = oss;
            }

            obs = nbs;
            oss = nss;
        }

        System.out.println(oss);
        scn.close();

    }
}
