import java.util.*;
import java.io.*;

public class CountInversions {
    static int count = 0;

    public static int[] merging(int[] arr,int[] left , int[] right) {
        
        int i = 0;
        int j = 0;

        int k = 0;
        int[] ans = new int[left.length + right.length];
        while(i<left.length && j<right.length)
        {
            if(left[i] <= right[j])
            {                
                ans[k] = left[i];
                i++;
                k++;
            }
            else
            {
                count += left.length-i;
                ans[k] = right[j];
                j++;
                k++;
            }            
        }

        while(i<left.length)
        {
            ans[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length)
        {
            ans[k] = right[j];
            j++;
            k++;
        }
        return ans;
    }

    public static int[] mergesort(int[] arr, int lo , int hi)
    {
        if(lo==hi)
        {
            int[] d = new int[1];
            d[0] = arr[lo];
            return d;
        }
        int mid = (lo+hi)/2;

        int left[] = mergesort(arr, lo, mid);
        int right[] = mergesort(arr, mid+1, hi);

        int ans[] = merging(arr,left,right);

        return ans;

    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i<n ;i++)
        {
            arr[i] = scn.nextInt();
        }

        scn.close();

        int ans[] = mergesort(arr,0,n-1);

        System.out.println(count);
        for(int i = 0 ; i<n ;i++)
        {
            System.out.print(ans[i] + " ");
        }


    }
   
}
