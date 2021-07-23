import java.util.*;
import java.io.*;

public class ReverseBitsusingBitManipulation {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int j=0;
        int ans = 0;
        boolean flag = false;
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;

            if (flag) {
                if ((n & mask) != 0) {
                    System.out.print(1);
                    ans |= (1 << j);
                } else {
                    System.out.print(0);                    
                }
                j++;
            }
            else
            {
                if((n&mask) != 0)
                {
                    flag = true;
                    System.out.print(1);
                    ans |= (1<<j);
                    j++;
                }
            }
        }

        System.out.println();
        System.out.println(ans);
        scn.close();

    }
}
