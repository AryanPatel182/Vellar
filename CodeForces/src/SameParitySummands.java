import java.util.*;


public class SameParitySummands {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        long n = scn.nextLong();
        long k = scn.nextLong();

        if(k>n || (n % 2 == 1 && k % 2 == 0))
        {
            System.out.println("NO");
            return;
        }
        if(k == 1)
        {
            System.out.println("YES");
            System.out.println(n);
            return;
        }
        
        long x = -1;
        long y = -1;
        for(int i= 1; i<n; i++)
        {
            if((n-i)%(k-1) == 0 && (i%2 == ((n-i)/(k-1))%2))
            {
                x = i;
                y = (n-i)/(k-1);
                break;
            }
        }
        if(x == -1)
        {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        for(int i=0; i<k-1; i++)
        {
            System.out.print(y + " ");            
        }
        System.out.print(x);
        System.out.println();
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
