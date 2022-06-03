import java.util.*;

public class EverythingEverywhereAllButOne {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();            
            sum += arr[i];
        }

        for(int i=0; i<n; i++)
        {
            sum = sum - arr[i];
            if(arr[i]*(n-1) == sum)
            {
                System.out.println("YES");
                return;
            }
            sum = sum + arr[i];
        }
        System.out.println("NO");
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
