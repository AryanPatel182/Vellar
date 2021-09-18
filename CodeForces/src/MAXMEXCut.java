import java.util.*;

public class MAXMEXCut {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        String su = scn.next();
        String sd = scn.next();

        int i = 0;
        int count = 0;
        while(i<n)
        {        
            if(su.charAt(i)!=sd.charAt(i))
            {
                count+=2;
                i+=1;
            }
            else
            {
                if((i!=n-1) && (su.charAt(i) == '1'))
                {
                    if(su.charAt(i+1) == '0' && sd.charAt(i+1) == '0')
                    {
                        count+=2;
                        i+=2;
                    }
                    else
                    {
                        i+=1;
                    }
                }
                else if((i != n - 1) && (su.charAt(i) == '0')) {
                    if (su.charAt(i + 1) == '1' && sd.charAt(i+1) == '1')
                    {
                        count += 2;
                        i += 2;
                    }
                    else
                    {
                        count+=1;
                        i+=1;
                    }
                }
                else
                {
                    if(su.charAt(i) == '0')
                    {
                        count+=1;
                    }
                    i+=1;
                }
                
            }            
        }
        System.out.println(count);
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
