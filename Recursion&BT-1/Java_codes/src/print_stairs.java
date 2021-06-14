import java.util.*;
import java.io.*;


public class print_stairs {

    public static void stair(int n , String util) {
        if(n==0)
        {
            System.out.println(util);
            return;
        }else if(n<0)
        {
            return;
        }
        
        stair(n-1 , util + '1');
        stair(n-2 , util + '2');
        stair(n-3 , util + '3');
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        
        scn.close();    

        stair(n , "");
    }
}
