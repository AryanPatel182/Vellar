import java.util.*;
import java.io.*;

public class CountBinaryStrings {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int o0 = 1;
        int o1 = 1;

        for(int i=2; i<=n;i++)
        {
            int n0 = o1;
            int n1 = o1 + o0;

            o0 = n0;
            o1 = n1;
        }

        System.out.println(o0 + o1); 
        scn.close();

    }
}
