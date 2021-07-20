import java.util.*;
import java.io.*;

public class NQUeensProblem {
    public static void solution(boolean[][] boards, int n , int row, int cols,int ndiag, int rdiag, String psf) 
    {
     
        if(row == n)
        {
            System.out.println(psf);
            return;
        }
        for(int col = 0; col < n; col++)
        {
            if(((1<<col & cols) ==0) && (((1<<row+col) & ndiag) ==0) && ( ((1<<row-col+n-1 & rdiag) ==0)))
            {
                cols = cols ^ (1<<col);
                ndiag = ndiag ^ (1<<row+col);
                rdiag = rdiag ^ (1<<row-col+n-1);
                boards[row][col] = true;

                solution(boards, n, row+1, cols, ndiag, rdiag, psf + row + "-" + col + ",");

                cols = cols ^ (1 << col);
                ndiag = ndiag ^ (1 << row + col);
                rdiag = rdiag ^ (1 << row - col + n - 1);
                boards[row][col] = false;
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
        boolean[][] boards = new boolean[n][n];
        int cols = 0;
        int ndiag = 0;
        int rdiag = 0;
        solution(boards, n,0,cols,ndiag,rdiag,"");
        scn.close();

    }
}
