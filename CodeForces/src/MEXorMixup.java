import java.util.*;

public class MEXorMixup {
	static Scanner scn = new Scanner(System.in);    
	
	public static void solve() 
	{
        int a = scn.nextInt();
        int b = scn.nextInt();

        int sum = 0;
        if ((a-1) % 4 == 0)
        {
            sum = (a - 1);
        }
        else if ((a - 1) % 4 == 1)
        {
            sum = 1;
        }        
        else if ((a-1) % 4 == 2)
        {
            sum = (a - 1) + 1;
        }
        else
        {
            sum = 0;
        }

        if(sum == b)
        {
            System.out.println(a);
        }
        else
        {
            if((sum^b) == a)
            {
                System.out.println(a+2);
            }
            else
            {
                System.out.println(a+1);
            }
        }
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


