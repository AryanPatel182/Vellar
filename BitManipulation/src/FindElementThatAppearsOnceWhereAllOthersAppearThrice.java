import java.util.*;
import java.io.*;

public class FindElementThatAppearsOnceWhereAllOthersAppearThrice {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr =  new int[n];

        for(int i = 0 ;  i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        scn.close();

        int m3 = Integer.MAX_VALUE;
        int m3p1 = 0;
        int m3p2 = 0;


        for(int i = 0 ; i<n; i++)
        {
            int val = arr[i];
            
            int nm3 = (val & m3);
            int nm3p1 = (val & m3p1);
            int nm3p2 = (val & m3p2);

            m3 = m3 & (~nm3);
            m3p1 =  m3p1 | nm3;

            m3p1 = m3p1 & (~nm3p1);
            m3p2 = m3p2 | nm3p1;

            m3p2 = m3p2 & (~nm3p2);
            m3 = m3 | nm3p2;
        }

        System.out.println(m3p1);
    

    }
}
