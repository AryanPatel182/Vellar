import java.util.*;
import java.io.*;

public class FindAllAnagramsInAString {

    public static boolean compare( HashMap<Character, Integer> smap,  HashMap<Character, Integer> pmap)
    {   
        
        for(char chr:smap.keySet())
        {
        
            if(pmap.getOrDefault(chr, 0)-smap.get(chr) != 0)
            {     
                return false;                        
            }
        }
            
        return true;
    }
    public static List<Integer> findAnagrams(String s, String p) 
    {        
        List<Integer> ans = new ArrayList<>();

        if(s.length() < p.length())
        {
            return ans;
        }

        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        for (int i=0; i<p.length(); i++)
        {
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<p.length(); i++)
        {
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }

    
        int i = p.length();
        
        while(i<s.length())
        {         
            
            if(compare(smap, pmap))
            {                                
                ans.add(i-p.length());
            }

            char ch1 = s.charAt(i);
            smap.put(ch1, smap.getOrDefault(ch1, 0)+1);

            char ch2 = s.charAt(i-p.length());
            if(smap.get(ch2) == 1)
            {
                smap.remove(ch2);
            }
            else
            {
                smap.put(ch2, smap.get(ch2)-1);
            }
            i+=1;            
        }

        if(compare(smap, pmap) == true)
        {
            ans.add(i-p.length());
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
        String p = scn.next();


        scn.close();
        List<Integer> ans = findAnagrams(s,p);
        System.out.println(ans);


    }
}
