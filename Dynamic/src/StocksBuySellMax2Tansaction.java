import java.util.*;
import java.io.*;

public class StocksBuySellMax2Tansaction {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i= 0; i<n ;i++)
        {
            arr[i] = scn.nextInt();            
        }

        int minl = arr[0];
        int mpsf = 0;
        int[] dpl = new int[n+1];
        for(int i = 1; i< n ; i++)
        {
            if(arr[i]<minl)
            {
                minl = arr[i];
            }
            mpsf = arr[i] - minl;
            if(mpsf < dpl[i-1])
            {
                dpl[i] = mpsf;
            }
            else            
                dpl[i] =  dpl[i-1];
        }


        int maxr = arr[n-1];
        int mpsfr = 0;
        int[] dpr = new int[n+1];
        for(int i = n-2; i>= 0 ; i--)
        {
            if(arr[i]>maxr)
            {
                maxr = arr[i];
            }
            mpsfr = maxr - arr[i];
            if(mpsfr > dpr[i+1])
            {
                dpr[i] = mpsfr;
            }
            else{
                dpr[i] = dpr[i+1];
            }                        
        }

        int ans = 0;
        for(int i = 0 ; i<n ; i++)
        {
            if(dpl[i] + dpr[i] > ans)
            {
                ans = dpl[i] + dpr[i];
            }
        }

        System.out.println(ans);
        scn.close();

    }
}
