import java.util.*;
import java.io.*;


public class MajorityElement2 {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int val1 = arr[0];
        int count1 = 1;
        int val2 = arr[1];
        int count2 = 0;
        

        scn.close();
        for (int i = 1; i < arr.length; i++) 
        {
            if(arr[i] == val1)
            {
                count1++;    
            }
            else if(arr[i] == val2)
            {
                count2++;
            }
            else{
                if(count1 == 0)
                {
                    val1 = arr[i];
                    count1 =1;
                }
                else if(count2==0)
                {
                    val2 = arr[i];
                    count2 = 1;
                }
                else{
                    count1--;
                    count2--;
                }
            }
        }

        count1 = 0;
        count2 = 0;
        for(int e : arr)
        {
            if(e == val1)
            {
                count1 ++;
            }
            if(e == val2)
            {
                count2++;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
                
        if(count1>arr.length/3)
        {
            ans.add(val1);
        }
        if(count2>arr.length/3)
        {
            if(val1!=val2)
                ans.add(val2);
        }

        System.out.println(ans);


    }
}
