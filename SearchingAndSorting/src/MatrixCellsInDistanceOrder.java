import java.util.*;
import java.io.*;


public class MatrixCellsInDistanceOrder {
    public static class Pair implements Comparable<Pair>
    {
        int r;
        int c;
        int dis;

        Pair(int r, int c, int dis)
        {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }

        public int compareTo(Pair o)
        {
            return this.dis - o.dis;
        }
    }
    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) 
    {
        Pair[] arr =  new Pair[rows*cols];
        int k = 0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                arr[k] = new Pair(i,j,Math.abs(rCenter - i) + Math.abs(cCenter - j));
                k+=1;
            }
        }

        Arrays.sort(arr);
        int[][] ans = new int[rows*cols][2];
        for(int i=0; i<rows*cols; i++)
        {            
            ans[i][0] = arr[i].r;
            ans[i][1] = arr[i].c;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int rows = scn.nextInt();
        int cols = scn.nextInt();

        int rCenter = scn.nextInt();
        int cCenter = scn.nextInt();

        int[][] ans = allCellsDistOrder(rows, cols, rCenter, cCenter);
        // System.out.println(ans);
        for(int i=0; i<ans.length; i++)
        {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
        scn.close();

    }
}
