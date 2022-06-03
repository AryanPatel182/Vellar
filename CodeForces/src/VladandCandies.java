import java.util.*;

public class VladandCandies {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
            if(arr[i] > max)
            {
                smax = max;
                max = arr[i];
            }
            else if(arr[i] > smax)
            {
                smax = arr[i];
            }
        }
        
        if(n==1 && arr[0] > 1) 
        {
            System.out.println("NO");
            return;
        }
        // System.out.println(max + " -- " + smax);
        if(Math.abs(max - smax) > 1 && max != Integer.MIN_VALUE && smax != Integer.MIN_VALUE)
        {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
