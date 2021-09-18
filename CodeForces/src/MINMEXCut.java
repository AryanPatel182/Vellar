import java.util.*;

public class MINMEXCut {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        String s = scn.next();
        int n = s.length();
        int count = 0;
        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i) == '0' && s.charAt(i+1) == '1')
            {
                count+=1;
            }            
        }
        if(s.charAt(n-1) == '0')
        {
            count+=1;
        }

        if(count<2)
        {
            System.out.println(count);
        }
        else
        {
            System.out.println(2);
        }
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
