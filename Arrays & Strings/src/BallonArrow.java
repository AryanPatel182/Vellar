import java.util.*;
import java.io.*;

public class BallonArrow {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[][] points = new int[n][2];

        for(int i= 0; i<n ; i++)
        {
            points[i][0] = scn.nextInt();
            points[i][1] = scn.nextInt();
        }
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int lep = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lep) {
                arrows = arrows + 1;
                lep = points[i][1];
            }
        }

        System.out.println(arrows);

        scn.close();

    }
}
