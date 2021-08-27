import java.util.*;

public class TheMiracleandtheSleeper {
    static Scanner scn = new Scanner(System.in);


    public static void solve() {
        long l = scn.nextInt();
        long r = scn.nextInt();
        if(l==r)
        {
            System.out.println(0);
            return;
        }
        long temp = 0;
        if(r%2 == 0) temp = r/2;
        else temp =  (r+1)/2;
        
        if(temp>=l)
        {
            System.out.println(temp-1);
            return;
        }

        else
        {
            System.out.println(r%l);
        }
        

    }
    public static void main(String[] args) {
        int t=  scn.nextInt();

        while(t -- >0)
        {
            solve();
        }
    }
}