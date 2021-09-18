import java.util.*;

public class CellsNotUnderAttack {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[] rows = new int[n];
        int[] cols = new int[n];

        long count1 = n;
        long count2 = n;
        for (int i = 0; i < m; i++) {
            int x = scn.nextInt()-1;
            int y = scn.nextInt()-1;

            if(rows[x] == 0)
            {
                count1-=1;
                rows[x] = 1;
            }
            if(cols[y] == 0)
            {
                count2-=1;
                cols[y] = 1;
            }
            

            System.out.print(count1 * count2 + " ");            
        }

        System.out.println();
        return;
    }

    public static void main(String[] args) {

        solve();

    }
}
