import java.util.*;
import java.io.*;

public class Basic {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int i = scn.nextInt();      // On
        int j = scn.nextInt();      // Off
        int k = scn.nextInt();      // Toggle
        int m = scn.nextInt();      // Set or Unset

        scn.close();

        int onmask = (1 << i);
        int offmask = ~(1 << j);
        int togglemask = (1 << k);
        int checkmask = (1 << m);

        System.out.println( n | onmask );
        System.out.println( n & offmask );
        System.out.println( n ^ togglemask );
        System.out.println( (n & checkmask) == 0 ? false : true );

    }
}
