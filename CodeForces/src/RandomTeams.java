import java.util.*;

public class RandomTeams {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        long n = scn.nextLong();
        long m = scn.nextLong();

        long a = n/m;
        long b = n%m;
        long kmin = (b)*(a*(a+1))/2 + (m-b)*(a*(a-1))/2;

        long kmax = ((n-m+1)*(n-m))/2;


        System.out.println(kmin+ " " + kmax);


        return;
    }

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }
}
