import java.util.*;
import java.io.*;

public class print_maze_path {

    public static void maze(int sr,int sc,int er,int ec,String util) {
        if(sr==er && sc==ec)
            System.out.println(util);
        
        if(sc<ec)
            maze(sr, sc+1, er, ec, util+'h');
        if(sr<er)
            maze(sr+1, sc, er, ec, util+'v');
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i] = 0;
            }
        }
        scn.close();
        
        maze(0,0,n-1,n-1,"");

    }
}
