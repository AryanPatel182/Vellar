/* package codechef; // don't place package name! */

import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class TicTacTao {

    public static int check(int[][] arr, int m, int n , int k) {

        for (int i = 0; i < m - k + 1; i++) {

            for (int j = 0; j < n - k + 1; j++) {

                int tmp = arr[i][j];
                int count = 0;
                for(int r = i ; r<i+k ; r++)
                {
                    for(int c=j ; c<j+k ; c++)
                    {
                        if(arr[r][c] == tmp)
                        {
                            count++;
                        }
                    }
                }

                if(count == k*k)
                {
                    return tmp;
                }
                
            }
        }        
        return 3;
    }

    public static void main(String[] args) throws java.lang.Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        
        int t = scn.nextInt();

        while (t != 0) {
            int m = scn.nextInt();
            int n = scn.nextInt();
            int k = scn.nextInt();

            int[][] arr = new int[m][n];
            int flag = 0;
            for (int i = 0; i < m * n; i++) {
                
                int a = scn.nextInt();
                int b = scn.nextInt();

                if (i % 2 == 0) {
                    arr[a - 1][b - 1] = 1;
                } else {
                    arr[a - 1][b - 1] = 2;
                }

                // for(int p1 =0; p1<m ; p1++)
                // {
                //     for(int p2= 0 ; p2<n ;p2++)
                //     {
                //         System.out.print(arr[p1][p2]);
                //     }
                //     System.out.println();
                // }
                // System.out.println();
                
                int ans = check(arr, m, n ,k);

                if(flag ==0){
                // System.out.println(ans);
                    if (ans == 1) {
                        System.out.println("Alice");
                        flag = 1;
                        
                    } else if (ans == 2) {
                        System.out.println("Bob");
                        flag = 1;
                    }        
                    else if(i==m*n-1)            
                    {
                        System.out.println("Draw");
                        flag = 1;
                        // break;
                    }        
                }        
            }
            t--;
        }
        scn.close();
        
        // your code goes here
    }
}
