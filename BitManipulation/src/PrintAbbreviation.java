import java.util.*;
import java.io.*;

public class PrintAbbreviation {
    public static void PrintAbbr(String s, int n) 
    {
        for(int i=0; i<(1<<n); i++)
        {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j<n; j++)
            {
                int b = n-1-j;                
                if((i & (1<<b)) == 0)
                {
                    if(count==0)
                    {
                        sb.append(s.charAt(j));
                    }
                    else
                    {
                        sb.append(count);
                        sb.append(s.charAt(j));
                        count=0;
                    }
                }
                else
                {
                    count++;
                }
            }
            if(count>0)
            {
                sb.append(count);
            }
            System.out.println(sb);
        }
            
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s = scn.next();

        int n = s.length();

        PrintAbbr(s,n);
        scn.close();

    }
}
