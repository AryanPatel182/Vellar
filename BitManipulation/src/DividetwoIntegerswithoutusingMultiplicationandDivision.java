import java.util.*;
import java.io.*;

public class DividetwoIntegerswithoutusingMultiplicationandDivision {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        //  7n/8 without multiplication and division

        int n = scn.nextInt();

        int k = n<<3;
        k = k-n;
        k = k>>3;

        System.out.println(k);
        scn.close();

    }
}
