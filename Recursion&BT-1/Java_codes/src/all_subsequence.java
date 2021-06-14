import java.util.*;
import java.io.*;

public class all_subsequence {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);


        String s = scn.next();
        scn.close();
        ArrayList<String> res = subseq(s);        
        System.out.println(res);    
    }

    public static ArrayList<String> subseq(String s)
    {
        if(s.length()==0)
        {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add("");
            return temp;
        }
        char ch = s.charAt(0);
        ArrayList<String> rans = subseq(s.substring(1));

        ArrayList<String> mans = new ArrayList<String>();
        for(String val:rans)
        {
            mans.add(""+val);            
        }
        for(String val:rans)
        {            
            mans.add(ch+val);
        }

        return mans;
    }
}
