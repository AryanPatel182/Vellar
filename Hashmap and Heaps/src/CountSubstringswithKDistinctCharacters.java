import java.util.*;
import java.io.*;

public class CountSubstringswithKDistinctCharacters {
    public static void remove(HashMap<Character, Integer> map, Character ch) 
    {
        if(map.get(ch) == 1)
        {
            map.remove(ch);
        }
        else
        {
            map.put(ch, map.get(ch) -1);
        }
        
    }

    public static int solveforkOne(String s, int k)
    {
        int ans = 0;

        int n =s.length();

        int i= -1;
        int count = 1;
        while(i<n-1)
        {
            i+=1;
            
            if(i==0)
            {
                if(s.charAt(i+1) == s.charAt(i))                
                {                
                    count+=1;
                }
                else
                {
                    ans += ((count)*(count+1)) / 2;
                    count = 1;
                }
            }   
            else if(i==n-1)         
            {
                ans += (count * (count + 1)) / 2;
            }
            else
            {
                if(s.charAt(i) == s.charAt(i+1))
                {
                    count+=1;
                }
                else
                {                    
                    ans+= (count*(count+1))/2;
                    count = 1;
                }
            }
        }
        
        return ans;
    }

    public static int CountKSub(String s, int k)
    {
        int n = s.length();

        if(k == 1)
        {
            return(solveforkOne(s,k));
        }
        int ans = 0;
        HashMap<Character, Integer>  mapb = new HashMap<>();
        HashMap<Character, Integer>  maps = new HashMap<>();

        int is = -1;
        int ib = -1;
        int j = -1;

        while(true)
        {
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;

            while(ib<n-1)
            {
                f1 = true;
                ib+=1;
                char ch = s.charAt(ib);
                mapb.put(ch, mapb.getOrDefault(ch, 0)+1);

                if(mapb.size() == k+1)
                {
                    remove(mapb,ch);
                    ib-=1;
                    break;
                }
            }

            while(is < ib)
            {
                f2 = true;
                is+=1;
                char ch = s.charAt(is);
                maps.put(ch, maps.getOrDefault(ch, 0)+1);

                if(maps.size() == k)
                {
                    remove(maps, ch);
                    is-=1;
                    break;
                }
            }


            while(j<is)
            {
                f3 = true;
                if(mapb.size() == k && maps.size() == k-1)
                {
                    ans+=(ib-is);
                }
                j+=1;
                char ch =s.charAt(j);
                remove(mapb, ch);
                remove(maps, ch);

                if(mapb.size()<k || maps.size()<k-1)
                {
                    break;
                }
            }

            if(f1 == false && f2 == false && f3 == false)
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

    
        System.out.println(CountKSub(s, k));
        scn.close();

    }
}
