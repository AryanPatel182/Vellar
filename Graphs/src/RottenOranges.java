import java.util.*;
import java.io.*;

public class RottenOranges {
    public static int[][] index = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public static int rottenoranges(int[][] arr ,int r, int c , int fresh)
    {
        if(fresh == 0)
        {
            return 0;
        }

        LinkedList<Pair> queue = new LinkedList<>();
        int level = -1;
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(arr[i][j] == 2)
                {
                    queue.addLast(new Pair(i,j));
                }
            }
        }

        while(queue.size()>0)
        {            
            int size = queue.size();
            
            level+=1;
            System.out.println();
            for(int k=0; k<size;k++)
            {
                Pair rm = queue.removeFirst();
                System.out.println(rm.row + " " + rm.col);
                for(int x=0; x<index.length;x++)
                {                    
                    int rdesh = rm.row + index[x][0];
                    int cdesh = rm.col + index[x][1];

                    if(rdesh>=0 && cdesh>=0 && rdesh<=r-1 && cdesh<= c-1 && arr[rdesh][cdesh] == 1)
                    {
                        queue.addLast(new Pair(rdesh,cdesh));
                        arr[rdesh][cdesh] = 0;
                        fresh--;
                    }
                }
            }                        
        }        
        if(fresh == 0)
        {
            return level;
        }
        return -1;
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

        int fresh = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scn.nextInt();
                if(arr[i][j] == 1)
                {
                    fresh += 1; 
                }
            }
        }

        scn.close();        
        int ans = rottenoranges(arr, r, c, fresh);
        System.out.println(ans);

    }
}
