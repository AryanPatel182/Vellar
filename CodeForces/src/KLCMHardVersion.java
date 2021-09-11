import java.util.*;

public class KLCMHardVersion {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        for(int i=0; i<k-3; i++)        
        {
            System.out.print(1+" ");
        }
        n = n-k+3;
        if(n%2 == 1)
        {
            System.out.print((n-1)/2 + " " + (n-1)/2 + " " + 1);
        }
        else
        {
            if(n%4 == 0)
            {
                System.out.println(n/2 + " " + n/4 + " " + n/4);
            }
            else
            {
                System.out.println((n/2-1) + " " + (n / 2 - 1) + " "+ 2 );
            }
        }
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
