import java.util.*;
import java.io.*;

public class print_all_subsequence {

    public static void printSS(String str , String ans) 
    {
    
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String ns = str.substring(1);
        printSS(ns, ans);
        printSS(ns, ch + ans );

    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String str = scn.next();

        printSS(str , "");




        
        scn.close();
    }
}
