import java.util.*;

public class SayNoToPalindromes {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        int m = scn.nextInt();

        String s = scn.next();
        String[] data = {"abc","acb","bac","bca","cab","cba"};

        int[][] difr = new int[6][n];

        for(int k=0; k<6; k++)
        {
            // int diff = 0;
            for(int i=0;i<n;i++)
            {
                difr[k][i] = (data[k].charAt(i%3) != s.charAt(i) ? 1 : 0) + (i==0 ? 0: difr[k][i-1]);
            }
        }

        for(int i=0; i<m; i++)
        {
            int l = scn.nextInt()-1;
            int h = scn.nextInt()-1;            

            int min = Integer.MAX_VALUE;

            for(int k=0; k<6; k++)
            {
                min = Math.min(min, difr[k][h] - (l==0 ? 0: difr[k][l-1]) );
            }

            System.out.println(min);
        }

    }
}