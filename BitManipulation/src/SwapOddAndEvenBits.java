import java.util.*;
import java.io.*;

public class SwapOddAndEvenBits {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        scn.close();
        int em = 0xAAAAAAAA;
        int om = 0x55555555;
        
        int odds =  n&em;
        int evens = n&om;

        odds>>=1;
        evens<<=1;

        n = odds|evens;

        System.out.println(n);

    }
}
