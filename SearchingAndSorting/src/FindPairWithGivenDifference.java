import java.util.*;
import java.io.*;

public class FindPairWithGivenDifference {
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
        int target = scn.nextInt();

        Arrays.sort(arr);
        int i = 0;
        int j = i+1;

        boolean ans = false;
        while(i<n && j<n)
        {
            if(arr[j]-arr[i] == target)
            {                
                ans = true;
                System.out.println(arr[i] + " " + arr[j]);
                break;
            }
            else if(arr[j]-arr[i] > target)
            {
                i+=1;
            }
            else
            {
                j+=1;
            }            
        }

        scn.close(); 
        System.out.println(ans);

    }
}
