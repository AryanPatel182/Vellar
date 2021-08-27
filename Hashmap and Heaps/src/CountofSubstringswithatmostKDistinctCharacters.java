import java.util.*;
import java.io.*;

public class CountofSubstringswithatmostKDistinctCharacters {
    public static int CountLongestAtmostKSub(String s, int k){
        int ans = 0 ;
        int n = s.length();
        HashMap<Character, Integer> hmap = new HashMap<>();
        int i= -1;
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

                hmap.put(ch, hmap.getOrDefault(ch,0)+1);

                if(hmap.size() > k)
                {
                    break;
                }
                else
                {
                    ans+= (i-j);                    
                }
            }

            if(i==n && hmap.size() <= k)
            {
                break;
            }

            while(j<i)
            {
                f2 = true;
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
                
                if(hmap.size() == k)
                {
                    ans += (i - j);
                    break;
                }                   
            }

            if(f1 == false && f2 == false)
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
        int k = scn.nextInt();

        System.out.println(CountLongestAtmostKSub(s,k));
        scn.close();

    }
}
