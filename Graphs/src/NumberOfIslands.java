import java.util.*;
import java.io.*;

public class NumberOfIslands {

    public static class Edge {
        int self;
        int nbr;
        int val;

        Edge(int self, int nbr, int val) {
            this.self = self;
            this.nbr = nbr;
            this.val = val;
        }
    }

    public static void printConnectedPaths(int[][] arr, int i , int j , boolean[][] visited) {

        if(i>=arr.length || i<0 || j<0 || j>=arr[0].length || arr[i][j] == 1 || visited[i][j] == true)
        {
            return;
        }
        visited[i][j]= true;
    
        printConnectedPaths(arr, i, j+1, visited);    
        printConnectedPaths(arr, i, j -1, visited);    
        printConnectedPaths(arr, i+1, j, visited);
        printConnectedPaths(arr, i-1, j , visited);
    

    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);


        int r =  scn.nextInt();
        int c = scn.nextInt();
        int[][] arr = new int[r][c];
        boolean[][] visited = new boolean[arr.length][arr[0].length];        

        for(int i = 0 ; i<arr.length ; i++)
        {
            for(int j = 0 ; j < arr[0].length ; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                if(arr[i][j] == 0 && visited[i][j] == false)
                {
                    printConnectedPaths(arr, i , j , visited);
                    count++;
                }
            }
        }        

        System.out.println(count);



    
        scn.close();

    }

}
