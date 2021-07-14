import java.util.*;
import java.io.*;

public class alphabeticalString {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        
        int t = scn.nextInt();
    
        while(t>0)
        {
            String s = scn.next();
            String ans = "YES";
            
            int n = s.length();

            int idx = -1;
            for(int i = 0 ; i<n ;i++)
            {
                if(s.charAt(i) == 'a')
                {
                    idx = i;
                }
            }

            
            if(idx == -1)
            {
                System.out.println("NO");
                continue;
            }
            int left = idx-1;
            int right = idx+1;
            int k = 98;
            
            while(left>=0 && right<n)
            {
                if(s.charAt(left) == k)
                {
                    left-=1;
                    k += 1;
                }
                else if(s.charAt(right) == k)
                {
                    right+=1;
                    k += 1;
                }
                else{
                    ans = "NO";
                    break;
                }
            }

            while(left>=0)
            {
                if(s.charAt(left) == k)
                {
                left-=1;
                    k+=1;
                }
                else
                {
                    ans = "NO";
                    break;
                }
            }

            
            while(right<n)
            {
                if (s.charAt(right) == k) {
                    right += 1;
                    k += 1;
                } else {
                    ans = "NO";
                    break;
                }
            }

            
            System.out.println(ans);

            t = t-1;
        }
        scn.close();
    
    }
}
