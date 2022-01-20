import java.util.*;
// import java.lang.*;

public class DIEHARD {
    public static int[][] dp = new int[2000][2000];
    public static int finddpt(int h, int a, int i)
    {
        if(h<=0 || a<=0)
        {
            return 0;            
        }
        if(dp[h][a] != -1)
        {
            // System.out.println("Found " + h + " " + a);
            return dp[h][a];
        }

        int x1=0,x2=0,x3=0;
        if(i!=1) 
        {
            x1 = 1 + finddpt(h+3, a+2, 1);
        }
        if(i!=2)
        {
            x2 = 1 + finddpt(h-5, a-10, 2);
        }
        if(i!=3)
        {
            x3 = 1 + finddpt(h-20, a+5, 3);
        }
        
        // dp[h][a] = ;
        // System.out.println(h + " " + a);1
        
        return dp[h][a] = Math.max(x1, Math.max(x2, x3));        

    }
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        
        while(t-- > 0)
        {
            int h = scn.nextInt();
            int a = scn.nextInt();

            // int[][] dp = new int[1001][1001];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            
            int x1 = finddpt(h+3, a+2, 1);
            int x2 = finddpt(h-5, a-10, 2);
            int x3 = finddpt(h-20, a+5, 3);
            
            System.out.println(Math.max(x1, Math.max(x2, x3)));
        }
        scn.close();
        return;
    }
}