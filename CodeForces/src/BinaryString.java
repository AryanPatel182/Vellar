import java.util.*;

public class BinaryString {
	static Scanner scn = new Scanner(System.in);    
	
	public static void solve() 
	{

        String s = scn.next();
        int n = s.length();

        int ans = Integer.MAX_VALUE;
        int nzeros = 0;
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == '0')
            {
                nzeros += 1;
            }
        }
        if(nzeros == n) 
        {
            System.out.println(0);
            return;
        }
        int nones = 0;
        int i=0, j=n-1;

        ans = Math.min(ans, Math.max(nzeros, nones));
        while(i<j && nzeros > nones)
        {
            if(s.charAt(i) == '0')
            {
                // System.out.println("Found zero at i");
                nzeros-=1;
                i+=1;
            }
            else if(s.charAt(j) == '0')
            {
                // System.out.println("Found zero at j");

                nzeros -= 1;
                j-=1;
            }
            else
            {
                // System.out.println("Found One at both");

                int lszo = lbs(s, i, j);
                int rszo = rbs(s, i, j);
                // System.out.println("lszo = " + lszo);
                // System.out.println("rszo = " + rszo);                
                
                if(lszo == -1 && rszo == -1)
                {
                    break;
                }
                else if(lszo == -1)
                {
                    nones += 1;
                    j-=1;
                }
                else if(rszo == -1)
                {
                    nones += 1;
                    i+=1;
                }
                else
                {
                    if(lszo - i > j - rszo)
                    {
                        nones+=1;
                        j-=1;
                    }
                    else
                    {
                        nones+=1;
                        i+=1;
                    }
                }
                
            }
            ans = Math.min(ans, Math.max(nzeros, nones));
        }
        System.out.println(ans);
		return;
	}
	private static int lbs(String s, int i, int j) {
        int lo = i;
        int hi = j;
        
        int ans = -1;
        
        while(lo<=hi)
        {
            int mid = (lo + hi) / 2;
            if(s.charAt(mid) == '0')
            {
                ans = mid;
                hi = mid-1;
            }
            else
            {
                hi = mid-1;
            }
        }

        return ans;
    }

    private static int rbs(String s, int i, int j) {
        int lo = i;
        int hi = j;
        
        int ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (s.charAt(mid) == '0') {
                ans = mid;
                lo = mid + 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
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














