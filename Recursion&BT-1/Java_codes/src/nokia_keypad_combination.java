import java.util.*;
import java.io.*;

public class nokia_keypad_combination {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String[] arr = new String[10];
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        
        for(int i=0;i<10;i++)
        {
            String s = scn.nextLine();
            arr[i] = s;            
        }


        scn.close();
        String s1 = arr[a];
        String s2 = arr[b];
        String s3 = arr[c];
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> ans = comb(temp,s1,s2,s3,"");
        System.out.println(ans);
        
    }

    public static ArrayList<String> comb(ArrayList<String> temp, String s1, String s2, String s3,String util)
    {        
        if(s1=="")
        {            
            temp.add(util);
            // System.out.println(temp);
            return temp;
        }
        // ArrayList<String> mans = new ArrayList<>();
        
        for(int i=0;i<s1.length();i++)
        {
            char ch = s1.charAt(i);
            util = util + ch;
            temp = comb(temp,s2,s3,"",util);
            util = util.substring(0, util.length() - 1);
        }

        return temp;
    }
}
