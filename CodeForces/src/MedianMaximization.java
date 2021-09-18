import java.util.*;

public class MedianMaximization {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        long n = scn.nextLong();
        long s = scn.nextLong();

        if(n==1)
        {
            System.out.println(s);
            return;
        }
        else if(n==2)
        {            
            System.out.println(s/2);
            return;
        }

        long mid =  (long)Math.ceil((double)n/(double)2);        
        long j = n-mid+1;
        System.out.println(s/j);
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
