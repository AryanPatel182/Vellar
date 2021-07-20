import java.util.*;
import java.io.*;

public class PowerofTwo {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream); 
        int n= scn.nextInt();

        if((n&(n-1)) == 0)
        {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

        scn.close();

    }
}
