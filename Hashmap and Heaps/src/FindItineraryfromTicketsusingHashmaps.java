import java.util.*;
import java.io.*;

public class FindItineraryfromTicketsusingHashmaps {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        HashMap<String, String> hmap = new HashMap<>();

        int n = scn.nextInt();
        for(int i=0; i<n; i++)
        {
            hmap.put(scn.next(), scn.next());
        }
        
        HashMap<String, Boolean> temp = new HashMap<>();

        for(String src: hmap.keySet())
        {
            if(!temp.containsKey(src))
            {
                temp.put(src, true);
            }            
            temp.put(hmap.get(src), false);
            
        }

        // System.out.println(temp);
        String ans = "";
        for(String s : temp.keySet())
        {
            if(temp.get(s) == true)
            {
                ans = s;
            }
        }

        System.out.print(ans + " -> ");
        
        while(hmap.containsKey(ans))
        {
            System.out.print(hmap.get(ans) + " -> ");
            ans = hmap.get(ans);
        }

        


        scn.close();





        
        
    }
}
