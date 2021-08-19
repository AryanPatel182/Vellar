import java.util.*;

public class MakeaPowerofTwo {
    static Scanner scn = new Scanner(System.in);

    public static int check_count(long n, long pot) 
    {
        String s1 = Long.toString(n);
        String s2 = Long.toString(pot);

        int n1 = s1.length();
        int n2 = s2.length();
        int i=0;
        int j=0;
        int count = 0;

        while(i<n1 && j<n2)
        {
            if(s1.charAt(i) == s2.charAt(j))
            {
                count+=1;
                i+=1;
                j+=1;                
            }
            else
            {                
                i+=1;
            }
        }

        return n1+n2-(2*count);
    }
    public static void main(String[] args) {
        int t= scn.nextInt();
        while(t-- >0)
        {
            Long n = scn.nextLong();

            int min = Integer.MAX_VALUE;

            for(int i=0; i<=60; i++)
            {
                long pot = ((long)1<<i);                
                int count = check_count(n, pot);                
                min = Math.min(min, count);
            }
            System.out.println(min);
        }
        
    }
}