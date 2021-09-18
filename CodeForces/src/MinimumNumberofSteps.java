import java.util.*;

public class MinimumNumberofSteps {
    static Scanner scn = new Scanner(System.in);

    public static void solve() 
    {
        String s = scn.next();

        int n = s.length();
        long nb = 0;
        long steps = 0;

        for(int i=n-1; i>=0; i--)
        {
            if(s.charAt(i)=='a')
            {   
                if(nb == 0)
                {

                }
                else
                {
                    steps= (steps +nb) %1000000007;
                    nb= (nb*2)%1000000007;
                }
            }
            else
            {
                nb = (nb+1)%1000000007;
            }
        }

        System.out.println(steps % 1000000007);

        return;
    }

    public static void main(String[] args) {        
        solve();
    }
}
