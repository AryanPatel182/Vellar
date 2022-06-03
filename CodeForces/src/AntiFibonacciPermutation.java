import java.util.*;

public class AntiFibonacciPermutation {

    static Scanner scn = new Scanner(System.in);

    public static void swap(int[] ans, int i)
    {
        int temp = ans[i];
        ans[i] = ans[i+1];
        ans[i+1] = temp;
    }

    public static void print(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = n-i;
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        
        for(int i=0; i<n-1; i++)
        {
            int[] ans = new int[n];
            for(int j=0; j<n; j++)
            {
                ans[j] = arr[j];
            }
            swap(ans, i);
            print(ans);
        }
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
