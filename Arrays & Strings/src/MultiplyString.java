import java.util.*;
import java.io.*;

public class MultiplyString {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s1 = scn.next();
        String s2 = scn.next();
        
        scn.close();
        int l1 = s1.length();
        int l2 = s2.length();

        int[] res = new int[l1+l2];

        int i = l2-1;
        int pf = 0;

        while(i>=0)
        {   
            int carry = 0;            
            int ival = s2.charAt(i) -'0';
            int k =  l1 + l2 - 1 - pf;
            int j = s1.length()-1;
            while(j>=0)
            {                
                int jval = s1.charAt(j) - '0';
                int prod = (ival * jval) + carry + res[k];

                res[k] = prod % 10;                
                carry = prod / 10;

                j--;
                k--;

            }
            if(carry != 0)
            {
                res[k] = carry;
            }
            i--;            
            pf++;
        }

        String ans = "";
        boolean flag = false;
        for(int val:res)
        {
            if(val == 0 && flag == false)
            {
                continue;
            }
            else{
                flag = true;
                ans +=  val;
            }
        }


        System.out.println(ans);


    }
}
