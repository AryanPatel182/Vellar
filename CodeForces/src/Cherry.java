import java.util.*;
public class Cherry {
	static Scanner scn = new Scanner(System.in);    
	
	public static void main(String[] args) 
	{
		int t = scn.nextInt();

        while(t-->0)
        {
            int n = scn.nextInt();
            long[] arr = new long[n];

            for(int i=0; i<n; i++)
            {
                arr[i] = scn.nextInt();
            }

            long ans = Long.MIN_VALUE;
            
            for(int i=0;i<n-1;i++)
            {
                ans = Math.max(ans,arr[i]*arr[i+1]);
            }                        
            System.out.println(ans);
        }
        
	}
}