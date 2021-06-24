import java.util.*;
import java.io.*;

public class MooresVotingAlgo {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];
    
        for(int i = 0; i<n ; i++)
        {
            arr[i] = scn.nextInt();
        }

        int val = arr[0];
        int count = 1;
        
        scn.close();
        for(int i = 1; i<arr.length ; i++)
        {
            if(arr[i] == val)
            {
                count++;
            }else{
                count--;
            }
            if(count== 0)
            {
                val = arr[i];
                count = 1;
            }
        }

        count = 0; 

        for(int i = 0 ; i<arr.length ; i++)
        {
            if(arr[i] == val) count++;
        }
        if(count > arr.length /2)
        {
            System.out.println(val);
        }
        else{
            System.out.println("No Majority Element Exist");
        }

    }
}
