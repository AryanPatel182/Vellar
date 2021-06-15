// ==================================== Memoization of fibonaci series.=====================================//


import java.util.*;
import java.io.*;

public class fibonaci {

    public static int fibo(int n, int[] qb) {        
        if(n==0 || n==1)
        {
            return n;
        }
        if(qb[n]!=0)
        {
            return qb[n];
        }
        
        int a1 = fibo(n-1 , qb);
        int a2 = fibo(n-2 , qb);

        qb[n] = a1 + a2;
        return a1+a2;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();        
        scn.close();

        int[] qb = new int[n + 1];    
        System.out.println(fibo(n , qb));

    }
}
