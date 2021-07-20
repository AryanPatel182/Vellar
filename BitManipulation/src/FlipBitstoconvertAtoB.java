import java.util.*;
import java.io.*;

public class FlipBitstoconvertAtoB {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int A = scn.nextInt();
        int B = scn.nextInt();

        scn.close();
        int xor = A ^ B;

        int count = 0;
        while(xor!=0)
        {
            int rmsb = xor&(-xor);
            count++;
            xor-=rmsb;
        }

        System.out.println(count);

    }
}
