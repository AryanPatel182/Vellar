import java.util.*;
import java.io.*;

public class CopySetBitsInaRange {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int A = scn.nextInt();
        int B = scn.nextInt();
        int left = scn.nextInt();
        int right = scn.nextInt();


        int gap = right-left+1;
        int mask = 1<<gap;
        mask--;
        mask = mask << (left-1);

        A = A & mask;
        System.out.println(A|B);
        scn.close();

    }
}
