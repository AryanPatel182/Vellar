import java.util.*;

public class VasyaandCoins {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        long a = scn.nextLong();
        long b = scn.nextLong();

        if(a == 0)
        {
            System.out.println(1);
        }
        else if(b == 0)
        {
            System.out.println(a+1);
        }
        else
        {
            System.out.println(a + (2*b) + 1);
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
