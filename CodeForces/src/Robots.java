import java.util.*;

public class Robots {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int r = scn.nextInt();
        int c = scn.nextInt();
        String[] arr = new String[r];

        for(int i=0; i<r; i++)
        {
            arr[i] = scn.next();
        }

        int topr = Integer.MAX_VALUE;
        int topc = Integer.MAX_VALUE;
        int leftr = Integer.MAX_VALUE;
        int leftc = Integer.MAX_VALUE;

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(arr[i].charAt(j) == 'R')
                {                    
                    if(i < topr)
                    {
                        topr = i;
                        topc = j;
                    }
                    if( j < leftc )
                    {
                        leftc = j;
                        leftr = i;
                    }                    
                }
            }
        }

        if(topr == leftr || topc == leftc )
        {
            System.out.println("YES");            
        }
        else
        {
            System.out.println("NO");
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
