import java.util.*;

public class ChessTournament {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        String s = scn.next();

        char[][] ans = new char[n][n];
        int count =0;
        for(int i=0; i<n; i++)
        {
            char ch1 = s.charAt(i);
            if(ch1 == '2')
            {
                count+=1;
            }
            ans[i][i] = 'X';        
            boolean flag = true;
            for(int j=i+1;j<n;j++)
            {
                char ch2 = s.charAt(j);
                if(ch1 == '1' || ch2 == '1')
                {
                    ans[i][j] = '=';
                    ans[j][i] = '=';
                }

                else if(ch2 == '2' && flag == true)
                {
                    ans[i][j] = '+';
                    ans[j][i] = '-';
                    flag = false;
                }
                else
                {
                    ans[i][j] = '-';
                    ans[j][i] = '+';
                }
            }
        }

        if(count == 1 || count == 2)
        {
            System.out.println("NO");
            return;
        }
        else
        {
            System.out.println("YES");
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(ans[i][j]);
            }
            System.out.println();
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
