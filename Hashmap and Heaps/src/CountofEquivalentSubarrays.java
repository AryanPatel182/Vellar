import java.util.*;
import java.io.*;

public class CountofEquivalentSubarrays {
    public static int counteqsubarray(String s, int k) 
    {
        int n = s.length();
        int ans = 0; 

        HashMap<Character, Integer> map = new HashMap<>();

        int i = -1;
        int j = -1;
        while(true)
        {
            boolean f1 = false;
            boolean f2 = false;

            while(i<n-1)
            {
                i+=1;
                f1 = true;

                char ch = s.charAt(i);

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if(map.size() == k)
                {
                    ans += (n - i);
                    break;
                }                
            }

            while(j<i)
            {
                j+=1;
                f2 = true;

                char ch = s.charAt(j);

                if(map.get(ch) == 1)
                {
                    map.remove(ch);
                }
                else
                {
                    map.put(ch, map.get(ch)-1);
                }


                if(map.size() == k)
                {
                    ans += (n - i);
                }
                else
                {
                    break;                    
                }                
            }
            if(f1 == false  && f2 == false)
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
        
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++)
        {
            set.add(s.charAt(i));
        }

        System.out.println(counteqsubarray(s, set.size()));
        scn.close();

    }
}
