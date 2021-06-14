import java.util.*;
import java.io.*;

public class target_sum_subsets {

    public static void printTargetSumSubset(int i, int k, int[] arr, String util) 
    {
        if(k==0)
        {
            System.out.println(util);
            return;
        }
        else if(k<0 || i>arr.length-1)
        {
            return;
        }

        printTargetSumSubset(i+1, k-arr[i], arr, util+arr[i]+" ");
        printTargetSumSubset(i+1, k, arr, util);

    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n =  scn.nextInt();
        int k = scn.nextInt();
        int[] arr  =new int[n];
        for(int i=0; i<n ;i++)
        {
            arr[i] = scn.nextInt();
        }

        printTargetSumSubset(0,k,arr,"");
        scn.close();

    }
}
