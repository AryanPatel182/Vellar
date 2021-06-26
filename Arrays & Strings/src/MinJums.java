import java.util.*;
import java.io.*;

public class MinJums {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int dest = scn.nextInt();
        scn.close();

        int sum = 0;
        int i = 1;

        while(sum < dest)
        {
            sum += i;
            i = i + 1;
        }
        
        if((sum - dest) % 2 == 0)
        {
            System.out.println(i-1);
        }
        else if((sum + i -dest) % 2 == 0)
        {
            System.out.println(i);
        }
        else{
            System.out.println(i+1);
        }

    }
}
