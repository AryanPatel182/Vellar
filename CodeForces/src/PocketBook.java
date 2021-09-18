import java.util.*;

public class PocketBook {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int  n = scn.nextInt();
        int  m = scn.nextInt();
        
        String[] st = new String[n];
        for(int i=0; i<n; i++)
        {
            st[i] = scn.next();
        }
        long ans = 1;
        for(int i=0;i<m; i++)
        {            
            HashSet<Character> hset = new HashSet<>();
            for(int j=0; j<n; j++)
            {
                hset.add(st[j].charAt(i));
            }
            
            ans = (ans*hset.size())% 1000000007;
        }

        System.out.println(ans%1000000007);
        return;
    }

    public static void main(String[] args) {        
        solve();
    }
}
