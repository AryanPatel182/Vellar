import java.util.*;
import java.io.*;

public class EggDropping {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int e = scn.nextInt();
        int f = scn.nextInt();

        int[][] dp = new int[e+1][f+1];


        for(int i = 1 ; i<=e ;i++)
        {
            for(int j=1 ; j<=f ; j++)
            {
                if(i==1)
                {
                    dp[i][j] = j;
                }   
                else if(j==1)                
                {
                    dp[i][j] = 1;
                }
                else
                {
                    int min = Integer.MAX_VALUE;
                    int p1 = 0;
                    int p2 = j-1;

                    while(p2>=0)
                    {
                        int v1 = dp[i][p2];
                        int v2 = dp[i-1][p1];

                        int val = Math.max(v1, v2);

                        min = Math.min(min, val);
                        p1+=1;
                        p2-=1;
                    }

                    dp[i][j] = min + 1;                       
                }
            }
        }

        scn.close();
        System.out.println(dp[e][f]);



    }
}
