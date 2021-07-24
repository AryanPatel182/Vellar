import java.util.*;
import java.io.*;

public class NumberOfEnclaves {
    public static void dfs(int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0) {
            return;
        }

        arr[i][j] = 0;
        dfs(arr, i - 1, j);
        dfs(arr, i + 1, j);
        dfs(arr, i, j + 1);
        dfs(arr, i, j - 1);
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int r=scn.nextInt();
        int c= scn.nextInt();
        
        int[][] arr= new int[r][c];

        for(int i=0; i<r; i++)
        {
            for(int j=0;j<c; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(i==0 || i==r-1 || j==0 || j==c-1)
                {
                    if(arr[i][j] == 1)
                    {
                        dfs(arr, i,j);
                    }
                }
            }
        }
        int count= 0;
        for(int i = 0 ; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(arr[i][j] == 1)
                {
                    count+=1;
                }
            }
        }
        
        
        System.out.println(count);
      
        scn.close();

    }
}
