import java.util.*;
import java.io.*;

public class CarPooling {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int capacity = scn.nextInt();
        String s = "True";
        int[][] arr= new int[n][3];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n ; i++)
        {
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
            arr[i][2] = scn.nextInt();

            if(arr[i][2]>max)
            {
                max = arr[i][2];
            }
        }
        
        
        scn.close();
        int[] psarray = new int[max+1];

        for(int j = 0; j<n; j++)
        {
            psarray[arr[j][1]] += arr[j][0];
            psarray[arr[j][2]] -= arr[j][0];            
        }

        

        
        int sum = 0;

        for(int i = 0 ;i<max+1 ; i++)
        {
            sum = sum + psarray[i];
            psarray[i] = sum;
            if(sum>capacity)
            {
                s = "False";
            }
        }

        System.out.println(s);
        

    }
}
