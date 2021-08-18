import java.util.*;

public class WhosOpposite {
    static Scanner scn = new Scanner(System.in);

    public static void solve()
    {
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        int dif = Math.abs(a-b);  
        int n = 2*dif;    
        if(n==2)  
        {
            System.out.println(-1);
            return;
        }
        if(c>n || Math.max(a,b)>n)
        {
            System.out.println(-1);
            return;
        }
        else
        {
            System.out.println((c-1+dif)%(n) + 1);
        }

    }
    public static void main(String[] args) {
        int t=  scn.nextInt();
        while(t-- > 0)
        {
            solve();
        }
    }
}