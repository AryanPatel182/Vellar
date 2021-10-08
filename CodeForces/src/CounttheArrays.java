import java.util.*;
public class CounttheArrays {
    static Scanner scn = new Scanner(System.in);

    static int N = 200043;
    static int mod = 998244353;

    public static int add(int x, int y) {
        x += y;
        while (x >= mod)
            x -= mod;
        while (x < 0)
            x += mod;
        return x;
    }

    public static int mul(int x, int y)
    {
        return (int) ((x * 1l * y) % mod);
    }

    public static int binpow(int x, int y)
    {        
        int z = 1;        
        while (y>0) {            
            if ((y%2) == 1)
            {
                z = mul(z, x);
            }
            x = mul(x, x);
            y  = y>>1;            
        }
        return z;
    }

    public static int inv(int x)
    {
        return binpow(x, mod - 2);
    }

    public static int divide(int x, int y)
    {
        return mul(x, inv(y));
    }

    static int[] fact = new int[N];

    public static void precalc()
    {
        fact[0] = 1;
        for(int i = 1; i < N; i++)
            fact[i] = mul(fact[i - 1], i);
    }   

    public static int ncr(int n, int k)
    {
        return divide(fact[n], mul(fact[k], fact[n - k]));
    }

    public static void solve() {
        int n = scn.nextInt();
        int m = scn.nextInt();
        precalc();
        int ans = 0;
        if (n > 2)
            ans = mul(ncr(m, n - 1), mul(n - 2, binpow(2, n-3)));
                        
        System.out.println(ans);
        return;
    }

    public static void main(String[] args) {        
        solve();
    }
}
