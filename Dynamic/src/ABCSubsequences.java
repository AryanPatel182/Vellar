import java.util.*;
import java.io.*;

public class ABCSubsequences{
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        String str = scn.next();

        int a = 0;
        int ab = 0;
        int abc = 0;

        for(int i = 0 ; i<str.length();i++){
            if(str.charAt(i)=='a'){
                a = 2*a + 1;
            }
            else if(str.charAt(i)=='b'){
                ab = 2*ab + a;
            }
            else if(str.charAt(i)=='c'){
                abc = 2*abc + ab;
            }
        }
        System.out.println(abc);
        scn.close();

    }
}
