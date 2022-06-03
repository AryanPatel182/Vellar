import java.util.*;

public class DoorsAndKey {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        String s = scn.next();
        boolean[] visited = new boolean[26];
        int n = s.length();
        for(int i=0; i<n; i++)
        {
            char ch = s.charAt(i);
            if(ch == 'r' || ch == 'g' || ch == 'b')
            {
                visited[ch-'a']  = true;
            }
            else
            {
                if(visited[ch-'A'] == false)
                {
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println("Yes");
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
