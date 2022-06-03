import java.util.*;

public class DeletionsOfTwoAdjacentLetters {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        String s = scn.next();
        char c = scn.next().charAt(0);
        
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == c)
            {
                if(i%2 == 0)
                {
                    System.out.println("YES");
                    return;
                }                
            }
        }
        System.out.println("NO");

        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
