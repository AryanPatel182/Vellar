import java.util.*;
import java.io.*;

public class NumberOfDistinctIslands {
    public static StringBuilder util = new StringBuilder();
    
    public static void dfs(int[][] arr, int i, int j)
    {        
        arr[i][j] = 0;
        if(i<arr.length-1 && arr[i+1][j] == 1)
        {
            util.append("d");
            dfs(arr, i+1,j);        
        }
        if(j<arr[0].length-1 && arr[i][j+1] == 1)
        {
            util.append("r");
            dfs(arr, i,j+1);        
        }
        if(j>0 && arr[i][j-1] == 1)
        {
            util.append("l");
            dfs(arr, i,j-1);        
        }
        if(i>0 && arr[i-1][j] == 1)
        {
            util.append("t");
            dfs(arr, i-1,j);        
        }
        
        util.append("z");
        
    }
    
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[r][c];
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }

        HashSet<StringBuilder> hset = new HashSet<>();

        for(int i=0; i<r ;i++)
        {
            for(int j=0; j<c; j++)
            {
                if(arr[i][j] == 1)
                {
                    util = new StringBuilder();
                    dfs(arr,i,j);
                    if(!hset.contains(util))
                    {
                        hset.add(util);
                    }
                }
            }
        }

        System.out.println(hset.size());
        scn.close();

    }
}
