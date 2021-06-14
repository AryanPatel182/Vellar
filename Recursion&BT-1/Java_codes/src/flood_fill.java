import java.util.*;
import java.io.*;

public class flood_fill {

    public static void flood(int r, int c, int[][] arr, String util, boolean[][] visited) 
    {
        if(r<0 || r>arr.length-1 || c<0 || c>arr[0].length-1 || arr[r][c]==1 || visited[r][c]==true)
        {
            return;
        }
        else if(r==arr.length-1 && c==arr[0].length-1)
        {
            System.out.println(util);
            return;
        }

        visited[r][c] = true;
        flood(r-1, c, arr, util+'t', visited);
        flood(r, c+1, arr, util+'r', visited);
        flood(r+1, c, arr, util+'d', visited);
        flood(r, c-1, arr, util+'l', visited);
        visited[r][c] = false;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++)    
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();

        flood(0,0,arr,"" , visited);


        

    }
}
