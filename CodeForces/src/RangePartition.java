import java.util.*;

public class RangePartition {
    static Scanner scn = new Scanner(System.in);

    public static void solve(int i) {
        int n = scn.nextInt();
        int X = scn.nextInt();
        int Y = scn.nextInt();
        String ans = "IMPOSSIBLE";
        long up =  n*(n+1)*X;
        long dp = 2*(X+Y);

        if(up>=dp && up%dp == 0)
        {
            ans = "POSSIBLE";
        }

        System.out.println("Case #"+ (i+1)+ ": " + ans);
        if(ans == "POSSIBLE")
        {
            long x = up/dp;
            Alan(x, n);            
            System.out.println();
        }        
        return;
    }

    public static void Alan(long x, int n){
        ArrayList<Integer> arr = new ArrayList<>();            
        int hi = n;        
        while(hi>=1)
        {
            if(x>hi)
            {
                x = x - hi;                
                arr.add(hi);
            }
            else if(x == hi)
            {
                x = x - hi;
                arr.add(hi);
                break;
            }
            hi-=1;
        }

        System.out.println(arr.size());
        Collections.sort(arr);
        for(int j=0; j<arr.size(); j++)
        {
            System.out.print(arr.get(j) + " ");
        }
        return;    
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        int i=0;
        while (i<t) {
            solve(i);
            i++;            
        }
    }
}
