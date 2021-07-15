import java.util.*;
import java.io.*;

public class KernighanAlgorithm {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        scn.close();
        int count = 0;
        while(n!=0)
        {
            int rsbm = n&-n;
            count++;
            n = n-rsbm;
        }

        System.out.println(count);
    }
}
