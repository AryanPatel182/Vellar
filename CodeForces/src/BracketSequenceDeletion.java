import java.util.*;

public class BracketSequenceDeletion {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        String s = scn.next();
            
        int curr = 0;
	    int op = 0;
        while(curr<n-1)
        {
            if(s.charAt(curr)== '(' && s.charAt(curr+1) == ')')
	    	{
	    		op+=1;
	    		curr += 2;
	    	}
	    	else if(s.charAt(curr) == '(' && s.charAt(curr+1) == '(')
	    	{
	    		op++;
	    		curr += 2;
	    	}
	    	else
	    	{
	    		Boolean flag = false;
	    		for(int j = curr+1; j < n;j++)
	    		{
	    			if(s.charAt(j) == ')')
	    			{
	    				flag =true;
	    				curr = j+1;
	    				op++;
	    				break;
	    			}
	    		}
	    		if(!flag)
	    			break;
	    	}            
        }
        System.out.println(op + " "+ (n-curr));
        return;
    }

    public static void main(String[] args) {
        int t = scn.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
