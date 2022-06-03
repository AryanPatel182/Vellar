import java.util.*;

public class MadokaandMathDad {
	static Scanner scn = new Scanner(System.in);    
	
	public static void solve() 
	{
        int n = scn.nextInt();
        String ans = "";
        char last = 1;

        while(n>=2)
        {
            if(last == 1)
            {
                n = n-2;
                ans+=2;
                last = 2;
            }
            else
            {
                n = n-1;
                ans+=1;
                last = 1;
            }
        }
        if(n == 1 && last == 2)
        {
            ans = ans + 1;
        }
        else if(n == 1 && last == 1)
        {
            ans = 1 + ans;
        }

        System.out.println(ans);
		return;
	}
	public static void main(String[] args) 
	{
		int t =  scn.nextInt();
		while(t-- > 0)
		{
			solve();
		}
	}
}














