import java.util.*;

public class NewPassword {
	static Scanner scn = new Scanner(System.in);    
	
	public static void solve(int t) 
	{
        int n = scn.nextInt();
        String s = scn.next();

        boolean small = false;
        boolean big = false;
        boolean digit = false;
        boolean sc = false;

        for(int i=0; i<n; i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                small = true;
            }
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z')
            {
                big = true;
            }
            else if(s.charAt(i)>='0' && s.charAt(i)<='9')
            {
                digit = true;
            }
            else if(s.charAt(i) == '#' || s.charAt(i) == '@' || s.charAt(i) == '*' || s.charAt(i) == '&')
            {
                sc = true;
            }
        }

        if(small == false)
        {
            s+="a";
        }
        if(big == false)
        {
            s+="A";
        }
        if(digit == false)
        {
            s+="1";
        }
        if(sc==false)
        {
            s+="@";
        }
        
        if(s.length() < 7)
        {
            int times = 7-s.length();
            for(int i=0; i<times; i++)
            {
                s+="1";
            }
        }

        System.out.println("Case #"+(t+1) + ": "+ s);
        return;		
	}
	public static void main(String[] args) 
	{
		int t =  scn.nextInt();
        int i=0;
		while(i<t)
		{
			solve(i);
            i++;
		}
	}
}














