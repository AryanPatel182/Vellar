import java.util.*;



public class SimplyStrangeSort {
    static Scanner scn = new Scanner(System.in);
    public static boolean check(int[] arr) 
    {
        for(int i=0; i<arr.length-1; i++)
        {
            if(arr[i]>arr[i+1])
            {
                return false;
            }
        }

        return true;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr= new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int ans = 0;
        int i=1;
        while(true)
        {
            if (check(arr) == true) 
            {
                break;
            }
            if(i == 1)
            {
                for(int j=0; j<=n-3; j+=2)
                {
                    if(arr[j] > arr[j+1])
                    {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }    
                i=2;            
                ans+=1;
            }
            else if(i == 2)
            {
                for (int j = 1; j <= n - 2; j += 2) 
                {                    
                    if (arr[j] > arr[j + 1])
                    {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                i=1;
                ans+=1;
            }
            

        }

        System.out.println(ans);
        
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while(t-- > 0)
        {
            solve();
        }
    }
}