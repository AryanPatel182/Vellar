import java.util.*;

public class Countdown {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        String s = scn.next();

        int ans = 0;
        for(int i=0; i<n-1; i++)
        {
             ans += s.charAt(i)-'0';
            if(s.charAt(i)-'0' > 0)
            {
                ans += 1;
            }
        }
        ans+= s.charAt(n-1)-'0';

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
