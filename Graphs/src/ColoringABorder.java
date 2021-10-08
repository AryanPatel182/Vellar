import java.util.*;
import java.io.*;

public class ColoringABorder {
    public static int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        bfs(grid, row,col ,grid[row][col]);

        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j] < 0)
                {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    public static void bfs(int[][] grid, int row, int col, int color)
    {
        grid[row][col] = -color;
        int count = 0;

        for(int i=0; i<direction.length; i++)
        {
            int xdash = row + direction[i][0];
            int ydash = col + direction[i][1];

            if(xdash<0 || ydash < 0 || xdash >= grid.length || ydash >= grid[0].length || Math.abs(grid[xdash][ydash]) != color )
            {
                continue;
            }
            count+=1;
            if(grid[xdash][ydash] == color)
            {
                bfs(grid, xdash, ydash, color);
            }
        }

        if(count == 4)
        {
            grid[row][col] = color;
        }

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

        int row = scn.nextInt();
        int col = scn.nextInt();
        int color = scn.nextInt();
        
        int[][] ans = colorBorder(arr, row, col, color);

        for(int i=0; i<ans.length; i++)
        {
            for(int j=0; j<ans[i].length; j++)
            {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        // boolean[] visited = new boolean[vts];

        scn.close();

    }
}
