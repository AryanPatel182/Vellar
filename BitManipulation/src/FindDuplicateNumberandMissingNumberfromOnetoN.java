import java.util.*;
import java.io.*;

public class FindDuplicateNumberandMissingNumberfromOnetoN{    
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];
        int xor = 0;
        for (int i = 0; i <n; i++) {
            arr[i] = scn.nextInt();            
            xor = xor^arr[i];
        }
        for(int i = 1; i<=n ; i++)
        {
            xor = xor^i;
        }

        int fbit = xor & -xor;
        
        scn.close();
        int x = 0;
        int y = 0;

        for(int val:arr)
        {
            if((fbit & val)==0)
            {
                x = x^val;
            }
            else
            {
                y = y^val;
            }
        }

        for(int val:arr)
        {
            if(val==x)
            {
                System.out.println("Missing Number -> "+ y);
                System.out.println("Repeating Number -> "+ x);
                break;
            }
            else
            {
                System.out.println("Missing Number -> " + x);
                System.out.println("Repeating Number -> " + y);
                break;
            }
        }
        

    }
}
