import java.util.*;
import java.io.*;

public class knights_tour {
    
    public static void display(int[][] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printKnights(int[][] arr, int r, int c, int move) {

        if(r<0 || c<0 || r>=arr.length || c>=arr[0].length || arr[r][c]!=0)
        {            
            return;
        }
        else if(move == arr.length * arr[0].length)
        {
            arr[r][c] = move;
            display(arr);
            arr[r][c] = 0;
            return;
        }
        
        arr[r][c] = move;
        printKnights(arr, r-2, c+1, move+1);
        printKnights(arr, r-1, c+2, move+1);
        printKnights(arr, r+1, c+2, move+1);
        printKnights(arr, r+2, c+1, move+1);
        printKnights(arr, r+2, c-1, move+1);
        printKnights(arr, r+1, c-2, move+1);
        printKnights(arr, r-1, c-2, move+1);
        printKnights(arr, r-2, c-1, move+1);
        arr[r][c] = 0;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int r = scn.nextInt();
        int c = scn.nextInt();
        int arr[][] = new int[r][c];
        scn.close();

        
        printKnights(arr,r,c,1);

    }
}
