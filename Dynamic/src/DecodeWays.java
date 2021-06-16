import java.util.*;
import java.io.*;

public class DecodeWays {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String str = scn.next();
        int n = str.length();
        int[] dp = new int[n];

        dp[0] = 1;
        for(int i=1; i<n ; i++)
        {
            
            if(str.charAt(i) == '0' && str.charAt(i-1)== '0')
            {
                dp[i] = 0;
            }
            else if(str.charAt(i) != '0' && str.charAt(i-1)== '0')
            {
                int ls = Integer.parseInt(str.substring(i-1,i+1));
                if(ls<=26)
                {
                    dp[i] = (i>=2 ? dp[i-2] : 1);
                }
            }        
            else if(str.charAt(i) == '0' && str.charAt(i-1) != '0'){
                dp[i] = dp[i-1];
            }
            else{
                int ls = Integer.parseInt(str.substring(i - 1, i + 1));
                if(ls<=26)
                {
                    dp[i] = dp[i-1] + (i>=2 ? dp[i-2] : 1);
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
        }

        System.out.println(dp[n-1]);
        scn.close();

    }
}
