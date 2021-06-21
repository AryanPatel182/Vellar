import java.util.*;
import java.io.*;

public class HighestFreqChar {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String str = scn.next();
        HashMap<Character, Integer> hmap = new HashMap<>();

        for(int i = 0; i<str.length() ; i++)
        {
            char ch = str.charAt(i);
            if(hmap.containsKey(ch))
            {
                int of = hmap.get(ch);
                int nf = of + 1;
                hmap.put(ch, nf);
            }
            else{
                hmap.put(ch, 1);
            }
        }
        int max= 0;
        char ch = ' ';
        for(Character key : hmap.keySet())
        {
            if(hmap.get(key) > max)
            {
                max = hmap.get(key);
                ch = key;
            }
        }

        System.out.println(ch + " " + max);
        scn.close();

    }
}
