import java.util.*;

import java.io.*;

public class LargestNumberInKSwaps {
    public static String max;
    public static String swap(String s, int i, int j)
    {
        String ans = "";
        for(int k=0; k<s.length(); k++)
        {
            if(k==i)
            {
                ans+=s.charAt(j);
            }
            else if(k==j)
            {
                ans+=s.charAt(i);
            }
            else
            {
                ans+=s.charAt(k);
            }
        }

        return ans;
    }


    public static void helper(String s, int k)
    {
        if(Integer.parseInt(s) > Integer.parseInt(max))
        {
            max = s;
        }
        if(k == 0)
        {
            return;
        }

        for(int i=0; i<s.length()-1; i++)
        {
            for(int j=i+1; j<s.length(); j++)
            {
                if(s.charAt(i) < s.charAt(j))
                {
                    String tmp = swap(s,i,j);
                    helper(tmp, k-1);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int k = scn.nextInt();
        String s = scn.next();
        max = s;
        helper(s,k);
        System.out.println(max);
        scn.close();

    }
}
