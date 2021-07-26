import java.util.*;
import java.io.*;

public class AsFarFromLandAsPossible {
    public static class Pair {
        int row;
        int col;
        

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int[][]  index = {{1,0},{-1,0},{0,1},{0,-1}};

    public static int Asfarfromland(int[][] arr, int r, int c, LinkedList<Pair> queue)
    {
        int ans = -1;
        while(queue.size()>0)
        {        
            int size = queue.size();
            ans+=1;                        
            for(int k=0; k<size; k++)
            {
                Pair rm = queue.removeFirst();
                for(int i=0; i<index.length; i++)
                {
                    int rdesh = rm.row + index[i][0];
                    int cdesh = rm.col + index[i][1];

                    if(rdesh>=0 && cdesh>=0 && rdesh<r && cdesh<c && arr[rdesh][cdesh] == 0)
                    {
                        queue.addLast(new Pair(rdesh,cdesh));                
                        arr[rdesh][cdesh] = 1;
                    }
                }
            }
        }

        return ans;
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

        LinkedList<Pair> queue = new LinkedList<>();
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                arr[i][j] = scn.nextInt();
                if(arr[i][j] == 1)
                {
                    queue.addLast(new Pair(i,j));
                }
            }            
        }
        scn.close();

        System.out.println(Asfarfromland(arr, r, c, queue));

    }
}
