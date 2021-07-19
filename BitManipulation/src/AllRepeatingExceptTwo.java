import java.util.*;
import java.io.*;

public class AllRepeatingExceptTwo {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr=  new int[n];

        for(int i=0;i <n ; i++)
        {
            arr[i]= scn.nextInt();
        }

        int oxor = 0;
        for(int val: arr)
        {
            oxor = oxor ^ val;
        }

        int sbit = oxor & -oxor;

        int a= 0;
        int b= 0;
        for(int val : arr)
        {
            if((val & sbit) == sbit)
            {
                a = a ^ val;
            }
            else
            {
                b = b ^ val;
            }
        }
        scn.close();

        System.out.println(a);
        System.out.println(b);

    }
}
