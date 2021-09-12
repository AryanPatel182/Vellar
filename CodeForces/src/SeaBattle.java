   import java.util.*;

public class SeaBattle {
	static Scanner scn = new Scanner(System.in);    
	
	public static void solve() 
	{
        int n = scn.nextInt();
        int a = scn.nextInt();
        int b = scn.nextInt();
        // int k = scn.nextInt();

        String s = scn.next();

        int l = 1;
        int r = 1;
        int count = 0;
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == '0')
            {
                r = i+1;
                if(r-l+1 == b) 
                {
                    count+=1;
                    r = l = i + 2;
                }
            }
            if(s.charAt(i) == '1')
            {
                r = l = i+2;
            }
        }

        int shoot = count-a+1;
        System.out.println(shoot);

        l = r = 1;
        for (int i = 0; i < n && shoot>0; i++) {
            if (s.charAt(i) == '0') {
                r = i + 1;
                if (r - l + 1 == b) {
                    System.out.print(r+" ");
                    shoot-=1;
                    r = l = i + 2;
                }
            }
            if (s.charAt(i) == '1') {
                r = l = i + 2;
            }
        }
		return;
	}
	public static void main(String[] args) 
	{
		
		solve();
		
	}
}

