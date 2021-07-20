import java.util.*;
import java.io.*;

public class CheckifBinaryStringisDivisibleby3 {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        String s = scn.next();
        
        scn.close();
        int odd = 0;
        int even = 0;

        for(int i=0; i<s.length(); i++)
        {
            int bit = s.charAt(i)-'0';
            if(i%2 == 0) 
            {
                even+= bit;
            }
            else
            {
                odd+= bit;
            }
        }        

        int dif = odd-even;

        if(dif%11 ==0)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }


    }
}
