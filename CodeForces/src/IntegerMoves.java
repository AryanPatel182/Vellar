import java.util.*;

public class IntegerMoves {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int x = scn.nextInt();
        int y = scn.nextInt();

        
        if(x == 0 && y == 0)
        {
            System.out.println(0);
            return;
        }
        
        for(int i=0; i<100; i++)
        {
            if(x*x + y*y == i*i)
            {
                System.out.println(1);
                return;
            }
        }

        System.out.println(2);
        
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
