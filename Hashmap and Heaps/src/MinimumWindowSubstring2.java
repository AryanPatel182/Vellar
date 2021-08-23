import java.util.*;
import java.io.*;

public class MinimumWindowSubstring2 {
    public static String minWindow(String s, String t)
    {
        String ans = "";
        int n1 = s.length();
        int n2 = t.length();
        
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<n2; i++)
        {
            char ch = t.charAt(i);
            set.add(ch);
        }

        HashMap<Character,Integer> hmap = new HashMap<>();
        int i=-1;
        int j=-1;

        while(true)
        {
            boolean f1 = false;
            boolean f2 = false;
            // acquire  
            while(i<n1-1 && hmap.size()<set.size())
            {
                i+=1;
                char ch = s.charAt(i);       
                 
                
                hmap.put(ch, hmap.getOrDefault(ch, 0)+1);                    
                 
                f1 =true;               
            }

            // release

            while(j<i && hmap.size() == set.size())            
            {
                String pans = s.substring(j+1, i+1);
                if(ans.length() == 0 || ans.length() > pans.length())
                {
                    ans = pans;
                }
                j+=1;
                char ch = s.charAt(j);                
            
                if(hmap.get(ch) == 1)
                {
                    hmap.remove(ch);
                }
                else
                {                    
                    hmap.put(ch,hmap.get(ch)-1);
                }
        
                f2 = true;
            }

            if(f1== false && f2 == false)
            {
                break;
            }
        }


        
        return ans;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s = scn.next();
    

        System.out.println(minWindow(s, s));
        scn.close();

    }
}
