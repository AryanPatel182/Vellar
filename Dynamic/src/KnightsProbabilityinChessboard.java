import java.util.*;
import java.io.*;

public class KnightsProbabilityinChessboard {

    public static boolean Isvalid(int nx , int ny, int n) {
        if(nx>=0 && ny>=0 && nx<n && ny<n)
        {
            return true;
        }
        return false;        
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();

        double[][] curr = new double[n][n];
        double[][] next = new double[n][n];

        curr[r][c] = 1;
        for(int itr = 1 ; itr <= k ; itr++)
        {
            for(int i = 0 ; i<n; i++)
            {
                for(int j = 0 ; j<n ; j++)
                {       
                    if(curr[i][j] !=0)                             
                    {
                        int nx = 0;
                        int ny = 0;

                        nx = i - 2;
                        ny = j + 1;
                        if (Isvalid(nx, ny, n)) {
                            next[nx][ny] += curr[i][j] / 8.0;
                        }

                        nx = i - 1;
                        ny = j + 2;
                        if (Isvalid(nx, ny, n)) {
                            next[nx][ny] += curr[i][j] / 8.0;
                        }

                        nx = i + 1;
                        ny = j + 2;
                        if (Isvalid(nx, ny, n)) {
                            next[nx][ny] += curr[i][j] / 8.0;
                        }

                        nx = i + 2;
                        ny = j + 1;
                        if (Isvalid(nx, ny, n)) {
                            next[nx][ny] += curr[i][j] / 8.0;
                        }

                        nx = i + 1;
                        ny = j - 2;
                        if (Isvalid(nx, ny, n)) {
                            next[nx][ny] += curr[i][j] / 8.0;
                        }

                        nx = i + 2;
                        ny = j - 1;
                        if (Isvalid(nx, ny, n)) {
                            next[nx][ny] += curr[i][j] / 8.0;
                        }

                        nx = i - 1;
                        ny = j - 2;
                        if (Isvalid(nx, ny, n)) {
                            next[nx][ny] += curr[i][j] / 8.0;
                        }

                        nx = i - 2;
                        ny = j - 1;
                        if (Isvalid(nx, ny, n)) {
                            next[nx][ny] += curr[i][j] / 8.0;
                        }
                    }
                    
                }
            }
            
            curr = next;
            next = new double[n][n];            
        }
        scn.close();
        
        double sum = 0;
        for(int i = 0 ; i<n ;i++)
        {
            for(int j = 0 ; j<n ; j++)
            {
                sum+= curr[i][j];
            }
        }

        System.out.println(sum);

    }
}
