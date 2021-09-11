import java.util.*;

public class Taxes {
    public static boolean isPrime(int n) {
        for(int i=2; i*i<=n; i++)
        {
            if(n%i == 0)
            {
                return false;
            }
        }
        return true;
    }
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        if(n==2) System.out.println(1);            
        else if(n%2 == 0)
        {
            System.out.println(2);
        }
        else if(isPrime(n))
        {
            System.out.println(1);
        }
        else if(isPrime(n-2))
        {
            System.out.println(2);
        }
        else
        {
            System.out.println(3);
        }
        return;
    }

    public static void main(String[] args) {
        
        solve();
    
    }
}
