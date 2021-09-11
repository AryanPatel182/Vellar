import java.util.*;

public class kLCMeasyversion {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        // int k = scn.nextInt();
        
        if(n%2==1)
        {
            System.out.println(n/2 + " " + n/2 + " " + 1);
        }
        else
        {
            if(n%4 == 0)
            {
                System.out.println(n/4 + " "+ n/4 + " " + n/2);
            }
            else
            {
                System.out.println((n/2 -1) + " " + (n/2-1) + " " + 2);
            }
        }
        return;
    }
    public static void main(String[] args) {
        int t = scn.nextInt();
        while(t-- >0)
        {
            solve();
        }
    }
}
