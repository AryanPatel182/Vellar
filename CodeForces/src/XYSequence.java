
import java.util.*;

public class XYSequence {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        int B  = scn.nextInt();
        int x = scn.nextInt();
        int y = scn.nextInt();

        long sum = 0;
        long ans = 0;
        for(int i=0; i<n; i++)
        {
            if(sum + x <= B)
            {
                sum+=x;                
            }
            else
            {
                sum-=y;
            }
            ans+=sum;
        }
        System.out.println(ans);
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
