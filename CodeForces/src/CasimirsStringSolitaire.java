import java.util.*;

public class CasimirsStringSolitaire {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        String s = scn.next();
        int n = s.length();
        int count = 0 ;

        if(n%2 == 1)
        {
            System.out.println("NO");
            return;
        }
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == 'B')
            {
                count+=1;
            }
        }

        if(count*2 == n )
        {
            System.out.println("YES");
            return;
        }
        
        System.out.println("NO");
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
