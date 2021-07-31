import java.util.*;

public class CoinRows {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args)
    {
        int t = scn.nextInt();
        
        while(t-- >0 )
        {
            int m = scn.nextInt();

            int[][] arr = new int[2][m];

            for(int i=0; i<2; i++)
            {
                for(int j=0; j<m; j++)
                {
                    arr[i][j] = scn.nextInt();
                }
            }

            int sum = 0;
            int[] psum = new int[m];
            for(int i=0; i<m ;i++)
            {   
                sum += arr[1][i];
                psum[i] = sum;
            }

            sum = 0;
            int[] ssum = new int[m];
            for(int i=m-1; i>=0; i--)
            {
                sum+= arr[0][i];
                ssum[i] = sum;
            }

            int ans = Integer.MAX_VALUE;

            for(int i=0; i<m; i++)
            {
                int pref = (i==0? 0:psum[i-1]);
                int suff = (i==m-1)?0 :ssum[i+1];
                ans = Math.min(ans, Math.max(pref,suff));
                // System.out.println(ans);
            }
            
            System.out.println(ans);
            
            
        }
    }
}