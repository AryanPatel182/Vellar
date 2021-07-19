import java.util.*;
import java.io.*;

public class FindElemntAppearOnceInArray {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n =scn.nextInt();
        int[]arr = new int[n];

        for(int i=0 ; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int uni = 0;
        for(int ele : arr)
        {
            uni = uni^ele;
        }

        scn.close();
        System.out.println(uni);

    }
}
