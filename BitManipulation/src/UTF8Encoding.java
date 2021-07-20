import java.util.*;
import java.io.*;

public class UTF8Encoding {
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
        scn.close();

        int rbytes =0;
        for(int val:arr)
        {
            if(rbytes == 0)
            {
                if((val>>7) == 0b0)
                {
                    rbytes = 0;
                }
                else if((val>>5) == 0b110)
                {
                    rbytes = 1;
                }            
                else if((val>>4) == 0b1110)
                {
                    rbytes = 2;
                }
                else if((val>>3) == 0b11110)
                {
                    rbytes = 3;
                }
                else
                {
                    System.out.println(false);
                    return;                    
                }
            }   
            else
            {
                if((val>>6)== 0b10)
                {
                    rbytes--;
                }
                else
                {
                    System.out.println(false);
                    return;

                }
            }
        }


        if(rbytes>0)
        {
            System.out.println(false);
            return;
        }
        else
        {
            System.out.println(true);
        }
        

        


    }
}
