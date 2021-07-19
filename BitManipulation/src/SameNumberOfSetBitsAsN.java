import java.util.*;
import java.io.*;

public class SameNumberOfSetBitsAsN {
    public static long ncr(long n, int sb)
    {
        if(n<sb)
        {
            return 0;
        }
        else if(n==sb || sb==0)
        {
            return 1;
        }
        long res = 1;
        for(int i = 0 ;  i<sb ; i++)
        {
            res = res * (n-i);
            res = res/(i+1);
        }
        return res;
    }
    public static long solution(long n, int sb, int i) 
    {
        if(i==0)
        {
            return 0;
        }

        long mask = 1L<<i;
        long res = 0;
        if((n&mask)==0)
        {
            res = solution(n, sb, i-1);        
        }
        else
        {
            long ans1 = solution(n, sb-1, i-1);
            long ans0 = ncr(i,sb);
            res = ans1+ans0;            
        }

        return res;

    }
    public static int FindSetBits(long n) {
        int count = 0;
        while(n>0)
        {
            long rsb = (n&-n);
            n-= rsb;
            count++;
        }
        return count;        
    }
    
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        long n = scn.nextInt();

        int sb = FindSetBits(n);        

        System.out.println(solution(n,sb,63));
        scn.close();

    }
}
