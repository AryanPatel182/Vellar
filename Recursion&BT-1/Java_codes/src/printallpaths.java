import java.util.*;
import java.io.*;

public class printallpaths {
    public static void printhelper(int[][] arr, int i, int j, String util)
    {
        if(i>arr.length-1 || j>arr[0].length-1)
        {
            return;
        }        
        if (i == arr.length-1 && j == arr[0].length-1) {
            // System.out.println("Hello");            
            System.out.println(util+arr[i][j]);
            return;
        }
        printhelper(arr, i+1, j, util+arr[i][j]+"-");
        printhelper(arr, i, j+1, util+arr[i][j]+"-");    
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

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }

        printhelper(arr,0,0,"");
        scn.close();

    }
}
