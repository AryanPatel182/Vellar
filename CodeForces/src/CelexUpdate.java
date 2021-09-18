import java.util.*;

public class CelexUpdate {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        long x1 = scn.nextLong();
        long y1 = scn.nextLong();
        long x2 = scn.nextLong();
        long y2 = scn.nextLong();

        System.out.println((x2-x1)*(y2-y1) + 1);
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
