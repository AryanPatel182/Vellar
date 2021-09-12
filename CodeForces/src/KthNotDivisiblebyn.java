import java.util.*;

public class KthNotDivisiblebyn {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        long n  = scn.nextLong();
        long k = scn.nextLong();

        if(n>k)
        {
            System.out.println(k);
            return;
        }
        if(n == k)
        {
            System.out.println(n+1);
            return;
        }

        
        long ans = k + (k%(n-1) == 0 ? k/(n-1)-1 : k/(n-1));

        System.out.println(ans);
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
