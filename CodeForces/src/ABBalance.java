import java.util.*;

public class ABBalance {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        String s = scn.next();
        int n = s.length();
        int count = 0;
        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i) != s.charAt(i+1))
            {
                count+=1;
            }
        }
        if(count % 2 == 1)
        {            
            System.out.println(s.substring(0,n-1) + (s.charAt(n-1)=='a'?"b":"a"));
        }
        else
        {
            System.out.println(s);
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
