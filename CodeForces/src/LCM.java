import java.util.*;

public class LCM {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        long b = scn.nextLong();
        if(b == 1l)
        {
            System.out.println(1);
            return;
        }

        long count = 0;
        for(long i=2; i*i <= b; i++)
        {
            if(b%i == 0)
            {
                if(i == b/i)
                {
                    count+=1;
                }
                else
                {
                    count+=2;
                }
            }
        }

        System.out.println(count+2);
        return;
    }

    public static void main(String[] args) {
        
        solve();
        
    }
}
