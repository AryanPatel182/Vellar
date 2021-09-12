import java.util.*;
import java.io.*;

public class WeakTypingChapter1 {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
		int t =  scn.nextInt();
        int k = 1;
		while(t-- > 0)
		{
			int n = scn.nextInt();
            String s = scn.next();

            char prev = 'F';
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'O') {
                    if (prev == 'X') {
                        count += 1;
                    }
                    prev = 'O';
                } else if (s.charAt(i) == 'X') {
                    if (prev == 'O') {
                        count += 1;
                    }
                    prev = 'X';
                }
            }

            System.out.println("Case #"+k+": "+count);
            k+=1;
		}
        scn.close();
	}
}


