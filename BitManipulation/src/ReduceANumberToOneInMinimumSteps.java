import java.util.*;
import java.io.*;

public class ReduceANumberToOneInMinimumSteps {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        long n = scn.nextInt();
        
        int count  = 0;
        while(n!=1)
        {
            if(n%2 == 0)
            {
                n = n/2;                
            }
            else if(n==3)
            {
                n =  n-1;
            }
            else if((n&3) == 1)
            {
                n = n-1;
            }
            else if((n&3) == 3)
            {
                n = n+1;
            }
            count++;
        }

        scn.close();
        System.out.println(count);

    }
}
