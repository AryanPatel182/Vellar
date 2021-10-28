import java.util.*;

public class GuestFromthePast {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        long n = scn.nextLong();
        long a = scn.nextLong();
        long b = scn.nextLong();
        long c = scn.nextLong();
        
        if((n<a && n<b))
        {
            System.out.println(0);
            return;
        }
        long ans = 0;
        
        if((b-c) < a && n>=b )
        {
            ans = (n-b)/(b-c);
            ans = ans + 1;
            n = n - (b-c)*ans;
            // System.out.println(ans);
            ans = ans + (n/a);
        }
        else if(n>=a)
        {
            ans = ans + (n/a);
        }

        System.out.println(ans);
        return;
    }

    public static void main(String[] args) {        
        solve();
    }
}
