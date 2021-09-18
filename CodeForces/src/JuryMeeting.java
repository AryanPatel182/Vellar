import java.util.*;

public class JuryMeeting {
   
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        long[] arr = new long[n];
    
        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextLong();
        }

        Arrays.sort(arr);
        
        if(arr[n-1] - arr[n-2] > 1)
        {
            System.out.println(0);
            return;
        }
        
        int count = 0;
        long smax = arr[n-2];
        for(int i=n-2;i>=0; i--)
        {
            if(arr[i] == smax)
            {
                count+=1;
            }
            else
            {
                break;
            }
        }
        long M =  998244353;
        long ans  = 1;
        long sub = 1;
        for (int i = 1; i <= n; i++) {
            ans = (ans * i) % M;
            if (i != count + 1)
                sub = (sub * i) % M;
        }
        
        if(arr[n-1] != arr[n-2]) ans = (ans - sub + M)%M;
            
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
