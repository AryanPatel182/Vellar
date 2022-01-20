import java.util.*;
import java.io.*;

public class CHOCOLA {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int t = scn.nextInt();     
        while(t-- >0)
        {
            scn.next();
            int v = scn.nextInt();
            int h = scn.nextInt();            
            Integer[] vert = new Integer[v-1];
            Integer[] horz = new Integer[h-1];
            for(int i=0; i<v-1; i++) vert[i] = scn.nextInt();
            for(int i=0; i<h-1; i++) horz[i] = scn.nextInt();

            Arrays.sort(vert, Collections.reverseOrder());
            Arrays.sort(horz, Collections.reverseOrder());

            int i = 0, j = 0;
            int hcut = 1;            
            int vcut = 1;
            long sum = 0;
            while(i<v-1 && j<h-1)
            {
                if(vert[i] >= horz[j])
                {                    
                    sum = sum + vcut*vert[i];
                    hcut+=1;
                    i+=1;
                }
                else if(vert[i] < horz[j])
                {                    
                    sum = sum + hcut*horz[j];
                    vcut+=1;
                    j+=1;
                }                
            }
            while(i<v-1)
            {                
                sum = sum + vcut*vert[i];
                hcut+=1;
                i+=1;                
                
            }
            while (j < h - 1) {                
                sum = sum + hcut * horz[j];
                vcut += 1;
                j += 1;                

            }
            
            System.out.println(sum);
        }
        scn.close();

    }
}
