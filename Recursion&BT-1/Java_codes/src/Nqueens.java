import java.util.*;
import java.io.*;

public class Nqueens {

    public static void printNqueens(int[][] arr , int r, int c, String util) {
        
        if(r==arr.length)
        {
            System.out.println(util);
            return;
        }

        for(int j=0;  j< arr.length; j++)
        {
            if(IsSafe(arr,r,j)== true){
                arr[r][j] = 1;
                printNqueens(arr, r+1, j, util+j+"-");
                arr[r][j] = 0;
            }
        }
    }
    
    public static boolean IsSafe(int[][] arr, int r, int c)
    {
        for(int i=r-1, j=c ; i>=0; i--)
        {
            if(arr[i][j]==1)
            {
                return false;
            }
        }
        for(int i=r-1, j=c-1 ; i>=0 && j>=0; i-- , j--)
        {
            if(arr[i][j]==1)
            {
                return false;
            }
        }
        for(int i=r-1, j=c+1 ; i>=0 && j<=arr.length-1; i-- , j++)
        {
            if(arr[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        scn.close();
        int[][] arr = new int[n][n];

        printNqueens(arr,0,0,"");

    }
}
