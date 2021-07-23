import java.util.*;
import java.io.*;

public class CountSetBitsinFirstNnaturalnumbers {

    public static int find2spower(int n)
    {
        int x= 0;

        while((1<<x)<=n)
        {
            x++;
        }

        return x-1;
    }

    public static int setbits(int n) {
        if(n==0) return 0;
        int x=  find2spower(n);

        int till2px = x*(1<<(x-1));
        int mid = (n-(1<<x)+1);
        int last = setbits(n-(1<<x));

        return till2px+mid+last;        
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        scn.close();

        System.out.println(setbits(n));

    }
}
