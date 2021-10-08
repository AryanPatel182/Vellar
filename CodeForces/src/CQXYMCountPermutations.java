import java.util.*;

public class CQXYMCountPermutations {
    static long f[] = new long[100001];   
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();        
        System.out.println(f[n]);
        return;
    }

    public static void main(String[] args) {
        f[1] = 1;
        for(int i=2; i<=100000; i++)
        {
            f[i]=((i<<1)-1l)*f[i-1]%1000000007*(i<<1)%1000000007;

        }
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
