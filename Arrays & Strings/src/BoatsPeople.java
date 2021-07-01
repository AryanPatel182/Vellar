import java.util.*;
import java.io.*;

public class BoatsPeople {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int limit = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i= 0; i<n; i++)
        {
            arr[i]= scn.nextInt();
            
        }
        scn.close();

        Arrays.sort(arr);

        int i = 0 , j= arr.length-1;
        int boats =0;
        while(i<=j)
        {
            if(arr[i] + arr[j] <= limit)
            {
                boats++;
                i++;
                j--;            
            }
            else{
                j--;
                boats++;
            }
        }

        System.out.println(boats);
    }
}
