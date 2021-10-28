import java.util.*;

public class DeleteTwoElements {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        long[] arr= new long[n];
        HashMap<Long, Long> hmap = new HashMap<>();
        long sum = 0;
        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextLong();
            hmap.put(arr[i], hmap.getOrDefault(arr[i], 0l)+1);
            sum+=arr[i];
        }

        
        if((2*sum) % n == 0)
        {
            Arrays.sort(arr);
            long sotwo = (2*sum)/n;
            long ans = 0;
            int i = 0; 
            int j = n-1;
            while(i<n)
            {
                j=n-1;
                while(i<j)
                {
                    if(arr[i] + arr[j] == sotwo)
                    {
                        ans += 1;
                        j-=1;                    
                    }
                    else if(arr[i] + arr[j] < sotwo)
                    {
                        break;
                    }
                    else
                    {
                        j-=1;
                    }
                }
                i+=1;
            }
            System.out.println(ans);                
        }
        else
        {
            System.out.println(0);
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
