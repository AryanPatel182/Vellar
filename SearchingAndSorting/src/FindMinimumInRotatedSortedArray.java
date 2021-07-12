import java.util.*;
import java.io.*;

public class FindMinimumInRotatedSortedArray {
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
        scn.close();

        if(arr[0]<=arr[n-1])
        {
            System.out.println(arr[0]);
            return;
        }

        int l = 0;
        int h = n-1;

        while(l<=h)
        {
            int mid = (l+h)/2;

            if(arr[mid]>arr[mid+1])
            {
                System.out.println(arr[mid+1]);
                break;
            }
            else if(arr[mid]<arr[mid-1])
            {
                System.out.println(arr[mid]);
                break;
            }
            else if(arr[l]<=arr[mid])
            {
                l = mid+1;
            }
            else if(arr[mid]<=arr[h])
            {
                h = mid-1;
            }
        }
                
    }
}
