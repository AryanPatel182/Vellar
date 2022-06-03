import java.util.*;
public class OddSubarrays {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int ans = 0;
        for(int i=0; i<n-1; i++)
        {
            if(arr[i]>arr[i+1])
            {
                ans+=1;
                i+=1;
            }
        }
        System.out.println(ans);
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
