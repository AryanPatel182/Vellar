import java.util.*;



public class MinimumsandMaximums {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int l1 = scn.nextInt();
        int r1 = scn.nextInt();
        int l2 = scn.nextInt();
        int r2 = scn.nextInt();
        
        if(r1 < l2)
        {
            System.out.println(l1 + l2);
            return;
        }
        else if(r1 >= l2)
        {
            if(l2 >= l1)
            {
                System.out.println(l2);
                return;
            }
            else
            {
                if(l1 <= r2)
                {
                    System.out.println(l1);
                    return;
                }
                System.out.println(l1+l2);
                return;
            }
        }


    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
