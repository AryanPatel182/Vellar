import java.util.*;
import java.io.*;

public class CatalanNumber {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n+1];
        scn.close();
        
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2 ; i<=n ; i++)
        {
            for(int j = 0 ; j<i ; j++)
            {
                arr[i] = arr[i] + arr[j]*arr[i-j-1];
            }
        }

        System.out.println(arr[n]);

    }
}


