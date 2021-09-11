import java.util.*;

public class BuyingShovels {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        int k = scn.nextInt();

        if(k>=n)
        {
            System.out.println(1);
            return;
        }
        int ans = n;
        for(int a = 1; a*a <= n; a++)
        {
            if(n%a == 0)
            {
                int b = n/a;

                if(a<=k)
                {
                    ans = Math.min(ans,b);
                }
                if(b<=k)
                {
                    ans = Math.min(ans, a);
                }
            }
        }
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
