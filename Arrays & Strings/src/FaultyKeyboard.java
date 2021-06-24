import java.util.*;
import java.io.*;

public class FaultyKeyboard {

    public static boolean IsPosible(String name, String typed)
    {
        int i = 0, j = 0;
        if (name.length() > typed.length()) {
            return false;
        }

        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        while (j < typed.length()) {
            if (typed.charAt(j) == name.charAt(i - 1)) {
                j++;
            } else {
                return false;
            }
        }

        return i < name.length() ? false : true;
    }
    
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String name = scn.next();
        String typed = scn.next();

        scn.close();

        System.out.println(IsPosible(name, typed));
        

    }
}
