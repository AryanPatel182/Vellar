import java.util.*;

public class PlusandMultiply {
    public static  void solve()
    {
        long n = scn.nextInt();
        long a = scn.nextInt();
        long b = scn.nextInt();        
        if (a == 1) 
        {
            if ((n - 1) % b == 0) {
                System.out.println("Yes");                
            } else {
                System.out.println("No");
            }
            return;
        }
        else 
        {
            long num = 1;
            while (num <= n) 
            {
                if ((n - num) % b == 0)
                {
                    System.out.println("Yes");
                    return;
                }
                num *= a;
            }
        }

        System.out.println("No");
        return;
    }
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scn.nextInt();

        while(t-- > 0)
        {            
            solve();
        }
    }
}