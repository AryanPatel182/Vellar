import java.util.*;
import java.io.*;

public class ZerosAndOnesKadens {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s = scn.next();

        int n = s.length();

        int csum = s.charAt(0)-49;
        int osum = csum; 
        for(int i = 1 ; i<n; i++)
        {
            int val = s.charAt(i)-48;
            if(val==0)
            {
                val = 1;
            }
            else{
                val = -1;
            }
            
            if(csum > 0)
            {
                csum+= val;
            }
            else{
                csum = val;
            }

            osum = Math.max(osum, csum);
        }

        osum = osum == 0 ? -1:osum;
        scn.close();
        System.out.println(osum);

    }
}
