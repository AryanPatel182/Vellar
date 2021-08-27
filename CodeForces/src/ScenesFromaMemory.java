import java.util.*;

public class ScenesFromaMemory {
    static Scanner scn = new Scanner(System.in);
    

    public static void solve()
    {
        int k = scn.nextInt();        
        String s = scn.next();

        
        String ans = "";

        for(int i=0; i<k; i++)
        {
            int val = s.charAt(i)-'0';
            if(val == 1)
            {
                System.out.println(1);
                System.out.println(1);
                return;
            }
            if(i==0)
            {
                if(val!=2 && val % 2 == 0)
                {
                    ans+=val;
                    System.out.println(ans.length());
                    System.out.println(ans);
                    return;
                }
                else if(val == 1 || val == 9)                
                {
                    ans+=val;
                    System.out.println(ans.length());
                    System.out.println(ans);
                    return;
                }
                else
                {
                    ans+= val;
                }
            }
            else
            {                
                if(val%2 == 0)
                {
                    ans+= val;
                    System.out.println(ans.length());
                    System.out.println(ans);
                    return;
                }
                
            }
        }
        return;
    }
    public static void main(String[] args) {
        int t = scn.nextInt();
        while(t-- > 0)
        {
            solve();
        }
    }
}