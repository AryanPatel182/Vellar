import java.util.*;

public class GoodSubarrays {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        long n = scn.nextLong();
        String s = scn.next();

        HashMap<Long,Long> hmap = new HashMap<>();
        hmap.put(0l, 1l);

        long psum = 0;
        for(int i=0; i<n; i++)
        {
            psum = psum + (s.charAt(i)-'0');
            // System.out.println(psum-i-1);
            hmap.put(psum-i-1, hmap.getOrDefault(psum-i-1, 0l)+1);
        }

        long ans = 0;
        for(long num : hmap.keySet())
        {
            long val = hmap.get(num);
            ans = ans + (val*(val-1))/2;
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
