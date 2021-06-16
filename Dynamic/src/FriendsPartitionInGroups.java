import java.util.*;
import java.io.*;

public class FriendsPartitionInGroups {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int fr = scn.nextInt();
        int grp = scn.nextInt();
        long[][] dp = new long[grp+1][fr+1];

        for(int i=1;i<grp+1 ; i++)
        {
            for(int j = 1 ; j< fr+1; j++)
            {
                if(i>j)
                {
                    dp[i][j] = 0;
                }
                else if(i==j)
                {
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = i*dp[i][j-1] + dp[i-1][j-1];
                }                
            }

        }

        System.out.println(dp[grp][fr]);
        scn.close();

    }
}
