import java.util.*;
import java.io.*;

public class HtmlTag {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        while (n >=0) {
            String str = scn.next();

            // char[] ch = str.toCharArray();
            String ans = "Success";            
            if(str.length()<=3)
            {
                ans= "Error";
            }
            else if(str.charAt(0) != '<' || str.charAt(1) != '/')
            {
                ans = "Error";
            }
            else if(str.charAt(str.length()-1) != '>')
            {
                ans = "Error";
            }
            else{
                for(int i = 2 ; i<= str.length()-2; i++)
                {
                    if(!(( str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9')))
                    {
                        ans = "Error";
                    }
                }
            }

            System.out.println(ans);
            n--;
        }
        scn.close();

    }
}
