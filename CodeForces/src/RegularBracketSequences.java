import java.util.*;

public class RegularBracketSequences {
    static Scanner scn = new Scanner(System.in);

    public static String brack(int n)
    {
        String ans = "";
        String temp = "()";

        for(int i=0; i<n; i++)
        {
            ans+=temp;
        }
        return ans;
    }
    public static void solve() {
        int n = scn.nextInt();

        String left = "";
        String right = "";
        for(int i=0; i<n; i++)
        {
            System.out.println(left + brack(n-i) + right);
            left += "(";
            right += ")";
            
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
