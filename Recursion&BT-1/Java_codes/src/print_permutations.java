import java.util.*;
import java.io.*;

public class print_permutations {

    public static void permutations(String str, String util) {
        if(str.length()==0)
        {
            System.out.println(util);
            return;
        }


        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            String str1 = str.substring(0, i) ;
            String str2 = str.substring(i+1);
            permutations(str1+str2, util+ch);
        }
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String str = scn.next();
        scn.close();

        permutations(str, "");
    }
    
}
