import java.util.*;
import java.io.*;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) 
    {
        String ans = "";

        int n1 = s.length();
        int n2 = t.length();

        HashMap<Character, Integer> hmap = new HashMap<>();

        for(int i=0; i<n2; i++)
        {
            char ch = t.charAt(i);
            int temp = hmap.getOrDefault(ch, 0);
            hmap.put(ch, temp+1);
        }

        int i=-1;
        int j=-1;
        int mct = 0;        
        int dmct = n2;

        HashMap<Character, Integer> hmap2 = new HashMap<>();

        while(true)
        {
            boolean flag1 = false;
            boolean flag2 = false;

            while(i<n1-1 && mct<dmct)
            {
                i+=1;
                char ch = s.charAt(i);        
                hmap2.put(ch, hmap2.getOrDefault(ch, 0)+1);
                if(hmap.getOrDefault(ch,0) >= hmap2.getOrDefault(ch,0))
                {
                    mct+=1;                    
                }                                
                flag1 = true;                
            }            
            while(j<i && mct==dmct)            
            {
                String pans = s.substring(j+1, i+1);                
                if(ans.length() == 0 || (pans.length() < ans.length()))
                {
                    ans = pans;
                }                
                j+=1;
                char ch = s.charAt(j);

                if(hmap2.get(ch) == 1)
                {
                    hmap2.remove(ch);
                }
                else
                {
                    hmap2.put(ch, hmap2.getOrDefault(ch,0)-1);
                }

                if(hmap2.getOrDefault(ch,0) < hmap.getOrDefault(ch,0))
                {
                    mct-=1;
                }
            
                flag2 = true;
            }

            if(flag1==false && flag2 == false)
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
        String t = scn.next();

        System.out.println(minWindow(s, t));
        scn.close();

    }
}
