import java.util.*;
import java.io.*;

public class ValidPalindrom2 {

    public static boolean ispalindrom(String s, int i , int j)
    {
        while(i<j)
        {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        String s = scn.next();
        scn.close();

        int i = 0;
        int j = s.length()-1;

        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                System.out.println(ispalindrom(s, i+1, j) || ispalindrom(s,i,j-1));   
                return;             
            }
        }

        System.out.println(true);
        


    }
}
