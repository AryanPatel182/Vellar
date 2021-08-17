import java.util.*;
public class PleasantPairs {
    public static void solve()
    {
        int n = scn.nextInt();
        long[] arr= new long[n+1];

        int count = 0;
        for(int i=1; i<=n; i++)
        {
            arr[i] = scn.nextInt();
        }        
        for(int i=1; i<=n; i++)
        {
            for(int j=(int)(arr[i]-i); j<=n; j+=arr[i])
            {
                if((j>0) && ((arr[i]*arr[j]==i+j)) && (i<j))   
                {                              
                    count+=1;
                }
            }
        }

        System.out.println(count);
        return;

    }
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int t= scn.nextInt();
        while(t --> 0)
        {
            solve();
        }
    }
}