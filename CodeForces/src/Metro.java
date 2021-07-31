import java.util.*;

public class Metro {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        int s = scn.nextInt();
    

        int[][] arr = new int[2][n];

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }

        if (arr[0][0] == 0)
        {
            System.out.println("NO");
            return;
        }
        if(arr[0][s-1] == 1)
        {
            System.out.println("YES");
            return;
        }
        if(arr[1][s-1] == 0)
        {
            System.out.println("NO");
            return;
        }


        for(int c=s; c<n; c++)
        {
            if(arr[0][c] == 1 && arr[1][c] == 1)
            {
                System.out.println("YES");
                return;
            }        
        }

        System.out.println("NO");
        return;
    }
    public static void main(String[] args) {
        solve();
    }
}