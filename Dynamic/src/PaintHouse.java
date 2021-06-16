import java.util.*;
import java.io.*;

public class PaintHouse {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int[][] arr = new int[n][3];

        for(int i = 0; i<n ;i++)
        {
            for(int j = 0; j<3 ; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        int or = arr[0][0];
        int ob = arr[1][0];
        int og = arr[2][0];
        
        for(int i = 1 ; i<n ; i++)
        {
            int nr = Math.min(ob,og) + arr[i][0];
            int nb = Math.min(or,og) + arr[i][1];
            int ng = Math.min(or, ob) + arr[i][2];

            or = nr;
            ob = nb;
            og = ng;
        }

        System.out.println(Math.min(or, Math.min(ob, og)));
        scn.close();
    }
}
