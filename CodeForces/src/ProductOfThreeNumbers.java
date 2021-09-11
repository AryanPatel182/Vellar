import java.util.*;

public class ProductOfThreeNumbers {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();

        int a=0,b=0,c=0;
        for(a=2; a*a*a <= n; a++)
        {
            if(n%a == 0)
            {                                
                break;
            }
        }
        int rem = n/a;
        for(b=a+1; b*b<=rem; b++)
        {
            if(rem%b == 0)
            {                
                c = rem/b;
                if(c<=b)
                {
                    c =0;
                }
                break;
            }
        }

        if(a*b*c == n)
        {
            System.out.println("YES");
            System.out.println(a+" "+b+" "+c);
        }
        else
        {
            System.out.println("NO");
        }
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
