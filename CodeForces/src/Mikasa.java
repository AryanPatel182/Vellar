import java.util.*;

public class Mikasa {
    
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-- > 0)
        {
            long n = scn.nextInt();
            long m = scn.nextInt();
            // m = m+1;1

            long k = 0;
            for(long i=31;i>=0; i--)
            {
                long bitmask  = (1<<i);
                long bitofn = n&bitmask;
                long bitofm = (m+1)&bitmask;                
                          
                if(bitofn == 0 && bitofm == 0)
                {
                    
                }
                else if(bitofn != 0 && bitofm == 0)
                {                    
                    break;
                }
                else if(bitofn == 0 && bitofm != 0)
                {
                    k = k ^ bitmask;
                }
                else if(bitofn != 0 && bitofm != 0)
                {
                    
                }                
            }
            System.out.println(k);
        }
        
        scn.close();
    }
}
