import java.util.*;
import java.io.*;

public class MaximumNonoverlappingBridges {
    public static class Bridge implements Comparable<Bridge>{
        int nv ;
        int sv;

        Bridge(int nv , int sv)
        {
            this.nv = nv;
            this.sv = sv;
            
        }
        
        public int compareTo(Bridge o){
            
            if(this.nv != o.nv)
            {
                return this.nv - o.nv;
            }
            else
            {
                return this.sv - o.sv;
            }
        }
        
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        
        int n = scn.nextInt();
        
        Bridge[] bridge = new Bridge[n];
        for(int i = 0 ; i < n ; i++)
        {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            bridge[i] = new Bridge(v1,v2);
        }
        scn.close();
        Arrays.sort(bridge);

        int[] dp = new int[n];
        int ans = 0;
        
        for(int i = 0; i < n ; i++)
        {
            int max = 0;            
            for(int j = 0 ; j<i ; j++)
            {
                if(bridge[j].sv <= bridge[i].sv)
                {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + 1;                       
            ans = Math.max(ans, dp[i]);
        }
        
        System.out.println(ans);

    }
}
