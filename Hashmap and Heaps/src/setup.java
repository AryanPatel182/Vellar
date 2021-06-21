import java.util.*;
import java.io.*;

public class setup {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 126);
        hm.put("Australia", 26);
        hm.put("SA", 30);
        hm.put("USA", 34);
        scn.close();

        System.out.println(hm);
        
        hm.put("Shrilanka", 1);
        System.out.println(hm);
        System.out.println(hm.get("India")); 
        System.out.println(hm.get("Russia")); 

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Russia"));
        

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for(String s : keys)
        {
            Integer val = hm.get(s);
            System.out.println(s + " " + val);
        }
    }
}
