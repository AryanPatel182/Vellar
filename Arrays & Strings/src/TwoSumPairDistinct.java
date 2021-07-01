import java.util.*;
import java.io.*;

public class TwoSumPairDistinct {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i<n ; i++)
        {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        
        Arrays.sort(arr);
        int i = 0;
        int j = n-1;

        while(i<j)
        {
            int sum = arr[i] + arr[j];

            if(sum == target)
            {
                if(i!=0 &&  arr[i]==arr[i-1])
                {
                    i++;
                    j--;
                }
                else{
                    System.out.println(arr[i] + " , " + arr[j]);
                    i++;
                    j--;
                }
            }
            else if(sum < target)
            {
                i++;
            }
            else{
                j--;
            }
        }

        

        

    }
}
