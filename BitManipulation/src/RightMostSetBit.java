import java.util.*;
import java.io.*;

public class RightMostSetBit {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int x = scn.nextInt();

        int rmsb = x & -x;

        System.out.println(Integer.toBinaryString(rmsb));
        scn.close();

    }
}
