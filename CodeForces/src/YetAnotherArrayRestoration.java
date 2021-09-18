import java.util.*;

public class YetAnotherArrayRestoration {
	static Scanner scn = new Scanner(System.in);    
	
	public static void solve() 
	{
        int n = scn.nextInt();
        int x = scn.nextInt();
        int y = scn.nextInt();

        int dif = (y-x);
        for(int cd = 1; cd <= dif; cd+=1)        
        {
            int num = y;
            ArrayList<Integer> ans = new ArrayList<>();            
            boolean visx = false;
            while(num > 0 && ans.size() < n)
            {
                if(num == x) visx = true;
                ans.add(num);
                num -= cd;                
            }

            if(!visx) continue;

            if(ans.size()<n)
            {
                num = y + cd;
                while(ans.size()<n)
                {
                    ans.add(num);
                    num += cd;
                }
            }

            Collections.sort(ans);
            for(int i=0; i<n; i++)
            {
                System.out.print(ans.get(i)+ " ");                
            }
            System.out.println();
            break;
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


