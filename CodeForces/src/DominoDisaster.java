import java.util.*;

public class DominoDisaster {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        String s = scn.next();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'L' || ch == 'R') {
                System.out.print(ch);
            } else if (ch == 'U') {
                System.out.print('D');
            } else {
                System.out.print('U');
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
