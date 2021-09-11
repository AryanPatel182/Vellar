import java.util.*;

public class BalancedSubstring {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();

        String s = scn.next();

        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i)!=s.charAt(i+1))
            {
                System.out.println((i+1) + " "+ (i+2));
                return;
            }
        }
        System.out.println(-1 + " " + (-1));
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
