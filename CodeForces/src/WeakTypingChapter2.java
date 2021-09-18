import java.util.*;
import java.io.*;

public class WeakTypingChapter2 {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
    
        long t = scn.nextLong();
        long inc = 1;
        while(t-- > 0)
        {
            long n = scn.nextLong();            
            String s = scn.next();            
            long cnt1=0, cnt2 = 0;
            int flag1=0;
            int flag2=0;
            long ans=0;
            for(int j=0; j<n; j++)
            {             
                cnt1 = cnt2 = flag1 = flag2 = 0;   
                for(int i=j; i<s.length(); i++)
                {
                    if(flag1==0 && s.charAt(i)=='O')
                    {
                        flag1=1;
                        cnt1++;
                    }
                    if(flag1==1 && s.charAt(i)=='X')
                    {
                        flag1=0;
                        cnt1++;
                    }
                    if(flag2==0 && s.charAt(i)=='X')
                    {
                        flag2=1;
                        cnt2++;
                    }
                    if(flag2==1 && s.charAt(i)=='O')
                    {
                        flag2=0;
                        cnt2++;
                    }
                    long k=Math.min(cnt1,cnt2);
                    ans+=k;
                    ans%=1000000007;
                }                
            }

            System.out.println("Case #"+inc+": "+ans);        
            inc+=1;
        }
        scn.close();
    }
}
