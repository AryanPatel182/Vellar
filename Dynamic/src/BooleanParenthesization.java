import java.util.*;
import java.io.*;

public class BooleanParenthesization {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s1 = scn.next();
        String s2 = scn.next();
        scn.close();
        int n = s1.length();
        


        int[][] dpt = new int[n][n];
        int[][] dpf = new int[n][n];


        for(int g = 0 ; g < n ; g++)
        {
            for(int i = 0 , j = g ; j<n ; i++ , j++)
            {
                if(g==0)
                {
                    char ch = s1.charAt(i);

                    if(ch == 'T')
                    {
                        dpt[i][j] = 1;
                        dpf[i][j] = 0;
                    }
                    else
                    {
                        dpt[i][j] = 0;
                        dpf[i][j] = 1;
                    }
                }
                else 
                {
                    for(int k = i ; k < j ; k++ )
                    {
                        // lt - rt
                        // lt - rf
                        // lf - rt
                        // lf - rf

                        int lt = dpt[i][k] ;
                        int rt = dpt[k+1][j];
                        int lf = dpf[i][k];
                        int rf = dpf[k+1][j];
                        char oprt = s2.charAt(k);
                        if(oprt == '&')
                        {
                            dpt[i][j] += lt*rt;
                            dpf[i][j] += lt*rf + lt*rt + rt*lf;
                        }
                        else if(oprt == '|')
                        {
                            dpt[i][j] += lt*rt + lt*rf + lf*rt;
                            dpf[i][j] += lf*rf;
                        }
                        else 
                        {
                            dpt[i][j] += lt*rf + lf*rt;
                            dpf[i][j] += lt*rt + lf*rf;
                        }
                    }
                }
                
            }
        }

        System.out.println(dpt[0][n-1]);


        

    }
}
