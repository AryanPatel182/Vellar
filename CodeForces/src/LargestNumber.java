import java.util.*;
public class LargestNumber {
	static Scanner scn = new Scanner(System.in);
    
    public static boolean check(String s,String s1)
    {
        int n1 = s.length();
        int n2 = s1.length();

        int i=0,j=0;

        while(i<n1 && j<n2)
        {
            if(s.charAt(j)>s1.charAt(j))
            {
                return true;
            }
            else if(s.charAt(j) < s1.charAt(j))
            {
                return false;
            }
            else
            {
                i+=1;
                j+=1;
            }
        }
        if(i<n1)
        {
            if(s.charAt(i)>s.charAt(i-1))
            {
                return true;
            }            
            return false;
        }
        if(j<n2)
        {
            if(s1.charAt(j)>s1.charAt(j-1))
            {
                return false;
            }
            return true;
        }

        return true;
    }
	public static void main(String[] args) {
        
        int n = scn.nextInt();
        int[] A = new int[n];    
        for(int i=0; i<n; i++)    
        {
            A[i] = scn.nextInt();
        }
        String s = Integer.toString(A[0]);
        int i = 1;
        while (i < n) {
            String s1 = Integer.toString(A[i]);         
            if (check(s,s1)) {
                s = (s + s1 );
            } else {
                s = (s1 + s);
            }
            // System.out.println(s);
            i++;
        }
        
        int k = 0;

        while(k<n && s.charAt(k) == '0') {
            k++;
        }

        String ans ="";
        if (k == s.length())
        {
            ans += "0";
            System.out.println(ans);
        }
        else
        {
            System.out.println(s);
        }
        
		
	}
}