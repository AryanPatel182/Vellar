import java.util.*;
import java.io.*;

public class ShortestBridge {
    public static class Pair {
        int row;
        int col;

        Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }        
    }
    
    public static int[][] index = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void bfs(int[][] arr , int i, int j, boolean[][] visited, LinkedList<Pair> queue) 
    {
        visited[i][j] = true;
        for(int k=0;k<4;k++)
        {
            int rdesh = i + index[k][0];
            int cdesh = j + index[k][1];

            if(rdesh>=0 && cdesh>=0 && rdesh<arr.length && cdesh<arr[0].length && arr[rdesh][cdesh] == 1 && visited[rdesh][cdesh] == false)
            {
                queue.addLast(new Pair(rdesh,cdesh));
                // System.out.println(rdesh + " " + cdesh);
                bfs(arr,rdesh,cdesh,visited,queue);
            }
        }
    }

    public static int findbridge(int[][] arr, int r, int c) 
    {
        int level=-1;

        LinkedList<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        boolean flag = true;

        for(int i=0 ;i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(arr[i][j] == 1 && flag == true)
                {
                    queue.add(new Pair(i,j));
                    visited[i][j] = true;
                    bfs(arr,i,j,visited,queue);                                  
                    flag = false;                    
                }
            }
        }
        
        // System.out.println();
        while(queue.size()>0)
        {
            int size = queue.size();
            level+=1;
            while(size-->0)
            {
                Pair rm = queue.removeFirst();
                for(int i=0; i<4; i++)                
                {
                    int rdesh = rm.row + index[i][0];
                    int cdesh = rm.col + index[i][1];

                    if(rdesh<0 || cdesh<0 || rdesh>=r || cdesh>=c || visited[rdesh][cdesh] == true )
                    {
                        continue;
                    }            
                    if(arr[rdesh][cdesh] == 1)
                    {
                        return level;
                    }
                    else
                    {                        
                        queue.addLast(new Pair(rdesh,cdesh));
                        visited[rdesh][cdesh] = true;
                    }        
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        

        int r= scn.nextInt();
        int c = scn.nextInt();

        int[][]  arr = new int[r][c];

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();        
        System.out.println(findbridge(arr, r, c));
    }
}
