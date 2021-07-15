import java.util.*;
import java.io.*;

public class JosephsonProblemAlgorithm {
    public static int poweroftwo(int n) {
        int x = 1;

        while(x*2<=n)
        {
            x = x*2;
        }

        return x;

    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        scn.close();

        int k  = poweroftwo(n);
        
        int l = n-k;
        System.out.println(2*l+1);

    }
}
