import java.util.*;

public class GetanEvenString {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        String s = scn.next();
        int n = s.length();

        int[] ans = new int[n+1];        
        int[] last = new int[26];

        for(int i=1; i<=n; i++)
        {
            char ch = s.charAt(i-1);
            if(last[ch-'a'] != 0)    
            {   
                ans[i] = 2 +  ans[last[ch-'a'] - 1];
            }
            
            ans[i] = Math.max(ans[i], ans[i-1]);

            last[ch-'a'] = i;
        }

        System.out.println(n-ans[n]);
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
 