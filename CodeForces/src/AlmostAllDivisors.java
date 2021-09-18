import java.util.*;

public class AlmostAllDivisors {
    public static boolean containsAllDiv(ArrayList<Long> divs, long ans) {
        long cdiv = 2;
        ArrayList<Long> ori = new ArrayList<Long>();
        while (cdiv * cdiv <= ans) {
            if (ans % cdiv == 0) {
                ori.add(cdiv);
                if (ans / cdiv != cdiv)
                    ori.add(ans / cdiv);
            }
            cdiv++;
        }
        

        Collections.sort(ori);
        if (ori.size() != divs.size())
            return false;
     
        return divs.equals(ori);
    }
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        ArrayList<Long> div = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            div.add(scn.nextLong());
        }
        Collections.sort(div);

        long x = div.get(0) * div.get(n - 1);

        for (int i = 0; i < n; i++) {
            if (x % div.get(i) > 0) {
                System.out.println(-1);
                return;
            }
        }
        // if(bad)System.out.println("asd");
        if (!containsAllDiv(div, x))
            System.out.println(-1);
        else
            System.out.println(x);

        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
