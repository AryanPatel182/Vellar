import java.util.*;
import java.io.*;

public class PascleTriangle {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int i = scn.nextInt();

        List<Integer> ans = new ArrayList<>();

        long val = 1;
        
        for(int j = 0 ; j <= i ; j++)
        {
            ans.add((int) (val));
            val = (val * (i-j)) / (j+1);            
        }

        System.out.println(ans);
        scn.close();

    }
}
