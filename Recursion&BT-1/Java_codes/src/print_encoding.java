import java.util.*;
import java.io.*;

public class print_encoding {

    public static void encodings(String str , String util) {
        if(str.length()==0)
        {
            System.out.println(util);
            return;
        }
        else if(str.length()==1)
        {
            char ch = str.charAt(0);
            if(ch=='0')
            {
                System.out.println(util);
                return;
            }
            else{
                
                int chv = ch - '0';
                char code = (char)('a' + chv -1);
                util = util + code;
                System.out.println(util);
            }
        }else{
            char ch = str.charAt(0);
            String ros = str.substring(1);
            if (ch == '0') {
                System.out.println(util);
                return;
            } else {

                int chv = ch - '0';
                // System.out.println(chv);
                char code = (char) ('a' + chv - 1);
                // System.out.println(code);
                encodings(ros , util+code);
            }

            String ch12 = str.substring(0,2);
            String ros12 = str.substring(2);

            int chv12 = Integer.parseInt(ch12);
            // System.out.println(ch12);
            if(chv12<=26)
            {
                char code = (char) ('a' + chv12 - 1);
                // System.out.println(code);
                encodings(ros12, util + code);
            }
            else{
                return;
            }

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

        encodings(str, "");

    }
}
