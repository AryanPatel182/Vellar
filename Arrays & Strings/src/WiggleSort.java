import java.util.*;
import java.io.*;

public class WiggleSort {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int[] arr= new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = scn.nextInt();
        }


        for(int i = 0; i< n-1 ; i++)
        {
            if(i%2 == 0)
            {
                if(arr[i]>arr[i+1])
                {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
                
            }
            else{
                if(arr[i]<arr[i+1])
                {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                
            }
        }

        for(int i= 0; i<n ; i++)
        {
            System.out.print(arr[i] + " ");
        }
        scn.close();

    }
}
